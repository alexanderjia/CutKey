package com.example.zhangjia.cutkey.background.bean;

public class MachiningData
{
	/**
	 * @param jaw
	 * @param align
	 * @param keyBlankName
	 * @param cutterDiameter
	 * @param cuttingDepth
	 * @param toothCodesData
	 * @param toothSpaceData
	 */
	public MachiningData(String jaw, String align, String keyBlankName,
			int cuttingDepth, int cutterDiameter, int keyBlankLength, int keyBlankWidth,
			ToothCodesDatas toothCodesData, ToothSpaceData toothSpaceData)
	{
		super();
		this.jaw = jaw;
		this.align = align;
		this.keyBlankName = keyBlankName;
		this.cuttingDepth = cuttingDepth;
		this.cutterDiameter = cutterDiameter;		
		this.toothCodesData = toothCodesData;
		this.toothSpaceData = toothSpaceData;
		this.keyBlankLength=keyBlankLength;
		this.keyBlankWidth=keyBlankWidth;
	}

	public MachiningData() {
	}

	/**
	 * 夹具
	 */
	private String jaw;
	/**
	 * 对齐方式	
	 */
	private String align;
	/**
	 * 钥匙坯	
	 */
	private String keyBlankName;
	/**
	 * 铣刀直径	
	 */
	private int cutterDiameter;	
	/**
	 * 切割深度	
	 */
	private int cuttingDepth;	
	/**
	 * 齿形编码数据	
	 */
	private ToothCodesDatas toothCodesData;
	/**
	 * 齿位数据	
	 */
	private ToothSpaceData toothSpaceData;//	List<ToothCutLengthData>
	/**
	 * 钥匙坯宽度
	 */
	private int keyBlankWidth;
	/**
	 * 钥匙坯长度
	 */	
	private int keyBlankLength;
	
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
	 * @return the keyBlankName
	 */
	public String getKeyBlankName()
	{
		return keyBlankName;
	}
	/**
	 * @param keyBlankName the keyBlankName to set
	 */
	public void setKeyBlankName(String keyBlankName)
	{
		this.keyBlankName = keyBlankName;
	}
	/**
	 * @return the cutterDiameter
	 */
	public int getCutterDiameter()
	{
		return cutterDiameter;
	}
	/**
	 * @param cutterDiameter the cutterDiameter to set
	 */
	public void setCutterDiameter(int cutterDiameter)
	{
		this.cutterDiameter = cutterDiameter;
	}
	/**
	 * @return the cuttingDepth
	 */
	public int getCuttingDepth()
	{
		return cuttingDepth;
	}
	/**
	 * @param cuttingDepth the cuttingDepth to set
	 */
	public void setCuttingDepth(int cuttingDepth)
	{
		this.cuttingDepth = cuttingDepth;
	}
	/**
	 * @return the toothCodesData
	 */
	public ToothCodesDatas getToothCodesData()
	{
		return toothCodesData;
	}
	/**
	 * @param toothCodesData the toothCodesData to set
	 */
	public void setToothCodesData(ToothCodesDatas toothCodesData)
	{
		this.toothCodesData = toothCodesData;
	}
	/**
	 * @return the toothSpaceData
	 */
	public ToothSpaceData getToothSpaceData()
	{
		return toothSpaceData;
	}
	/**
	 * @param toothSpaceData the toothSpaceData to set
	 */
	public void setToothSpaceData(ToothSpaceData toothSpaceData)
	{
		this.toothSpaceData = toothSpaceData;
	}
	/**
	 * @return the align
	 */
	public String getAlign()
	{
		return align;
	}
	/**
	 * @param align the align to set
	 */
	public void setAlign(String align)
	{
		this.align = align;
	}
	/**
	 * @return the keyBlankWidth
	 */
	public int getKeyBlankWidth()
	{
		return keyBlankWidth;
	}
	/**
	 * @param keyBlankWidth the keyBlankWidth to set
	 */
	public void setKeyBlankWidth(int keyBlankWidth)
	{
		this.keyBlankWidth = keyBlankWidth;
	}
	/**
	 * @return the keyBlankLength
	 */
	public int getKeyBlankLength()
	{
		return keyBlankLength;
	}
	/**
	 * @param keyBlankLength the keyBlankLength to set
	 */
	public void setKeyBlankLength(int keyBlankLength)
	{
		this.keyBlankLength = keyBlankLength;
	}	

}
