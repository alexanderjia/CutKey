package com.example.zhangjia.cutkey.background.bean;

public class MachiningHistory
{
	/**
	 * @param no
	 * @param isSerial
	 * @param serial
	 * @param keyWidth
	 * @param serialId
	 * @param serialStart
	 * @param serialIdEnd
	 * @param brand
	 * @param brandId
	 * @param cuts
	 * @param jaw
	 * @param unlockToolCodeIndex
	 * @param unlockToolCodeName
	 * @param unlockToolCode
	 * @param searchDateTime
	 */
	public MachiningHistory(int no, boolean isSerial, String serial,
			int keyWidth, int serialId, String serialStart, String serialIdEnd,
			String brand, int brandId, String cuts, String jaw,
			int unlockToolCodeIndex, String unlockToolCodeName,
			String unlockToolCode, String searchDateTime)
	{
		super();
		this.no = no;
		this.isSerial = isSerial;
		this.serial = serial;
		this.keyWidth = keyWidth;
		this.serialId = serialId;
		this.serialStart = serialStart;
		this.serialIdEnd = serialIdEnd;
		this.brand = brand;
		this.brandId = brandId;
		this.cuts = cuts;
		this.jaw = jaw;
		this.unlockToolCodeIndex = unlockToolCodeIndex;
		this.unlockToolCodeName = unlockToolCodeName;
		this.unlockToolCode = unlockToolCode;
		this.searchDateTime = searchDateTime;
	}

	public MachiningHistory() {
	}

	/**
	 * 编号	
	 */
	private int no;	
	/**
	 * 是否序列号加工
	 */
	private boolean isSerial;
	/**
	 * 加工序列号
	 */
	private String serial;	
	/**
	 * 钥匙坯宽度	
	 */
	private int keyWidth;
	/**
	 * 序列编号	
	 */
	private int serialId;
	/**
	 * 序列开始号
	 */
	private String serialStart;
	
	/**
	 * 序列结束号
	 */
	private String serialIdEnd;
	/**
	 * 车厂名称
	 */
	private String brand;
	
	/**
	 * 车厂编号
	 */
	private int brandId;
	/**
	 * 齿数
	 */
	private String	cuts;	
	/**
	 * 夹具
	 */
	private String jaw;
	/**
	 * 开锁工具编号
	 */
	private int unlockToolCodeIndex;
	
	/**
	 * 开锁工具名称
	 */
	private String unlockToolCodeName;
	/**
	 * 齿形码
	 */
	private String unlockToolCode;
	/**
	 * 加工时间	
	 */
	private String searchDateTime;
	//private DateTime searchDateTime;
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
	 * @return the isSerial
	 */
	public boolean isSerial()
	{
		return isSerial;
	}
	/**
	 * @param isSerial the isSerial to set
	 */
	public void setSerial(boolean isSerial)
	{
		this.isSerial = isSerial;
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
	 * @return the keyWidth
	 */
	public int getKeyWidth()
	{
		return keyWidth;
	}
	/**
	 * @param keyWidth the keyWidth to set
	 */
	public void setKeyWidth(int keyWidth)
	{
		this.keyWidth = keyWidth;
	}
	/**
	 * @return the serialId
	 */
	public int getSerialId()
	{
		return serialId;
	}
	/**
	 * @param serialId the serialId to set
	 */
	public void setSerialId(int serialId)
	{
		this.serialId = serialId;
	}
	/**
	 * @return the serialStart
	 */
	public String getSerialStart()
	{
		return serialStart;
	}
	/**
	 * @param serialStart the serialStart to set
	 */
	public void setSerialStart(String serialStart)
	{
		this.serialStart = serialStart;
	}
	/**
	 * @return the serialIdEnd
	 */
	public String getSerialIdEnd()
	{
		return serialIdEnd;
	}
	/**
	 * @param serialIdEnd the serialIdEnd to set
	 */
	public void setSerialIdEnd(String serialIdEnd)
	{
		this.serialIdEnd = serialIdEnd;
	}
	/**
	 * @return the brand
	 */
	public String getBrand()
	{
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	/**
	 * @return the brandId
	 */
	public int getBrandId()
	{
		return brandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId)
	{
		this.brandId = brandId;
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
	 * @return the jaw
	 */
	public String getJaw()
	{
		return jaw;
	}
	/**
	 * @param jaw the jaw to set
	 */
	public void setJaw(String jaw)
	{
		this.jaw = jaw;
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
	 * @return the unlockToolCode
	 */
	public String getUnlockToolCode()
	{
		return unlockToolCode;
	}
	/**
	 * @param unlockToolCode the unlockToolCode to set
	 */
	public void setUnlockToolCode(String unlockToolCode)
	{
		this.unlockToolCode = unlockToolCode;
	}
	/**
	 * @return the searchDateTime
	 */
	public String getSearchDateTime()
	{
		return searchDateTime;
	}
	/**
	 * @param searchDateTime the searchDateTime to set
	 */
	public void setSearchDateTime(String searchDateTime)
	{
		this.searchDateTime = searchDateTime;
	}	

}
