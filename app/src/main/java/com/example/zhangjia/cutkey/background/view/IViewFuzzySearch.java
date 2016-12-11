package com.example.zhangjia.cutkey.background.view;

import com.example.zhangjia.cutkey.background.bean.FSearchResult;

public interface IViewFuzzySearch
{
	void updateData(FSearchResult data);
	
	void showProgress();
	
	void hideProgress();
}
