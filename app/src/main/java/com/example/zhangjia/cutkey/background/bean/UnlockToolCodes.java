package com.example.zhangjia.cutkey.background.bean;

public class UnlockToolCodes
{
	/**
	 * @param no
	 * @param unlockToolCodeIndex
	 * @param unlockToolCodeName
	 * @param manufacturesName
	 * @param serial
	 * @param cuts
	 * @param picSrc
	 */
	public UnlockToolCodes(int no, int unlockToolCodeIndex,
			String unlockToolCodeName, String manufacturesName, String serial,
			String cuts, String picSrc)
	{
		super();
		this.no = no;
		this.unlockToolCodeIndex = unlockToolCodeIndex;
		this.unlockToolCodeName = unlockToolCodeName;
		this.manufacturesName = manufacturesName;
		this.serial = serial;
		this.cuts = cuts;
		this.picSrc = picSrc;
	}

	/**
	 * @param no
	 * @param unlockToolCodeIndex
	 * @param unlockToolCodeName
	 * @param manufacturesName
	 * @param serial
	 * @param cuts
	 */
	public UnlockToolCodes(int no, int unlockToolCodeIndex,
			String unlockToolCodeName, String manufacturesName, String serial,
			String cuts)
	{
		super();
		this.no = no;
		this.unlockToolCodeIndex = unlockToolCodeIndex;
		this.unlockToolCodeName = unlockToolCodeName;
		this.manufacturesName = manufacturesName;
		this.serial = serial;
		this.cuts = cuts;
	}

	/**
	 * 编号
	 */
	private int no;
	
	/**
	 * 开锁工具编号
	 */
	private int unlockToolCodeIndex;
	
	/**
	 * 开锁工具名称
	 */
	private String unlockToolCodeName;
	
	/**
	 * 包含的车厂
	 */
	private String manufacturesName;
	
	/**
	 * 包含的序列码
	 */
	private String serial;
	
	/**
	 * 齿数
	 */
	private String cuts;
	
	/**
	 * 图片
	 */
	private String picSrc;
	/**
	 * 首字母
	 */
	private String Fistletter;

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
	 * @return the unlockToolCodeIndex
	 */
	public int getUnlockToolCodeIndex()
	{
		return unlockToolCodeIndex;
	}

	/**
	 * @param unlockToolCodeIndex the unlockToolCodeIndex to set
	 */
	public void setUnlockToolCodeIndex(int unlockToolCodeIndex)
	{
		this.unlockToolCodeIndex = unlockToolCodeIndex;
	}

	/**
	 * @return the unlockToolCodeName
	 */
	public String getUnlockToolCodeName()
	{
		return unlockToolCodeName;
	}

	/**
	 * @param unlockToolCodeName the unlockToolCodeName to set
	 */
	public void setUnlockToolCodeName(String unlockToolCodeName)
	{
		this.unlockToolCodeName = unlockToolCodeName;
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

	/**
	 * @return the cuts
	 */
	public String getCuts()
	{
		return cuts;
	}

	/**
	 * @param cuts the cuts to set
	 */
	public void setCuts(String cuts)
	{
		this.cuts = cuts;
	}

	/**
	 * @return the picSrc
	 */
	public String getPicSrc()
	{
		return picSrc;
	}

	/**
	 * @param picSrc the picSrc to set
	 */
	public void setPicSrc(String picSrc)
	{
		this.picSrc = picSrc;
	}

	public String getFistletter() {
		return Fistletter;
	}

	public void setFistletter(String fistletter) {
		Fistletter = fistletter;
	}
}
