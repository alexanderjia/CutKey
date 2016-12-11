package com.example.zhangjia.cutkey.background.presenter;

import com.example.zhangjia.cutkey.background.model.IModelUnlockToolCodeSearchSerial;
import com.example.zhangjia.cutkey.background.model.ModelUnlockToolCodeSearchSerial;
import com.example.zhangjia.cutkey.background.view.IViewUnlockToolCodeSearchSerial;

public class PresenterUnlockToolCodeSearchSerial implements
		IPresenterUnlockToolCodeSearchSerial
{
	private IModelUnlockToolCodeSearchSerial modelUnlockToolCodeSearchSerial;
	private IViewUnlockToolCodeSearchSerial viewUnlockToolCodeSearchSerial;
	
	
	/**
	 * @param modelUnlockToolCodeSearchSerial
	 */
	public PresenterUnlockToolCodeSearchSerial(
			IModelUnlockToolCodeSearchSerial modelUnlockToolCodeSearchSerial)
	{
		super();
		this.modelUnlockToolCodeSearchSerial = modelUnlockToolCodeSearchSerial;
	}

	/**
	 * 
	 */
	public PresenterUnlockToolCodeSearchSerial()
	{
		//super();
		// TODO Auto-generated constructor stub
		this(new ModelUnlockToolCodeSearchSerial());
	}

	

	@Override
	public void onLoadData(int index)
	{
		// TODO Auto-generated method stub
		viewUnlockToolCodeSearchSerial.loadData(modelUnlockToolCodeSearchSerial.getUnlockToolCodeSerial(index));
	}

	
	/**
	 * @param viewUnlockToolCodeSearchSerial the viewUnlockToolCodeSearchSerial to set
	 */
	public void setView(IViewUnlockToolCodeSearchSerial viewUnlockToolCodeSearchSerial)
	{
		this.viewUnlockToolCodeSearchSerial = viewUnlockToolCodeSearchSerial;
	}

}
