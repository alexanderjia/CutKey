package com.example.zhangjia.cutkey.background.model;

import java.util.ArrayList;
import java.util.List;

import com.example.zhangjia.cutkey.background.bean.Manufacturers;

public class ModelAutoSearch implements IModelAutoSearch
{

	@Override
	public List<Manufacturers> getManufacturers()
	{
		// TODO Auto-generated method stub
		return createManufacturersData();
		//return null;
	}
	
	
	private List<Manufacturers> createManufacturersData()
	{
		List<Manufacturers> data=new ArrayList<Manufacturers>();
		
		String[] brand=getBrandData();
		String[] idCard=getIDCardData();
		String[] serial=getSerialData();
		int count=idCard.length;
		int brandID=30000;
		for(int i=0;i<count;i++)
		{
			Manufacturers data0=new Manufacturers(i+1,brandID+i+1,brand[i],serial[i],"");
			data.add(data0);
		}		
		
		return data;
	}
	
	private String[] getBrandData()
	{
		String[] brand=new String[]{"ACURA",
				"ALFA ROMEO",
				"AUDI",
				"FORD",
				"BMW",
				"BUICK",
				"CHEVROLET",
				"OPEL-VAUXHALL",
				"TOYOTA",
				"CHRYSLER",
				"CHRYSLER  Crossfire",
				"CITROËN",
				"DAEWOO",
				"DODGE",
				"HYUNDAI ",
				"FIAT",
				"HONDA",
				"MAZDA",
				"NISSAN",
				"INFINITI",
				"GMC",
				"KIA",
				"PEUGEOT",
				"VOLVO",
				"LAND ROVER",
				"LEXUS",
				"MERCEDES",
				"MITSUBISHI",
				"SUBARU",
				"PONTIAC",
				"RENAULT",
				"SMART",
				"SUZUKI"
		};
		return brand;
	}

	private String[] getIDCardData()
	{
		String[] idCard=new String[]{"5001,5002,5087",
				"5003,5004,5138",
				"5005,5007,5008,5010,5011",
				"5006,5049,5051,5053,5054,5056,5058,5059,5126",
				"5012,5160",
				"5014,5015,5016,5019,5020,5170",
				"5017,5021,5025,5027,5078,5027,5171",
				"5024,5175",
				"5026,5079,5147,5244,5245",
				"5028,5029,5030,5031,5032,5034,5169",
				"5033",
				"5035,5036,5194",
				"5038,5040,5043",
				"5039,5044,5046",
				"5042,5045,5102,5103,5106,5107,5108,5109,5110,5112,5114",
				"5047",
				"5050,5080,5084,5088,5090",
				"5052",
				"5070,5072,5122",
				"5071,5119,5120,5121,5123",
				"5076",
				"5111,5129,5134,5135",
				"5124,5196",
				"5127,5165,5248",
				"5139,5141,5142",
				"5143,5144,5148,5149,5150",
				"5156,5158",
				"5163,5168",
				"5173,5209,5239,5240",
				"5177,5230",
				"5213,5214,5221",
				"5231",
				"5243"
			};
		return idCard;
	}
	
	private String[] getSerialData()
	{
		String[] serial=new String[]{"3001-4481,5001-8442,K001-M999, N001-N718",
				"DE1-DE11210,W001-W009640,1-17735",
				"01-06000,1-6000,1-6000 EXT,6001-8100,6001-8100 EXT",
				"01-06000,1X-1706X,10100-12283,FA0-FA1863,PB0-PB1863,6500-7733,10001-11500,101A501-304E579,1-4000",
				"BH010001-BH241450,1-8100",
				"1-1988,G0000-G3631,H0001-H3988,J1-J1200,S000A-S999K,O5000-O6999",
				"AA00-7T51,T1-T1200,V2001-V3200,E5001-E7700,60000-62113,5001-E7700,O5000-O6999",
				"Z4001-Z6314,S1-S2000",
				"10001-15000,P1-P2390,1-5000,B1085-B9547,G1-G2377",
				"M1-M2618,L1-L3580,J1-J3580,H0001-H0400,1003501-1006700,M0-M1394,F1-F1619",
				"3501-6700",
				"12897-A9999,HCA0001 - HCA2000,ABCDEF",
				"S5298-S6300,M1-M1200,18100-19617",
				"T1-T1000,R1-R1000,V1-V1200",
				"S1-S1000,V1-V1200,T1001-3500,T0001-T2500,T1-T2500,G1-G2500,A1-A1000,K1-K2500 ,H0001-H2500,J1-J2500,F0001-F2500",
				"V1-V3056",
				"R1-R1706,H001-H999,K001-M999, N001-N718,E4001-E5000,R4001-R5000",
				"10100-12283",
				"1-8000,X8001-X9000,40001-41518",
				"X1-X8000,1-22185,1-22185,40001-41518,1-2000",
				"70000-75928",
				"H0001-H2500,Y2001-Y3000,L1-L1037,L1-L1037",
				"1-2000,0123456789ABCDEF",
				"4001-9001,DH0001-DH4000,1V00001-5V12295 (Ymos Volvo)",
				"E8000-E8999,NSP7001-NSP9000,7001-9000",
				"0001-5000,0001-5000,40000-49999,80000-89999,80000-89999",
				"HM4001-HM7350,HM6001-HM7110",
				"30010-32009,30001-31200",
				"50001-51308,U1-U2000,T0001-T3000,30001-37850",
				"1-3022,50000-69999",
				"1-4092,5001-9092,12345",
				"1ATS1-1ATS17850",
				"IT5001-IT6308"				
		};
		return serial;
	}
	
}
