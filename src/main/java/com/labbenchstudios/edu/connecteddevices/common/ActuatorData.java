package com.labbenchstudios.edu.connecteddevices.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActuatorData {

	public static final int COMMAND_OFF = 0;
	public static final int COMMAND_ON = 1;
	public static final int COMMAND_SET = 2;
	public static final int COMMAND_RESET = 3;
	public static final int STATUS_IDLE = 0;
	public static final int STATUS_ACTIVE = 1;
	public static final int ERROR_OK = 0;
	public static final int ERROR_COMMAND_FAILED = 1;
	public static final int ERROR_NON_RESPONSIBLE = -1;

	private String name = "Actuator Data";
	private String timeStamp = null;
	private boolean hasError = false;
	private int command = 0;
	private int errCode = 0;
	private int statusCode = 0;
	private String stateData = null;
	private float val = 0.0f;

	public ActuatorData() {
		super();
		updateTimeStamp();
	}

	private void updateTimeStamp() {
		timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm.ss").format(new Date());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	/**
	 * This method is to return error code type
	 * 
	 * @return: 'errCode', 0 - Okay, 1 - failed, -1 - not responsive
	 */
	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStateData() {
		return stateData;
	}

	public void setStateData(String stateData) {
		this.stateData = stateData;
	}

	public float getVal() {
		return val;
	}

	public void setVal(float val) {
		this.val = val;
	}

	public void updateData(ActuatorData data) {
		this.command = data.getCommand();
		this.statusCode = data.getStatusCode();
		this.errCode = data.getErrCode();
		this.stateData = data.getStateData();
		this.val = data.getVal();
	}
	/*
	 *to return the temp values
	 */
	
	public String toString() {
		String st;
		st = ("Name: " + name + "\n" + "time: " + timeStamp + "\n" + "Command: " + command + "\n" + "Status Code: "
				+ statusCode + "\n" + "Error Code: " + errCode + "\n" + "State Data: " + stateData + "\n" + "Value: "
				+ val + "\n");
		return st;
	}
}