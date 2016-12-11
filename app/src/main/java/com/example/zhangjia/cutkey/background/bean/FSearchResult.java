package com.example.zhangjia.cutkey.background.bean;

import java.util.List;

public class FSearchResult
{
	/**
	 * @param data
	 * @param result
	 * @param tips
	 */
	public FSearchResult(List<FSearchData> data, boolean result, String tips)
	{
		super();
		this.data = data;
		this.result = result;
		this.tips = tips;
	}

	public FSearchResult() {
	}

	List<FSearchData> data;
	
	boolean result;
	String tips;
	/**
	 * @return the data
	 */
	public List<FSearchData> getData()
	{
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<FSearchData> data)
	{
		this.data = data;
	}
	/**
	 * @return the result
	 */
	public boolean isResult()
	{
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result)
	{
		this.result = result;
	}
	/**
	 * @return the tips
	 */
	public String getTips()
	{
		return tips;
	}
	/**
	 * @param tips the tips to set
	 */
	public void setTips(String tips)
	{
		this.tips = tips;
	}
}
