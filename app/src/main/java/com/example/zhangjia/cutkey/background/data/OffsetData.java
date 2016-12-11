package com.example.zhangjia.cutkey.background.data;


import com.example.zhangjia.cutkey.background.CutClient;

public class OffsetData
{
	public static int[] getOffsetData()
	{
//		String data= CutClient.GetOffsetData();
		/**
		if (data=="")
		{
			return null;
		}
		String[] data0=data.split(",");
		if (data0.length!=3)
		{
			return null;
		}
		 **/
		
		int[] data2=new int[3];
		for (int i = 0; i < 3; i++)
		{
			try 
			{
				data2[i]= i + 4;/*Integer.parseInt(data0[i]);*/
			} catch (NumberFormatException e) 
			{
			    e.printStackTrace();
			    return null;
			}
		}
		return data2;
	}
}
