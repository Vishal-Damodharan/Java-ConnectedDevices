package com.labbenchstudios.edu.connecteddevices.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * this class contains sensor data's and attributes
 */
public class SensorData {

	private Integer sampleCount = 0;
	private Double curValue;
	private Double maxValue;
	private Double minValue;
	private Double totValue;
	private Double diffValue;
	private Double avgValue;
	private String time;
	private String name;
	final String degree = "\u00b0";

	/*
	 * Sensor data constructor
	 */
	public SensorData(Double maxValue, Double minValue, String time, String name) {
		super();
		this.maxValue = maxValue;
		this.minValue = minValue;
		this.time = time;
		this.name = name;
	}

	public Double getCurValue() {
		return curValue;
	}

	public void setCurValue(Double curValue) {
		this.curValue = curValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getTotValue() {
		return totValue;
	}

	public void setTotValue(Double totValue) {
		this.totValue = totValue;
	}

	public Double getDiffValue() {
		return diffValue;
	}

	public void setDiffValue(Double diffValue) {
		this.diffValue = diffValue;
	}

	public Double getAvgValue() {
		return avgValue;
	}

	public void setAvgValue(Double avgValue) {
		this.avgValue = avgValue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getSampleCount() {
		return sampleCount;
	}

	public void setSampleCount(Integer sampleCount) {
		this.sampleCount = sampleCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String string = "\nTime: " + this.getTime() + "\n" + "\ncurValue: " + this.getCurValue() + "\navgValue: "
				+ this.getAvgValue() + "\nminValue: " + this.getMinValue() + "\nmaxValue: " + this.getMaxValue() + "\n";
		return string;
	}

	// This method is used for increment in samplecount value
	public void addValue() {
		this.setSampleCount(this.getSampleCount() + 1);
	}

	/*
	 * Updates the timestamp to current time
	 */
	public void updateTimeStamp() {
		this.time = new SimpleDateFormat("yyyy.MM.dd HH:mm.ss").format(new Date());
	}

	/*
	 * Function adds current value to calculate average value
	 */
	public void updateValue(float val) {
		updateTimeStamp();
		++this.sampleCount;
		this.curValue = (double) val;
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

	public Double getSD() {
		return curValue;
	}

}