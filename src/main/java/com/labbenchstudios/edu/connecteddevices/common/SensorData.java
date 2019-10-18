package com.labbenchstudios.edu.connecteddevices.common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class SensorData implements Serializable {
	private float curValue = 0.0f;
	private float avgValue = 0.0f;
	private float minValue = 0.0f;
	private float maxValue = 0.0f;
	private float totValue = 0.0f;
	private int sampleCount = 0;
	Instant timestamp;
	final 	String degree = "\u00b0";


	public SensorData(float min, float max) {
		this.minValue = min;
		this.maxValue = max;
	}
	

	public String updateTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public float getCurValue() {
		return curValue;
	}

	public void setCurValue(float curValue) {
		this.curValue = curValue;
	}

	public float getAvgValue() {
		return avgValue;
	}

	public void setAvgValue(float avgValue) {
		this.avgValue = avgValue;
	}

	public float getMinValue() {
		return minValue;
	}

	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	public float getTotValue() {
		return totValue;
	}

	public void setTotValue(float totValue) {
		this.totValue = totValue;
	}

	public int getSampleCount() {
		return sampleCount;
	}

	public void setSampleCount(int sampleCount) {
		this.sampleCount = sampleCount;
	}

	public void addValue(float val) {
		updateTimeStamp();
		++this.sampleCount;
		this.curValue = val;
		this.totValue += val;
		if (this.curValue < this.minValue) {
			this.minValue = this.curValue;
		}
		if (this.curValue > this.maxValue) {
			this.maxValue = this.curValue;
		}
		if (this.totValue != 0 && this.sampleCount > 0) {
			this.avgValue = this.totValue / this.sampleCount;
		}
	}
	/*
	 * to return the temp values
	 */
	@Override
	public String toString() {
		return "Temperature:"+"\n\tTime:"+ updateTimeStamp() +"\n\tCurrent:" + curValue + "\n\tAverage:" + avgValue + "\n\tSample:" + sampleCount+ "\n\tMin:" + minValue + "\n\tMax:"
				+ maxValue + "\n\ttotValue=" + totValue +"\n" ;
	}

	public float getSD() {
		return curValue;
	}


	
}
