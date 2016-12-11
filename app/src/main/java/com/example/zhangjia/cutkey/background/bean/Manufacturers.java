package com.example.zhangjia.cutkey.background.bean;

/**
 * 车厂数据
 * @author admini
 *
 */
public class Manufacturers
{
	/**
	 * @param no
	 * @param manufactureIndex
	 * @param manufacture
	 * @param serial
	 * @param picSrc
	 */
	public Manufacturers(int no, int manufactureIndex, String manufacture,
			String serial, String picSrc)
	{
		super();
		this.no = no;
		this.manufactureIndex = manufactureIndex;
		this.manufacture = manufacture;
		this.serial = serial;
		this.picSrc = picSrc;
	}

	/**
	 * 车厂数据
	 * @param no:编号
	 * @param manufactureIndex:车厂编号
	 * @param manufacture:车厂名称
	 * @param serial:相关序列号
	 */
	public Manufacturers(int no, int manufactureIndex, String manufacture,
			String serial)
	{
		super();
		this.no = no;
		this.manufactureIndex = manufactureIndex;
		this.manufacture = manufacture;
		this.serial = serial;
	}

	/**
	 * 车厂数据
	 * @param no:编号
	 * @param manufactureIndex:车厂编号
	 * @param manufacture:车厂名称
	 */
	public Manufacturers(int no, int manufactureIndex, String manufacture)
	{
		super();
		this.no = no;
		this.manufactureIndex = manufactureIndex;
		this.manufacture = manufacture;
	}

	/**
	 * 编号
	 */
	private int no;
	/**
	 * 车厂编号
	 */
	private int manufactureIndex;
	/**
	 * 车厂名称
	 */
	private String manufacture;
	
	/**
	 * 相关序列号
	 */
	private String serial;
	/**
	 * 图片
	 */
	private String picSrc;
	/**
	 * 首字母
	 */
	private String Fistletter;
	/**
	 * 相关序列号
	 * @return
	 */
	public String getSerialIndex()
	{
		return serial;
	}

	/**
	 * 相关序列号
	 * @param serialIndex
	 */
	public void setSerialIndex(String serialIndex)
	{
		this.serial = serialIndex;
	}

	/**
	 * 编号
	 * @return
	 */
	public int getNo()
	{
		return no;
	}
	
	/**
	 * 编号
	 * @param no
	 */
	public void setNo(int no)
	{
		this.no = no;
	}
	
	/**
	 * 车厂编号
	 * @return
	 */
	public int getManufactureIndex()
	{
		return manufactureIndex;
	}
	
	/**
	 * 车厂编号
	 * @param manufactureIndex
	 */
	public void setManufactureIndex(int manufactureIndex)
	{
		this.manufactureIndex = manufactureIndex;
	}
	
	/**
	 * 车厂名称
	 * @return
	 */
	public String getManufacture()
	{
		return manufacture;
	}
	
	/**
	 * 车厂名称
	 * @param manufacture
	 */
	public void setManufacture(String manufacture)
	{
		this.manufacture = manufacture;
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
}
