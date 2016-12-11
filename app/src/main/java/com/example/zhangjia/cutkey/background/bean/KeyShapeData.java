package com.example.zhangjia.cutkey.background.bean;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;
import android.graphics.drawable.shapes.Shape;

/**
 * 钥匙形状坐标点数据
 * @author admini
 *
 */
public class KeyShapeData
{
	/**
	 * 
	 */
	private KeyShapeData()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param shape
	 */
	public KeyShapeData(List<Point> shape)
	{
		super();
		this.shape = shape;
	}

	private List<Point> shape;

	/**
	 * @return the shape
	 */
	public List<Point> getShape()
	{
		return shape;
	}

	/**
	 * @param shape the shape to set
	 */
	public void setShape(List<Point> shape)
	{
		this.shape = shape;
	}
}
