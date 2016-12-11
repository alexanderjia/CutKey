package com.example.zhangjia.cutkey.background.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.zhangjia.cutkey.background.bean.FSearchResult;
import com.example.zhangjia.cutkey.background.data.FSearchDatas;

public class ModelFuzzySearch implements IModelFuzzySearch
{

	@Override
	public void fuzzySearch(final String searchString, final boolean isSerial,
			final ICallBackFuzzySearch callback)
	{
		// TODO Auto-generated method stub
		//单例线程，任意时间(同一时间)池中只能有一个线程
	    //ExecutorService es = Executors.newSingleThreadExecutor();
	  //声明一个线程池
	    ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new Runnable()
	        {     
			//@Override
	            public void run()
	            {             
	                //耗时操作
	            	FSearchResult data=FSearchDatas.getFSearchDatas(searchString, isSerial);
	                //callback.onResult("hello world");    //10 返回数据
	            	callback.onResult(data);
	            }
	        });
		
	}

	@Override
	public FSearchResult fuzzySearch2(String searchString, boolean isSerial)
	{
		// TODO Auto-generated method stub
		FSearchResult fSearchResult = FSearchDatas.getFSearchDatas(searchString, isSerial);
		return fSearchResult;
	}

}
