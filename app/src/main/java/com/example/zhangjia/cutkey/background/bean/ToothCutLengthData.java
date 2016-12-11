package com.example.zhangjia.cutkey.background.bean;

/**
 * 齿位数据
 * @author admini
 *
 */
public class ToothCutLengthData
{
	/**
	 * @param no
	 * @param length
	 */
	public ToothCutLengthData(int no, int length)
	{
		super();
		this.no = no;
		this.length = length;
	}

	public ToothCutLengthData() {
	}

	/**
	 * 位置编号
	 */
	private int no;
	
	/**
	 * 位置长度
	 */
	private int length;

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
	 * @return the length
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length)
	{
		this.length = length;
	}
}



