package com.example.zhangjia.cutkey.background.data;

import com.example.zhangjia.cutkey.background.bean.FSearchData;
import com.example.zhangjia.cutkey.background.bean.FSearchResult;

import java.util.ArrayList;
import java.util.List;



public class FSearchDatas
{
	private static FSearchData getFSearchData(int no, String data)
	{
		String[] str=data.split(",");
		//int no;
		int serialId = 0;
		int keyWidth = 0;
		String cuts = null;
		String serialStart = null;
		String serialIdEnd = null;
		int serialCount = 0;
		String jaw = null;
		boolean isRelevant = false;
		for (int i = 0; i < str.length; i++)
		{
			switch (i)
			{
			case 0:
				try 
				{
					serialId= Integer.parseInt(str[0]);
				} catch (NumberFormatException e) 
				{
				    e.printStackTrace();
				    return null;
				}
				break;
			case 1:
				try 
				{
					keyWidth= Integer.parseInt(str[1]);
				} catch (NumberFormatException e) 
				{
				    e.printStackTrace();
				    return null;
				}
				break;
			case 2:
				cuts=str[2].trim();
				break;
			case 3:
				serialStart=str[3].trim();
				break;
			case 4:
				serialIdEnd=str[4].trim();
				break;
			case 5:
				try 
				{
					serialCount= Integer.parseInt(str[5]);
				} catch (NumberFormatException e) 
				{
				    e.printStackTrace();
				    return null;
				}
				break;
			case 6:
				jaw=str[6].trim();
				break;
			case 7:
				isRelevant=str[7].trim()=="yes"?true:false;
				break;
			default:
				break;
			}		
			
		}
						
		FSearchData axis=new FSearchData(no,serialId,keyWidth,cuts,serialStart,
				serialIdEnd,serialCount,jaw,isRelevant);
		
		return axis;
	}
	
	public static FSearchResult getFSearchDatas(String searchString, boolean isSerial)
	{		
		//String data=CutClient.SearchKeyStr(searchString, isSerial);
		/**
		 * @param no
		 * @param serialId
		 * @param keyWidth
		 * @param cuts
		 * @param serialStart
		 * @param serialIdEnd
		 * @param serialCount
		 * @param jaw
		 * @param isRelevant
		 */
		String[] data00={"5087",
				"5138",
				"5078",
				"5035",
				"5058",
				"5126",
				"5109",
				"5106",
				"5107",
				"5112",
				"5134",
				"5148",
				"5143",
				"5168",
				"5226",
				"5227",
				"5239",
				"5147",
				"5165",
				"5166",
				"5167",
				"5003"
};
		String[] data10={"3001",
				"5001",
				"DE00001",
				"LA00001",
				"W000001",
				"00001",
				"00001",
				"1",
				"1",
				"7201",
				"6001",
				"6001",
				"BH010001",
				"Z0001",
				"1",
				"G0000",
				"H0001",
				"Z0001",
				"AA00",
				"AA00",
				"J1",
				"S000A"};
		String[] data20={"4481",
				"8442",
				"DE11210",
				"LA17735",
				"W009640",
				"06000",
				"06000",
				"6000",
				"6000",
				"7206000",
				"8100",
				"8100",
				"BH241450",
				"Z1000",
				"1988",
				"G3631",
				"H3988",
				"Z2000",
				"7T51",
				"7T51",
				"J1200",
				"S999K"};
		String data="";
		for (int i = 0; i < data20.length; i++)
		{
			//data=data + (i+1)+",";
			data=data + data00[i]+",";
			data=data + "860"+",";
			data=data + "8-8"+",";
			data=data + data10[i]+",";
			data=data + data20[i]+",";
			data=data + "8000"+",";
			data=data + "F"+",";
			if (i==data20.length-1)
			{
				data=data + "yes"+"";
			}
			else {
				data=data + "yes"+";";
			}
			
		}
		if (data==null)
		{
			return new FSearchResult(null,false,"");
		}
		String[] data0=data.split(";");
		if (data0.length<1)
		{
			return new FSearchResult(null,false,"");
		}
		List<FSearchData> dataKey=new ArrayList<FSearchData>();
		for (int i = 0; i < data0.length; i++)
		{
			FSearchData data2=getFSearchData(i+1,data0[i]);
			if (data2==null)
			{
				return new FSearchResult(null,false,"");
			}
			dataKey.add(data2);
		}
		FSearchResult datas=new FSearchResult(dataKey,true,"");
		
		return datas;
	}
}
