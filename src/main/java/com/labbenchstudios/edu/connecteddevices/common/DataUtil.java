package com.labbenchstudios.edu.connecteddevices.common;

import com.google.gson.Gson;

import neu.vishald.connecteddevices.labs.module05.TempEmulatorAdaptorTask;

/*
 * This class is to covert json to sensordata and sensor data to jsondata
 */
public class DataUtil {

	/*
	 * This method will accept a SensorData as a parameter and returns a JSON string
	 */
	public String SensorDataToJson(SensorData sensordata) {
		String jsonSd;
		Gson gson = new Gson();
		jsonSd = gson.toJson(sensordata);
		return jsonSd;
	}

	/*
	 * This method will accept a JSON string as a parameter and returns as
	 * SensorData
	 */
	public SensorData JsonToSensorData(String jsondata, String filename) {
		SensorData sensorData = null;

		if (filename == null) {
			Gson gson = new Gson();
			sensorData = gson.fromJson(jsondata, SensorData.class);
			return sensorData;
		}

		else {
			Gson gson = new Gson();
			String data = TempEmulatorAdaptorTask.FileReader(filename);
			sensorData = gson.fromJson(data, SensorData.class);
			return sensorData;
		}
	}
}
