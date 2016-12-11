package com.example.zhangjia.cutkey.background.presenter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;

import com.example.zhangjia.cutkey.background.bean.FSearchResult;
import com.example.zhangjia.cutkey.background.model.IModelFuzzySearch;
import com.example.zhangjia.cutkey.background.model.IModelFuzzySearch.ICallBackFuzzySearch;
import com.example.zhangjia.cutkey.background.model.ModelFuzzySearch;
import com.example.zhangjia.cutkey.background.view.IViewFuzzySearch;

public class PresenterFuzzySearch implements IPresenterFuzzySearch
{
	private IModelFuzzySearch modelFuzzySearch;
	private IViewFuzzySearch viewFuzzySearch;
	
	
	/**
	 * @param modelFuzzySearch
	 */
	private PresenterFuzzySearch(IModelFuzzySearch modelFuzzySearch)
	{
		super();
		this.modelFuzzySearch = modelFuzzySearch;
	}


	/**
	 * 
	 */
	public PresenterFuzzySearch()
	{
		//super();
		// TODO Auto-generated constructor stub
		this(new ModelFuzzySearch());
	}

	/**
	 * @param view the viewFuzzySearch to set
	 */
	public void setViewF(IViewFuzzySearch view)
	{
		this.viewFuzzySearch = view;
	}
		

	@Override
	public void onSearchData(String searchString, boolean isSerial)
	{
		// TODO Auto-generated method stub
		viewFuzzySearch.showProgress();
		modelFuzzySearch.fuzzySearch(searchString, isSerial, 
				new ICallBackFuzzySearch()
		{
			public void onResult(FSearchResult data)
			{
				viewFuzzySearch.updateData(data);
			}
		});
		
		viewFuzzySearch.hideProgress();
	}


	//线程操作
	private Activity activity;
	
	public PresenterFuzzySearch(Activity activity)
	{
		this.activity=activity;
		viewFuzzySearch=(IViewFuzzySearch)activity;
	}
	
	//@Override
		public void onSearchData2(final String searchString, final boolean isSerial)
		{
			// TODO Auto-generated method stub
			try
			{
				//viewFuzzySearch.showProgress();
				activity.runOnUiThread(new Runnable() {
	                public void run() 
	                {
	                	viewFuzzySearch.showProgress();
	                }
	            });    
				// 添加了线程操作
				//声明一个线程池
			    ExecutorService es = Executors.newCachedThreadPool();
				es.execute(new Runnable()
			        {     
					//@Override
			            public void run()
			            {             
			                //耗时操作               //返回数据
			            	final FSearchResult data=modelFuzzySearch.fuzzySearch2(searchString, isSerial);
			            	activity.runOnUiThread(new Runnable() 
			            	{
                                public void run() 
                                {
                                	viewFuzzySearch.updateData(data);
                                	viewFuzzySearch.hideProgress();
                                }
                            }); 
			            }
			        });		
				
			} catch (Exception e)
			{
				// TODO: handle exception
			}		
			
		}
	
	//@Override
	public void onSearchData1(final String searchString, final boolean isSerial)
	{
		// TODO Auto-generated method stub
		try
		{
			//viewFuzzySearch.showProgress();
			activity.runOnUiThread(new Runnable() {
                public void run() 
                {
                	viewFuzzySearch.showProgress();
                }
            });    
			// 添加了线程操作
            new Thread(new Runnable() {
                public void run() {
                    try {
                        //Thread.sleep(5 * 1000); // 延迟
                    	modelFuzzySearch.fuzzySearch(searchString, isSerial, 
                				new ICallBackFuzzySearch()
                		{
                			public void onResult(final FSearchResult data)
                			{
                				activity.runOnUiThread(new Runnable() {
                                    public void run() {
                                    	viewFuzzySearch.updateData(data);
                                    	viewFuzzySearch.hideProgress();
                                    }
                                });                				
                			}
                		});  
                        
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }).start();
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}		
	}	
}
