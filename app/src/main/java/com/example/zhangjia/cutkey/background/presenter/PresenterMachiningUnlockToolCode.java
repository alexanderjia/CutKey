package com.example.zhangjia.cutkey.background.presenter;

import com.example.zhangjia.cutkey.background.model.IModelMachiningUnlockToolCode;
import com.example.zhangjia.cutkey.background.model.ModelMachiningUnlockToolCode;
import com.example.zhangjia.cutkey.background.view.IViewMachiningUnlockToolCode;

public class PresenterMachiningUnlockToolCode implements
		IPresenterMachiningUnlockToolCode
{
	/**
	 * @param modelMachiningUnlockToolCode
	 */
	private PresenterMachiningUnlockToolCode(
			IModelMachiningUnlockToolCode modelMachiningUnlockToolCode)
	{
		super();
		this.modelMachiningUnlockToolCode = modelMachiningUnlockToolCode;
	}

	/**
	 * 
	 */
	public PresenterMachiningUnlockToolCode()
	{
		//super();
		// TODO Auto-generated constructor stub
		this(new ModelMachiningUnlockToolCode());
	}

	private IModelMachiningUnlockToolCode modelMachiningUnlockToolCode;
	private IViewMachiningUnlockToolCode viewMachiningUnlockToolCode;

	@Override
	public void onGetMachiningHistoryData()
	{
		// TODO Auto-generated method stub
		viewMachiningUnlockToolCode.onUpdateMachiningHistoryData(modelMachiningUnlockToolCode.getMachiningHistoryData());
	}

	@Override
	public void onUpdateKeyShapeData()
	{
		// TODO Auto-generated method stub
		int indexId=viewMachiningUnlockToolCode.getSelectedMachiningHistoryDataIndex();
		String cutCode=viewMachiningUnlockToolCode.getCutCode();
		viewMachiningUnlockToolCode.onUpdateKeyShapeData(modelMachiningUnlockToolCode.getKeyShapePointsData(indexId, cutCode));
	}

	@Override
	public void onSelectedHistoryDataChange()
	{
		// TODO Auto-generated method stub
		int indexId=viewMachiningUnlockToolCode.getSelectedMachiningHistoryDataIndex();
		viewMachiningUnlockToolCode.onUpdateSelectedHistoryData(modelMachiningUnlockToolCode.getMachiningData(indexId));
	}

	@Override
	public void onGetKeyShapePointsData()
	{
		// TODO Auto-generated method stub
		int indexId=viewMachiningUnlockToolCode.getSelectedMachiningHistoryDataIndex();
		String cutCode=viewMachiningUnlockToolCode.getCutCode();
		viewMachiningUnlockToolCode.onUpdateKeyShapeData(modelMachiningUnlockToolCode.getKeyShapePointsData(indexId, cutCode));
	}

	
	/**
	 * @param viewMachiningUnlockToolCode the viewMachiningUnlockToolCode to set
	 */
	public void setView(IViewMachiningUnlockToolCode viewMachiningUnlockToolCode)
	{
		this.viewMachiningUnlockToolCode = viewMachiningUnlockToolCode;
	}

}
