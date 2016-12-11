package com.example.zhangjia.cutkey.background.data;

import com.example.zhangjia.cutkey.background.bean.AxisData;
import com.example.zhangjia.cutkey.background.bean.MachiningData;
import com.example.zhangjia.cutkey.background.bean.ToothCodeData;
import com.example.zhangjia.cutkey.background.bean.ToothCodesData;
import com.example.zhangjia.cutkey.background.bean.ToothCodesDatas;
import com.example.zhangjia.cutkey.background.bean.ToothCutLengthData;
import com.example.zhangjia.cutkey.background.bean.ToothSpaceData;

import java.util.ArrayList;
import java.util.List;



public class MachiningDatas
{
	private static AxisData getAxisData(String data)
	{
		String[] str=data.split(";");
		int[] x=new int[str.length];//no
		int[] y=new int[str.length];//length
		for (int i = 0; i < str.length; i++)
		{
			String[] str0=str[i].split(",");
			if(str0.length<2) 
			{
				return null;
			}
			try 
			{
				x[i]= Integer.parseInt(str0[0]);
				y[i]= Integer.parseInt(str0[1]);
			} catch (NumberFormatException e) 
			{
			    e.printStackTrace();
			    return null;
			}
		}
		List<ToothCutLengthData> shape=new ArrayList<ToothCutLengthData>();
		for (int i = 0; i < str.length; i++)
		{
			ToothCutLengthData point=new ToothCutLengthData(x[i], y[i]);
			shape.add(point);
		}				
		AxisData axis=new AxisData(shape);
		
		return axis;
	}
	
	public static ToothSpaceData getToothSpaceData(int indexId)
	{		
		//String data=CutClient.GetToothSpaceDataString(indexId);
		String data="1,250;2,260;3,260;4,260;5,260;6,260;7,260;8,260";
		String[] data0=data.split(":");
		if (data0.length<1)
		{
			return null;
		}
		List<AxisData> dataKey=new ArrayList<AxisData>();
		for (int i = 0; i < data0.length; i++)
		{
			AxisData data2=getAxisData(data0[i]);
			if (data2==null)
			{
				return null;
			}
			dataKey.add(data2);
		}
		ToothSpaceData datas=new ToothSpaceData(data0.length, dataKey);
		
		return datas;
	}
	
	private static ToothCodesData getToothCodesData(String data)
	{
		String[] str=data.split(";");
		char[] x=new char[str.length];//no
		int[] y=new int[str.length];//length
		for (int i = 0; i < str.length; i++)
		{
			String[] str0=str[i].split(",");
			if(str0.length<2) 
			{
				return null;
			}
			try 
			{
				x[i]= str0[0].trim().charAt(0);// Integer.parseInt(str0[0]);
				y[i]= Integer.parseInt(str0[1]);
			} catch (NumberFormatException e) 
			{
			    e.printStackTrace();
			    return null;
			}
		}
		List<ToothCodeData> shape=new ArrayList<ToothCodeData>();
		for (int i = 0; i < str.length; i++)
		{
			ToothCodeData point=new ToothCodeData(x[i], y[i]);
			shape.add(point);
		}				
		ToothCodesData axis=new ToothCodesData(shape);
		
		return axis;
	}
	
	public static ToothCodesDatas getToothCodesDatas(int indexId)
	{		
		//String data=CutClient.GetToothSpaceDataString(indexId);
		String data="A,422;B,342;C,262;D,182";
		String[] data0=data.split(":");
		if (data0.length<1)
		{
			return null;
		}
		List<ToothCodesData> dataKey=new ArrayList<ToothCodesData>();
		for (int i = 0; i < data0.length; i++)
		{
			ToothCodesData data2=getToothCodesData(data0[i]);
			if (data2==null)
			{
				return null;
			}
			dataKey.add(data2);
		}
		ToothCodesDatas datas=new ToothCodesDatas(data0.length, dataKey);
		
		return datas;
	}
	
	public static MachiningData getMachiningData(int indexId)
	{		
		/**
		 * 齿形编码数据	
		 */
		ToothCodesDatas toothCodesData=getToothCodesDatas(indexId);
		if (toothCodesData==null)
		{
			return null;
		}
		/**
		 * 齿位数据	
		 */
		ToothSpaceData toothSpaceData=getToothSpaceData(indexId);
		if (toothSpaceData==null)
		{
			return null;
		}
		
		//String data=CutClient.GetMachiningDataString(indexId);		
		String data="C;TIP;TOY52;150;130;2720;760";
		String[] str=data.split(";");
		if (str.length<7/*5*/)
		{
			return null;
		}
		
		/**
		 * 夹具
		 */
		String jaw=str[0].trim();
		/**
		 * 对齐方式	
		 */
		String align=str[1].trim();
		/**
		 * 钥匙坯	
		 */
		String keyBlankName=str[2].trim();
		/**
		 * 铣刀直径	
		 */
		int cutterDiameter;	
		
		/**
		 * 切割深度	
		 */		
		int cuttingDepth;	
		/**
		 * 钥匙坯宽度
		 */
		int keyBlankWidth;
		/**
		 * 钥匙坯长度
		 */	
		int keyBlankLength;
		try 
		{
			cutterDiameter= Integer.parseInt(str[3]);
			cuttingDepth= Integer.parseInt(str[4]);
			keyBlankLength=Integer.parseInt(str[5]);
			keyBlankWidth=Integer.parseInt(str[6]);
		} catch (NumberFormatException e) 
		{
		    e.printStackTrace();
		    return null;
		}
					
		MachiningData axis=new MachiningData(jaw, align, keyBlankName,cuttingDepth,
				cutterDiameter, keyBlankLength, keyBlankWidth, toothCodesData, toothSpaceData);
		
		return axis;
	}
	
	public static List<String> getMatchSerial(String data, boolean isSerial)
	{
		if (data=="")
		{
			return null;
		}
		
		//data=CutClient.GetMatchSerial(data, isSerial);
		data="114752,56974,56247";
		if (data=="")
		{
			return null;
		}
		String[] str=data.split(",");
		List<String> axis=new ArrayList<String>();
		for (int i = 0; i < str.length; i++)
		{
			axis.add(str[i]);
		}	
		
		return axis;
	}
	
	
}
