package com.example.zhangjia.cutkey.background.presenter;

import com.example.zhangjia.cutkey.background.model.IModelMachiningSerial;
import com.example.zhangjia.cutkey.background.model.ModelMachiningSerial;
import com.example.zhangjia.cutkey.background.view.IViewMachiningSerial;

public class PresenterMachiningSerial implements IPresenterMachiningSerial
{
	/**
	 * @param modelMachiningSerial
	 */
	private PresenterMachiningSerial(IModelMachiningSerial modelMachiningSerial)
	{
		super();
		this.modelMachiningSerial = modelMachiningSerial;
	}

	/**
	 * 
	 */
	private PresenterMachiningSerial()
	{
		//super();
		// TODO Auto-generated constructor stub
		this(new ModelMachiningSerial());
	}

	private IModelMachiningSerial modelMachiningSerial;
	private IViewMachiningSerial viewMachiningSerial;

	@Override
	public void onGetMachiningHistoryData()
	{
		// TODO Auto-generated method stub
		viewMachiningSerial.onUpdateMachiningHistoryData(modelMachiningSerial.getMachiningHistoryData());
	}

	@Override
	public void onUpdateKeyShapeData()
	{
		// TODO Auto-generated method stub
		int indexId=viewMachiningSerial.getSelectedMachiningHistoryDataIndex();
		String serial=viewMachiningSerial.getSerial();
		viewMachiningSerial.onUpdateKeyShapeData(modelMachiningSerial.getKeyShapePointsData(indexId, serial));
	}

	@Override
	public void onSelectedHistoryDataChange()
	{
		// TODO Auto-generated method stub
		int indexId=viewMachiningSerial.getSelectedMachiningHistoryDataIndex();
		viewMachiningSerial.onUpdateSelectedHistoryData(modelMachiningSerial.getMachiningData(indexId));
	}

	@Override
	public void onCheckSerialExist()
	{
		// TODO Auto-generated method stub
		int indexId=viewMachiningSerial.getSelectedMachiningHistoryDataIndex();
		String serial=viewMachiningSerial.getSerial();
		
		viewMachiningSerial.onSerialMatch(modelMachiningSerial.isSerialExist(serial, indexId));
	}

	@Override
	public void onGetKeyShapePointsData()
	{
		// TODO Auto-generated method stub
		int indexId=viewMachiningSerial.getSelectedMachiningHistoryDataIndex();
		String serial=viewMachiningSerial.getSerial();
		viewMachiningSerial.onUpdateKeyShapeData(modelMachiningSerial.getKeyShapePointsData(indexId, serial));
	}

	
	/**
	 * @param viewMachiningSerial the viewMachiningSerial to set
	 */
	public void setView(IViewMachiningSerial viewMachiningSerial)
	{
		this.viewMachiningSerial = viewMachiningSerial;
	}

}
