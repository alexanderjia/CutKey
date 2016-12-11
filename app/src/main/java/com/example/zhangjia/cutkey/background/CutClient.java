package com.example.zhangjia.cutkey.background;

public class CutClient
{
	static public native boolean Test00();
	static public native boolean Test01();
	
	static public native boolean ComTest();
	static public native boolean ComTest(boolean init);
	
	static public native Object SearchKey(Object data);
	//static public native String SearchKey(String strSerier);
	static public native Object SearchKey(String strSerier);
	static public native String SearchKey(String strA, String strB);
	static public native Object SearchKey(int idcard, String brand, String serier, String no, boolean idCardSearch);
	static public native String[][] SearchKeyS(String strSerier);
	static public native String SearchKeyStr(String strSerier);
	
	static public native String SearchKeyStr(String strSerier, boolean isSerial);
	
	static public native boolean CutKey();
	static public native boolean CutKey(int index);
	static public native boolean CutKey(boolean cutPrevier);
	static public native boolean CutKey(int idcard, String brand, String serier, String no);
	
	static public native String GetKeyShapePointString(int indexId, String searchString, boolean isSerial);
	static public native String GetToothCodesDataString(int indexId);
	static public native String GetToothSpaceDataString(int indexId);
	static public native String GetMachiningDataString(int indexId);
	
	static public native boolean IsSerialExist(String serial, int indexId);
	static public native String GetMatchSerial(String data, boolean isSerial);
	
	
	static public native boolean SaveOffsetData(int x, int y, int z);
	static public native String GetOffsetData();
	
	static public native boolean SaveMachiningHistoryData(String data);
	static public native String GetMachiningHistoryData();
	
}
