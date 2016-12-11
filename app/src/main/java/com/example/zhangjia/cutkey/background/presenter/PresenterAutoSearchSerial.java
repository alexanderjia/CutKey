package com.example.zhangjia.cutkey.background.presenter;

import com.example.zhangjia.cutkey.background.model.IModelAutoSearchSerial;
import com.example.zhangjia.cutkey.background.model.ModelAutoSearchSerial;
import com.example.zhangjia.cutkey.background.view.IViewAutoSearchSerial;

public class PresenterAutoSearchSerial implements IPresenterAutoSearchSerial
{
	private IViewAutoSearchSerial viewAutoSearchSerial;
	private IModelAutoSearchSerial modelAutoSearchSerial;
	
	
	
	/**
	 * 
	 */
	public PresenterAutoSearchSerial()
	{
		//super();
		// TODO Auto-generated constructor stub
		this(new ModelAutoSearchSerial());
	}	

	private PresenterAutoSearchSerial(IModelAutoSearchSerial modelAutoSearchSerial)
	{
		// TODO Auto-generated constructor stub
		this.modelAutoSearchSerial=modelAutoSearchSerial;
	}

	/**
	 * @param viewAutoSearchSerial the viewAutoSearchSerial to set
	 */
	public void setView(IViewAutoSearchSerial viewAutoSearchSerial)
	{
		this.viewAutoSearchSerial = viewAutoSearchSerial;
	}




	@Override
	public void onLoadData(int index)
	{
		// TODO Auto-generated method stub
		this.viewAutoSearchSerial.loadData(modelAutoSearchSerial.getSeriesbyManufacturer(index));

	}	
	

}
