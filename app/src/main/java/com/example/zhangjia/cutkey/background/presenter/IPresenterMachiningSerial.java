package com.example.zhangjia.cutkey.background.presenter;

public interface IPresenterMachiningSerial extends IPresenterMachining
{
	void onCheckSerialExist();
	void onGetKeyShapePointsData();//int indexId, String serial);
}
