package com.labbenchstudios.edu.connecteddevices.common;

import com.google.gson.Gson;

import neu.vishald.connecteddevices.labs.module05.TempEmulatorAdaptorTask;

public class DataUtil {

	/*
	 * This method will accept a SensorData object and convert it and then return
	 * its contents as a JSON string
	 */
	public String SensorDataToJson(SensorData sensordata) {
		String jsonSd;
		Gson gson = new Gson();
		jsonSd = gson.toJson(sensordata);
		return jsonSd;
	}

	/*
	 * This method will accept a ActuatorData object as a parameter, convert and
	 * then return its contents as a JSON string
	 */
	public String ActuatorDataToJson(ActuatorData actuatordata) {
		String jsonAd;
		Gson gson = new Gson();
		jsonAd = gson.toJson(actuatordata);
		return jsonAd;
	}

	/*
	 * This method will accept a JSON Data and filename object as a parameter,
	 * convert and then return its contents as a sensor data
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

	/*
	 * This method will accept a JSON Data and filename object as a parameter,
	 * convert and then return its contents as a actuator data
	 */
	public ActuatorData JsonToActuatorData(String jsondata, String filename) {
		ActuatorData actuatordata = null;
		if (filename == null) {
			Gson gson = new Gson();
			actuatordata = gson.fromJson(jsondata, ActuatorData.class);
			return actuatordata;
		} else {
			Gson gson = new Gson();
			String data = TempEmulatorAdaptorTask.FileReader(filename);
			actuatordata = gson.fromJson(data, ActuatorData.class);
			return actuatordata;
		}
	}
}
