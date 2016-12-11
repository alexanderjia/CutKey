package com.example.zhangjia.cutkey.background.model;

import java.util.List;

import com.example.zhangjia.cutkey.background.bean.MachiningData;
import com.example.zhangjia.cutkey.background.bean.MachiningHistory;

public interface IModelMachining
{
	List<MachiningHistory> getMachiningHistoryData();
	MachiningData getMachiningData(int indexId);	
	List<String> getMatchSerial(String data);
}
