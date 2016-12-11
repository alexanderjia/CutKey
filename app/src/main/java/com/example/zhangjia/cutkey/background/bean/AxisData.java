package com.example.zhangjia.cutkey.background.bean;

import java.util.List;

public class AxisData
{
	/**
	 * @param axisDatas
	 */
	public AxisData(List<ToothCutLengthData> axisDatas)
	{
		super();
		this.axisDatas = axisDatas;
	}

	private List<ToothCutLengthData> axisDatas;

	/**
	 * @return the axisDatas
	 */
	public List<ToothCutLengthData> getAxisDatas()
	{
		return axisDatas;
	}

	/**
	 * @param axisDatas the axisDatas to set
	 */
	public void setAxisDatas(List<ToothCutLengthData> axisDatas)
	{
		this.axisDatas = axisDatas;
	}
}
