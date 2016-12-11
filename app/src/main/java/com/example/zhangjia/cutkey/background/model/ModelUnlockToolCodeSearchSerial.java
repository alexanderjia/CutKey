package com.example.zhangjia.cutkey.background.model;

import java.util.ArrayList;
import java.util.List;

import android.R.string;

import com.example.zhangjia.cutkey.background.bean.UnlockToolCodeSerial;


public class ModelUnlockToolCodeSearchSerial implements
		IModelUnlockToolCodeSearchSerial
{

	@Override
	public List<UnlockToolCodeSerial> getUnlockToolCodeSerial(int index)
	{
		// TODO Auto-generated method stub
		/**
		 * 编号
		 */
		int no;
		
		/**
		 * 序列码编号
		 */
		int serialIndex;
		
		/**
		 * 包含的车厂
		 */
		String manufacturesName="DAEWOO,FIATGMC,TOYOTA";
		
		/**
		 * 序列码
		 */
		String[] serial={"R0001-R1706",
				"A0001-A1000",
				"S0001-S1000",
				"00001-22185"};
		
		List data=new ArrayList<UnlockToolCodeSerial>();
		for (int i = 0; i < 4; i++)
		{
			UnlockToolCodeSerial data0=new UnlockToolCodeSerial(i+1, 200+i,manufacturesName,serial[i]);
			data.add(data0);
		}
		
		return data;
	}
	
	

}
