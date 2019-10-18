package neu.vishald.connecteddevices.labs.module05;

import java.io.*;

import com.labbenchstudios.edu.connecteddevices.common.DataUtil;
import com.labbenchstudios.edu.connecteddevices.common.SensorData;

import neu.vishald.connecteddevices.labs.module02.SmtpClientConnector1;

public class TempEmulatorAdaptorTask extends Thread {

	SensorData sensor;

	public TempEmulatorAdaptorTask() {
		sensor = new SensorData(10, 30);

	}

	/*
	 * The run() function runs a while loop to send the json data to the given email
	 * if the temperature value breaches the threshold value.
	 */
	@Override
	public void run() {
		while (true) {
			double current = getValue(this.sensor.getMinValue(), this.sensor.getMaxValue());
			this.sensor.addValue((float) current);
			System.out.println(this.sensor.toString());
			if (current > (this.sensor.getAvgValue() + 5)) {
				DataUtil data = new DataUtil();
				String json_data = data.SensorDataToJson(sensor);
				System.out.println(
						"Warning!Warning!Warning! Temperature has breached!! \n\nCurrent Temp: " + json_data + "\n");
				try {
					SmtpClientConnector1.sendMail("vishalcd.iot@gmail.com", json_data);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * This sleep function is used for the delay in between each iteration
			 */
		}

	}

	public double getValue(float min, float max) {
		double curr = 0;

		curr = (Math.random() * ((max - min) + 1)) + min;

		return curr;
	}

	/*
	 * This function is to read the Json data from python app text.
	 */
	public static String FileReader(String file) {
		String json = new String();
		try {
			FileReader fr = new FileReader(file);
			int ch;
			while ((ch = fr.read()) != -1) {
				json = json + (char) ch;
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	/*
	 * This method is used to write the JSON string data
	 */
	public static void fileWrite(String fileWriteEnable, String file, String json) {
		File jsonFile = new File(file);
		try {
			jsonFile.createNewFile();
			FileWriter writer = new FileWriter(jsonFile);
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
