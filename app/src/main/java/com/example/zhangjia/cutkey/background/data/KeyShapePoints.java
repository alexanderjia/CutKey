package com.example.zhangjia.cutkey.background.data;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;

import com.example.zhangjia.cutkey.background.bean.KeyShapeData;
import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;


public class KeyShapePoints
{
	/**
	 * [x11,y12;x12,y12]:[x21,y22;x22,y22]
	 * @param pointString
	 * @return
	 */
	private static KeyShapeData getKeyShapeData(String pointString)
	{
		String[] str=pointString.split(";");
		int[] x=new int[str.length];
		int[] y=new int[str.length];
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
		List<Point> shape=new ArrayList<Point>();
		for (int i = 0; i < str.length; i++)
		{
			Point point=new Point(x[i], y[i]);
			shape.add(point);
		}				
		KeyShapeData data=new KeyShapeData(shape);
		
		return data;
	}
	
	public static KeyShapeDatas getKeyShapePoints(int indexId, String searchString, boolean isSerial)
	{		
		/*String data=CutClient.GetKeyShapePointString(indexId, searchString, isSerial);
		String[] data0=data.split(":");
		if (data0.length<1)
		{
			return null;
		}
		List<KeyShapeData> dataKey=new ArrayList<KeyShapeData>();
		for (int i = 0; i < data0.length; i++)
		{
			KeyShapeData data2=getKeyShapeData(data0[i]);
			if (data2==null)
			{
				return null;
			}
			dataKey.add(data2);
		}*/
		
		int[] x=new int[]{230,
				816,
				1006,
				1336,
				1550,
				1549,
				1763,
				1856,
				2046,
				2090			
		};
		int[] y=new int[]{-682,
				-682,
				-602,
				-602,
				-512,
				-512,
				-602,
				-602,
				-522,
				-522
		};
		
		int[] x1=new int[]{230,
				270,
				490,
				530,
				750,
				790,
				1010,
				1050,
				1270,
				1310,
				1530,
				1570,
				1790,
				1830,
				2050,
				2090		
		};
		int[] y1=new int[]{-422,
				-422,
				-422,
				-422,
				-422,
				-422,
				-342,
				-342,
				-342,
				-342,
				-262,
				-262,
				-342,
				-342,
				-262,
				-262,
		};
		
		List<KeyShapeData> dataKey=new ArrayList<KeyShapeData>();
		List<Point> data2=new ArrayList<Point>(); 
		if (isSerial)
		{
			for (int i = 0; i < x.length; i++)
			{
				data2.add(new Point(x[i], y[i]));
			}
		}
		else {
			for (int i = 0; i < searchString.length()*1+2; i++)
			{
				data2.add(new Point(x[i], y[i]));
			}
		}		
		
		dataKey.add(new KeyShapeData(data2));
		
		List<Point> data21=new ArrayList<Point>(); 
		if (isSerial)
		{
			for (int i = 0; i < x1.length; i++)
			{
				data21.add(new Point(x1[i], y1[i]));
			}
		}
		else {
			for (int i = 0; i < searchString.length()*2; i++)
			{
				data21.add(new Point(x1[i], y1[i]));
			}
		}

		dataKey.add(new KeyShapeData(data21));
		
		KeyShapeDatas datas=new KeyShapeDatas(2, dataKey);
		//KeyShapeDatas datas=new KeyShapeDatas(data0.length, dataKey);
		
		return datas;
	}
}
