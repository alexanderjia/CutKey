package com.example.zhangjia.cutkey.background.bean;

import java.util.List;

public class KeyShapeDatas
{
	/**
	 * @param axis
	 * @param data
	 */
	public KeyShapeDatas(int axis, List<KeyShapeData> data)
	{
		super();
		this.axis = axis;
		this.data = data;
	}

	public KeyShapeDatas() {
	}

	private int axis;
	
	private List<KeyShapeData> data;

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
	public List<KeyShapeData> getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<KeyShapeData> data)
	{
		this.data = data;
	}
}
