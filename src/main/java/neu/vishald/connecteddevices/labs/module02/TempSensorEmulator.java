package neu.vishald.connecteddevices.labs.module02;

import java.util.logging.Level;

import com.labbenchstudios.edu.connecteddevices.common.SensorData;
import com.labbenchstudios.edu.connecteddevices.common.ServiceResourceInfo;

public class TempSensorEmulator extends Thread {
	SensorData sensor;
	/*
	 * This class TempSensorEmulator uses a thread which is used to run the
	 * temperature values from 0 to 30
	 */

	public TempSensorEmulator() {
		sensor = new SensorData(10, 30);

	}

	/*
	 * The run() function in the thread is used to obtain the sensor values from
	 * SensorData class. The threshold value which is average value +10 and is
	 * initialized in an If statement which if true sends the temperature value
	 * ranging with the threshold to an email address given in the Config.props.
	 */
	@Override
	public void run() {
//		int i = 1;
		while (true) {
			double current = getValue(this.sensor.getMinValue(), this.sensor.getMaxValue());
			this.sensor.addValue((float) current);
			System.out.println(this.sensor.toString());
			if (current > (this.sensor.getAvgValue() + 5)) {
				System.out.println("Warning: Temperature has increased!! Current Temp: " + current);
				try {
					SmtpClientConnector1.sendMail("vishalcd.iot@gmail.com", this.sensor.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public double getValue(float min, float max) {
		double curr = 0;

		curr = (Math.random() * ((max - min) + 1)) + min;

		return curr;
	}
}
