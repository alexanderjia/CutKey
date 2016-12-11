package com.example.zhangjia.cutkey.background.bean;

import java.util.List;

public class ToothCodesDatas
{
	/**
	 * @param axis
	 * @param data
	 */
	public ToothCodesDatas(int axis, List<ToothCodesData> data)
	{
		super();
		this.axis = axis;
		this.data = data;
	}

	public ToothCodesDatas() {
	}

	private int axis;
	
	private List<ToothCodesData> data;

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
	public List<ToothCodesData> getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<ToothCodesData> data)
	{
		this.data = data;
	}

}
