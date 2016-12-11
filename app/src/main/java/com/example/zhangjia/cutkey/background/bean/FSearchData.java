package com.example.zhangjia.cutkey.background.bean;

public class FSearchData
{
	/**
	 * @param no
	 * @param serialId
	 * @param keyWidth
	 * @param cuts
	 * @param serialStart
	 * @param serialIdEnd
	 * @param serialCount
	 * @param jaw
	 * @param isRelevant
	 */
	public FSearchData(int no, int serialId, int keyWidth, String cuts,
			String serialStart, String serialIdEnd, int serialCount,
			String jaw, boolean isRelevant)
	{
		super();
		this.no = no;
		this.serialId = serialId;
		this.keyWidth = keyWidth;
		this.cuts = cuts;
		this.serialStart = serialStart;
		this.serialIdEnd = serialIdEnd;
		this.serialCount = serialCount;
		this.jaw = jaw;
		this.isRelevant = isRelevant;
	}

	/**
	 * 编号
	 */
	private int no;
	
	/**
	 * 序列编号
	 */
	private int serialId;
	/**
	 * 钥匙坯宽度
	 */
	private int keyWidth;
	
	/**
	 * 齿数
	 */
	private String	cuts;	
	
	/**
	 * 序列开始号
	 */
	private String serialStart;
	
	/**
	 * 序列结束号
	 */
	private String serialIdEnd;
	
	/**
	 * 序列数量
	 */
	private int serialCount;
	
	/**
	 * 夹具
	 */
	private String jaw;
	
	/**
	 * 是否关联
	 */
	private boolean isRelevant;		
	/**
	 * 序列号
	 */
	//private String serial;

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
	 * @return the serialCount
	 */
	public int getSerialCount()
	{
		return serialCount;
	}

	/**
	 * @param serialCount the serialCount to set
	 */
	public void setSerialCount(int serialCount)
	{
		this.serialCount = serialCount;
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
	 * @return the isRelevant
	 */
	public boolean isRelevant()
	{
		return isRelevant;
	}

	/**
	 * @param isRelevant the isRelevant to set
	 */
	public void setRelevant(boolean isRelevant)
	{
		this.isRelevant = isRelevant;
	}
}
