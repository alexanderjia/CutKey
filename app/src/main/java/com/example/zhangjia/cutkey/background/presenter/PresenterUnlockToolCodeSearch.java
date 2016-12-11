package com.example.zhangjia.cutkey.background.presenter;

import com.example.zhangjia.cutkey.background.model.IModelUnlockToolCodeSearch;
import com.example.zhangjia.cutkey.background.model.ModelUnlockToolCodeSearch;
import com.example.zhangjia.cutkey.background.view.IViewUnlockToolCodeSearch;

public class PresenterUnlockToolCodeSearch implements
		IPresenterUnlockToolCodeSearch
{
	private IModelUnlockToolCodeSearch modelUnlockToolCodeSearch;
	private IViewUnlockToolCodeSearch viewUnlockToolCodeSearch;
	
	
	/**
	 * 
	 */
	public PresenterUnlockToolCodeSearch()
	{
		//super();
		// TODO Auto-generated constructor stub
		this(new ModelUnlockToolCodeSearch());
	}

	public PresenterUnlockToolCodeSearch(IModelUnlockToolCodeSearch modelUnlockToolCodeSearch)
	{
		// TODO Auto-generated constructor stub
		this.modelUnlockToolCodeSearch=modelUnlockToolCodeSearch;
	}

	

	@Override
	public void onLoadData()
	{
		// TODO Auto-generated method stub
		viewUnlockToolCodeSearch.loadData(modelUnlockToolCodeSearch.getUnlockToolCodes());
	}

	
	/**
	 * @param viewUnlockToolCodeSearch the viewUnlockToolCodeSearch to set
	 */
	public void setView(
			IViewUnlockToolCodeSearch viewUnlockToolCodeSearch)
	{
		this.viewUnlockToolCodeSearch = viewUnlockToolCodeSearch;
	}

}
