package com.example.zhangjia.cutkey.background.view;

public interface IViewMachiningSerial extends IViewMachining
{
	void onSerialMatch(boolean isMatch);
	String getSerial();
}
