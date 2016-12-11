package com.example.zhangjia.cutkey.background.presenter;

import com.example.zhangjia.cutkey.background.data.OffsetData;
import com.example.zhangjia.cutkey.background.model.IModelAxisOffSet;
import com.example.zhangjia.cutkey.background.model.ModelAxisOffSet;
import com.example.zhangjia.cutkey.background.view.IViewAxisOffSet;

public class PresenterAxisOffSet implements IPresenterAxisOffSet
{
	/**
	 * @param modelAxisOffSet
	 */
	private PresenterAxisOffSet(IModelAxisOffSet modelAxisOffSet)
	{
		super();
		this.modelAxisOffSet = modelAxisOffSet;
	}

	/**
	 * 
	 */
	public PresenterAxisOffSet()
	{
		//super();
		// TODO Auto-generated constructor stub
		this(new ModelAxisOffSet());
	}


	private IViewAxisOffSet viewAxisOffSet;
	private IModelAxisOffSet modelAxisOffSet;

	@Override
	public void onSaveAxisOffSetData()
	{
		// TODO Auto-generated method stub
		int[] data=viewAxisOffSet.getAxisOffSetData();
		modelAxisOffSet.saveOffsetData(data[0], data[1], data[2]);
	}

	@Override
	public void onUpdateAxisOffSetData()
	{
		// TODO Auto-generated method stub
		int[] data=OffsetData.getOffsetData();
		viewAxisOffSet.onUpdateAxisOffSetData(data[0], data[1], data[2]);
	}


	/**
	 * @param viewAxisOffSet the viewAxisOffSet to set
	 */
	public void setView(IViewAxisOffSet viewAxisOffSet)
	{
		this.viewAxisOffSet = viewAxisOffSet;
	}

}
