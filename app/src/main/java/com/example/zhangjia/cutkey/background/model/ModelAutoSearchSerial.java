package com.example.zhangjia.cutkey.background.model;

import java.util.ArrayList;
import java.util.List;


import com.example.zhangjia.cutkey.background.bean.KeySerial;
import com.example.zhangjia.cutkey.background.data.*;

public class ModelAutoSearchSerial implements IModelAutoSearchSerial
{

	@Override
	public List<KeySerial> getSeriesbyManufacturer(int index)
	{
		// TODO Auto-generated method stub
		int[] indexData=getSerialIndexbyManufacturer(index);
		if (indexData==null)
		{
			return null;
		}
		
		List<KeySerial> data=new ArrayList<KeySerial>(); ;
		for (int i = 0; i < indexData.length; i++)
		{
			KeySerial data0=new KeySerial(i+1,indexData[i],SerialData.getSerial(indexData[i]));
			data.add(data0);
		}
		
		return data;
	}

	
	private int[] getManufacturerIndex()
	{
		int brandID=30000;
		int[] data=new int[33];
		for(int i=0;i<33;i++)
		{
			data[i]=brandID+i+1;
		}
		
		return data;
	}
	
	private int[] getStringData(String data)
	{
		if (!data.contains(","))
		{
			try 
			{
				int[] re=new int[]{Integer.parseInt(data)};
				return re;
			} catch (NumberFormatException e) 
			{
			    e.printStackTrace();
			    return null;
			}
			
		}
		else 
		{
			String[] re0=data.split(",");
			int[] re=new int[re0.length];
			for (int i = 0; i < re0.length; i++)
			{
				try 
				{
					re[i]=Integer.parseInt(re0[i]);
					
				} catch (NumberFormatException e) 
				{
				    e.printStackTrace();
				}
			}
			return re;
		}
	}
	
	private int[] getSerialIndex(int index)
	{
		int brandID=30000;
		String[] serialIndex=new String[]{
			"5001,5002,5087",
			"5003,5004,5138",
			"5005,5007,5008,5010,5011",
			"5006,5049,5051,5053,5054,5056,5058,5059,5126",
			"5012,5160",
			"5014,5015,5016,5019,5020,5170",
			"5017,5021,5025,5027,5078,5027,5171",
			"5024,5175",
			"5026,5079,5147,5244,5245",
			"5028,5029,5030,5031,5032,5034,5169",
			"5033",
			"5035,5036,5194",
			"5038,5040,5043",
			"5039,5044,5046",
			"5042,5045,5102,5103,5106,5107,5108,5109,5110,5112,5114",
			"5047",
			"5050,5080,5084,5088,5090",
			"5052",
			"5070,5072,5122",
			"5071,5119,5120,5121,5123",
			"5076",
			"5111,5129,5134,5135",
			"5124,5196",
			"5127,5165,5248",
			"5139,5141,5142",
			"5143,5144,5148,5149,5150",
			"5156,5158",
			"5163,5168",
			"5173,5209,5239,5240",
			"5177,5230",
			"5213,5214,5221",
			"5231",
			"5243"
		};
		brandID=index-brandID;
		
		if(brandID<0 || brandID >serialIndex.length) return null;
		
		return getStringData(serialIndex[brandID]);
		
	}
	
	private int[] getSerialIndexbyManufacturer(int index)
	{
		int brandID=30000;
		return getSerialIndex(index);
	}
}
