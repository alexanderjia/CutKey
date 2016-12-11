package com.example.zhangjia.cutkey.background.bean;

public class UnlockToolCodeSerial
{
	/**
	 * @param no
	 * @param serialIndex
	 * @param manufacturesName
	 * @param serial
	 */
	public UnlockToolCodeSerial(int no, int serialIndex,
			String manufacturesName, String serial)
	{
		super();
		this.no = no;
		this.serialIndex = serialIndex;
		this.manufacturesName = manufacturesName;
		this.serial = serial;
	}

	/**
	 * 编号
	 */
	private int no;
	
	/**
	 * 序列码编号
	 */
	private int serialIndex;
	
	/**
	 * 包含的车厂
	 */
	private String manufacturesName;
	
	/**
	 * 序列码
	 */
	private String serial;

	/**
	 * @return the no
	 */
	public int getNo()
	{
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no)
	{
		this.no = no;
	}

	/**
	 * @return the serialIndex
	 */
	public int getSerialIndex()
	{
		return serialIndex;
	}

	/**
	 * @param serialIndex the serialIndex to set
	 */
	public void setSerialIndex(int serialIndex)
	{
		this.serialIndex = serialIndex;
	}

	/**
	 * @return the manufacturesName
	 */
	public String getManufacturesName()
	{
		return manufacturesName;
	}

	/**
	 * @param manufacturesName the manufacturesName to set
	 */
	public void setManufacturesName(String manufacturesName)
	{
		this.manufacturesName = manufacturesName;
	}

	/**
	 * @return the serial
	 */
	public String getSerial()
	{
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial)
	{
		this.serial = serial;
	}
}
