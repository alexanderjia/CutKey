package com.example.zhangjia.cutkey.background.model;

import com.example.zhangjia.cutkey.background.bean.DateTime;
import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;
import com.example.zhangjia.cutkey.background.bean.MachiningData;
import com.example.zhangjia.cutkey.background.bean.MachiningHistory;
import com.example.zhangjia.cutkey.background.data.KeyShapePoints;
import com.example.zhangjia.cutkey.background.data.MachiningDatas;
import com.example.zhangjia.cutkey.background.data.MachiningHistoryDatas;

import java.util.ArrayList;
import java.util.List;



public class ModelMachiningUnlockToolCode implements
		IModelMachiningUnlockToolCode
{

	/*@Override
	public boolean isSerialExist(String serial, int indexId)
	{
		// TODO Auto-generated method stub
		return false;
	}*/
	
	private static List<MachiningHistory> m_data=new ArrayList<MachiningHistory>();
	
	public static void addMachiningHistoryData(MachiningHistory data)
	{
		m_data.add(data);
	}

	@Override
	public List<MachiningHistory> getMachiningHistoryData()
	{
		// TODO Auto-generated method stub
				List<MachiningHistory> data=new ArrayList<MachiningHistory>();
				for (int i = 0; i < 5; i++)
				{
					MachiningHistory data0=new MachiningHistory(i+1,
					true,
					"HCA0008",
					840,
					200+i,
					"HCA0001",
					"HCA2000",
					"ALFA ROMEO",
					50000+i,
					"8-8",
					"F",
					300+i,
					"HON66FH",
					"567218",
					DateTime.now().toDateTimeString());
					data.add(data0);
				}
				
				if (MachiningHistoryDatas.getHistoryDataCount()>0)
				{
					data.addAll(MachiningHistoryDatas.getHistoryDataData());
				}
				/*for (int i = 0; i < m_data.size(); i++)
				{
					data.a.add(m_data.get(i));
				}*/
				
				return data;
	}

	@Override
	public MachiningData getMachiningData(int indexId)
	{
		// TODO Auto-generated method stub
		return MachiningDatas.getMachiningData(indexId);
	}

	@Override
	public List<String> getMatchSerial(String data)
	{
		// TODO Auto-generated method stub
		return MachiningDatas.getMatchSerial(data, false);
	}

	@Override
	public KeyShapeDatas getKeyShapePointsData(int indexId, String cutCode)
	{
		// TODO Auto-generated method stub
		return KeyShapePoints.getKeyShapePoints(indexId, cutCode, false);
	}

}
