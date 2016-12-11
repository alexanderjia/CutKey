package com.example.zhangjia.cutkey.background.model;

import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;

public interface IModelMachiningUnlockToolCode extends IModelMachining
{
	KeyShapeDatas getKeyShapePointsData(int indexId, String cutCode);
}
