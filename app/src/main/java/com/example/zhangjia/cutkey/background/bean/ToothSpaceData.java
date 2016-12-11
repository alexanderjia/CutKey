package com.example.zhangjia.cutkey.background.bean;

import java.util.List;

public class ToothSpaceData
{
	/**
	 * @param axis
	 * @param data
	 */
	public ToothSpaceData(int axis, List<AxisData> data)
	{
		super();
		this.axis = axis;
		this.data = data;
	}

	public ToothSpaceData() {
	}

	private int axis;
	
	private List<AxisData> data;

	/**
	 * @return the axis
	 */
	public int getAxis()
	{
		return axis;
	}

	/**
	 * @param axis the axis to set
	 */
	public void setAxis(int axis)
	{
		this.axis = axis;
	}

	/**
	 * @return the data
	 */
	public List<AxisData> getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<AxisData> data)
	{
		this.data = data;
	}
}
