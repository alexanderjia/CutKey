package com.example.zhangjia.cutkey.background.data;

import com.example.zhangjia.cutkey.background.bean.DateTime;
import com.example.zhangjia.cutkey.background.bean.MachiningHistory;

import java.util.ArrayList;
import java.util.List;



public class MachiningHistoryDatas
{
	private static int mDataCount=0;
	
	private static List<MachiningHistory> m_data=new ArrayList<MachiningHistory>();
	
	public static int getHistoryDataCount()
	{
		return m_data.size();
	}
	
	public static List<MachiningHistory> getHistoryDataData()
	{
		return m_data;
	}
	
	public static void addMachiningHistoryData(MachiningHistory data)
	{
		m_data.add(data);
	}
	
	private static String[] getSerial(int index)
	{
		String serial=SerialData.getSerial(index);
		if (serial==null)
		{
			return null;
		}
		
		String serial1=serial.replace("-", "");
		
		if (serial.length()==serial1.length() || serial.length()-1!=serial1.length())
		{
			return new String[]{serial,serial};
		}
		
		String[] serial2=serial.split("-");
		if (serial2.length<2)
		{
			return null;
		}
		return new String[]{serial2[0],serial2[1]};
	}
	
	public static MachiningHistory createMachiningHistoryData(int indexId, String serial, String manufacturer)
	{
		String[] serials = getSerial(indexId);
		if (serials==null)
		{
			serials=new String[]{"HCA0001","HCA2000"};
		}
		MachiningHistory data=new MachiningHistory(mDataCount+1,
			true,serial,840,indexId,
			//"HCA0001","HCA2000",
			serials[0],serials[1],
			"ALFA ROMEO",
			50000+0,"8-8","F",300+0,
			"HON66FH","567218",
			DateTime.now().toDateTimeString());
		
		/*this.no = no;
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
		this.searchDateTime = searchDateTime;*/
			
		return data;		
	}
}
