package com.example.zhangjia.cutkey.background.model;

import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;

public interface IModelMachiningSerial extends IModelMachining
{
	boolean isSerialExist(String serial, int indexId);
	KeyShapeDatas getKeyShapePointsData(int indexId, String serial);
}
