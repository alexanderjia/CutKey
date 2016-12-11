package com.example.zhangjia.cutkey.background.model;

import com.example.zhangjia.cutkey.background.CutClient;
import com.example.zhangjia.cutkey.background.data.OffsetData;

/**
 * 偏差设置
 */

public class ModelAxisOffSet implements IModelAxisOffSet
{

	@Override
	public int[] getOffsetData()
	{
		// TODO Auto-generated method stub
		return OffsetData.getOffsetData();
	}

	@Override
	public boolean saveOffsetData(int x, int y, int z)
	{
		// TODO Auto-generated method stub
		return CutClient.SaveOffsetData(x, y, z);
	}

}
