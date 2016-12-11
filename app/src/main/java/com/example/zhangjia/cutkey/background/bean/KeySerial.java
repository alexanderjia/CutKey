package com.example.zhangjia.cutkey.background.bean;

/**
 * 钥匙序列号数据
 * @author admini
 *
 */
public class KeySerial
{
	/**
	 * 钥匙序列号数据
	 * @param no:编号
	 * @param serialIndex:序列编号
	 * @param serial:序列号
	 */
	public KeySerial(int no, int serialIndex, String serial)
	{
		super();
		this.no = no;
		this.serialIndex = serialIndex;
		this.serial = serial;
	}

	/**
	 * 编号
	 */
	private int no;
	
	/**
	 * 序列编号
	 */
	private int serialIndex;
	
	/**
	 * 序列号
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
