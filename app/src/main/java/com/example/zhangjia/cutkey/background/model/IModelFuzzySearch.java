package com.example.zhangjia.cutkey.background.model;

import com.example.zhangjia.cutkey.background.bean.FSearchResult;

public interface IModelFuzzySearch
{
	public interface ICallBackFuzzySearch
	{    
        public void onResult(FSearchResult data);
    }

	void fuzzySearch(String searchString, boolean isSerial, ICallBackFuzzySearch callback);
	FSearchResult fuzzySearch2(String searchString, boolean isSerial);
}
