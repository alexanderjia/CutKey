package com.example.zhangjia.cutkey.background.view;

import java.util.List;


public interface IViewMachiningUnlockToolCode extends IViewMachining
{
	List<String> onMatchCutCode(String cutCode);
	String getCutCode();
}
