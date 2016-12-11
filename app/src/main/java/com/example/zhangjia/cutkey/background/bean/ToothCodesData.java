package com.example.zhangjia.cutkey.background.bean;

import java.util.List;

public class ToothCodesData
{
	/**
	 * @param data
	 */
	public ToothCodesData(List<ToothCodeData> data)
	{
		super();
		this.data = data;
	}

	public ToothCodesData() {
	}

	private List<ToothCodeData> data;

	/**
	 * @return the data
	 */
	public List<ToothCodeData> getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<ToothCodeData> data)
	{
		this.data = data;
	}
	
}
