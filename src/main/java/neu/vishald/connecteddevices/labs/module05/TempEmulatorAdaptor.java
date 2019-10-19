package neu.vishald.connecteddevices.labs.module05;

import com.labbenchstudios.edu.connecteddevices.common.DataUtil;
import com.labbenchstudios.edu.connecteddevices.common.SensorData;

public class TempEmulatorAdaptor {

	/*
	 * This function is to get the instance of sensor data and datutil and read the
	 * sensordata.txt file from the specified location and it also starts the run
	 * function in the task.
	 */
	public static void demo() {
		DataUtil sensor = new DataUtil();
		SensorData sensor_variable = sensor.toSensorDataFromJson(null,
				"C:\\Users\\VISHAL\\git\\connected-devices-python\\workspace\\iot-device\\apps\\labs\\module05\\sensordata.txt");
		System.out.println(sensor_variable);
		System.out.println("------------------------------------------------");
		System.out.println("\nTemperature Reading Values from the Sense_hat:");
		TempEmulatorAdaptorTask temp = new TempEmulatorAdaptorTask();
		temp.run();
	}
}
