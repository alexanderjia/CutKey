package com.example.zhangjia.cutkey.background.view;

import java.util.List;

import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;
import com.example.zhangjia.cutkey.background.bean.MachiningData;
import com.example.zhangjia.cutkey.background.bean.MachiningHistory;

public interface IViewMachining
{
	void onUpdateMachiningHistoryData(List<MachiningHistory> data);
	void onUpdateSelectedHistoryData(MachiningData data);
	void onUpdateKeyShapeData(KeyShapeDatas data);
	int getSelectedMachiningHistoryDataIndex();
}
