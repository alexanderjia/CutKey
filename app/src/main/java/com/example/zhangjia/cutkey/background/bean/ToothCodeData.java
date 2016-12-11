package com.example.zhangjia.cutkey.background.bean;

import java.util.List;

/**
 * 齿形编码数据
 * @author admini
 *
 */
public class ToothCodeData
{
	/**
	 * @param toothCode
	 * @param depth
	 */
	public ToothCodeData(char toothCode, int depth)
	{
		super();
		this.toothCode = toothCode;
		this.depth = depth;
	}

	public ToothCodeData() {
	}

	/**
	 * 编码代号
	 */
	private char toothCode;
	/**
	 * 编码数据
	 */
	private int depth;
	
	
	/**
	 * @return the toothCode
	 */
	public char getToothCode()
	{
		return toothCode;
	}
	/**
	 * @param toothCode the toothCode to set
	 */
	public void setToothCode(char toothCode)
	{
		this.toothCode = toothCode;
	}
	/**
	 * @return the depth
	 */
	public int getDepth()
	{
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
}
