package com.example.zhangjia.cutkey.background.model;

import com.example.zhangjia.cutkey.background.bean.UnlockToolCodes;

import java.util.ArrayList;
import java.util.List;


public class ModelUnlockToolCodeSearch implements IModelUnlockToolCodeSearch
{

	@Override
	public List<UnlockToolCodes> getUnlockToolCodes()
	{
		// TODO Auto-generated method stub
		return createUnlockToolCodesData();
	}
	
	private List<UnlockToolCodes> createUnlockToolCodesData()
	{
		List<UnlockToolCodes> data=new ArrayList<UnlockToolCodes>();
		
		String[] unlockToolCodeName=getUnlockToolCodeName();
		String[] manufacturersName=getManufacturersName();
		String[] serial=getUnlockToolCodeSerial();
		String[] cuts=getUnlockToolCodeCuts();
		int count=manufacturersName.length;
		int unlockToolCodeID=50000;
		for(int i=0;i<count;i++)
		{
			UnlockToolCodes data0=new UnlockToolCodes(i+1,unlockToolCodeID+i+1,
					unlockToolCodeName[i],manufacturersName[i],serial[i],cuts[i],"");
			data.add(data0);
		}		
		
		return data;
	}
	
	private String getManufacturersName(int index)
	{
		int unlockToolCodesId=50000;
		if (index<unlockToolCodesId || index>unlockToolCodesId)
		{
			return null;
		}
		String[] manufacturers=new String[]{""};
		
		return manufacturers[index-unlockToolCodesId];
	}
	
	private String[] getManufacturersName()
	{
		String[] manufacturers=new String[]{"ACURA",
				"ALFA ROMEO",
				"CHEVROLET",
				"CITROËN,CITROËN",
				"FORD",
				"FORD",
				"HYUNDAI ,HYUNDAI ,HYUNDAI ",
				"HYUNDAI ,HYUNDAI ,HYUNDAI ,HYUNDAI ",
				"KIA",
				"LEXUS",
				"LEXUS,MITSUBISHI,TOYOTA",
				"SAAB,SAAB",
				"SUBARU",
				"SMART,VOLVO,VOLVO",
				"ALFA ROMEO",
				"AUDI,AUDI,AUDI,AUDI,FORD,SKODA",
				"BMW",
				"CITROËN",
				"OPEL-VAUXHALL",
				"RENAULT,RENAULT,RENAULT",
				"ACURA",
				"ALFA ROMEO",
				"BUICK,BUICK,BUICK",
				"BUICK",
				"BUICK,BUICK",
				"CHEVROLET,CHEVROLET",
				"CHEVROLET",
				"CHEVROLET",
				"CHRYSLER,CHRYSLER",
				"DAEWOO",
				"DAEWOO",
				"FIAT",
				"FORD,FORD",
				"FORD,FORD",
				"FORD",
				"GMC,TOYOTA",
				"HONDA",
				"HYUNDAI ",
				"HYUNDAI ",
				"INFINITI",
				"INFINITI,NISSAN",
				"KIA",
				"KIA",
				"MAZDA",
				"MERCEDES",
				"MITSUBISHI",
				"OPEL-VAUXHALL,SUZUKI",
				"OPEL-VAUXHALL",
				"SUBARU",
				"SUBARU",
				"TOYOTA,TOYOTA",
				"VOLKSWAGEN"
};
		
		return manufacturers;
	}
	
	private String getUnlockToolCodeName(int index)
	{
		int unlockToolCodesId=50000;
		if (index<unlockToolCodesId || index>unlockToolCodesId)
		{
			return null;
		}
		
		String[] unlockToolCodeName=new String[]{""};
		
		return unlockToolCodeName[index-unlockToolCodesId];
	}
	
	private String[] getUnlockToolCodeName()
	{
		
		String[] unlockToolCodeName=new String[]{"HON66FH",
				"SIP16FH",
				"GM45FH",
				"VA6FH",
				"HU101MH",
				"HU101AP",
				"TOY40N",
				"HYN14FRN",
				"TOY40FN",
				"TOY48FH",
				"TOY40FH",
				"YM30T5",
				"DAT17FH",
				"HU56RFH",
				"SIP22FH",
				"HU66FH",
				"HU92RKP",
				"HU83FH",
				"HU100FH",
				"VAC102FH",
				"HON58RFH",
				"GT15RFH",
				"B100",
				"GM5",
				"B111-PT",
				"DWO4FH",
				"MIT8FH",
				"GM39",
				"CY24FH",
				"DWO6BT6",
				"SU46AT5",
				"GT10FH",
				"FO38RFH",
				"FO37R",
				"FO32R",
				"TOY43RFH",
				"HON65RT6",
				"HYN6FH",
				"HYN7RFH",
				"NSN14FH",
				"NSN11FH",
				"HYN14FH",
				"KIA3RFH",
				"MAZ24RFH",
				"YM15FH",
				"MIT11RFH",
				"HU87RFH",
				"MY28FH HU46FH",
				"SZ12FH",
				"NSN19MH",
				"TOY41RFH",
				"HU49FH"
};
		
		return unlockToolCodeName;
	}
	
	private String getUnlockToolCodeSerial(int index)
	{
		int unlockToolCodesId=50000;
		if (index<unlockToolCodesId || index>unlockToolCodesId)
		{
			return null;
		}
		
		String[] unlockToolCodeSerial=new String[]{""};
		
		return unlockToolCodeSerial[index-unlockToolCodesId];
	}
	
	private String[] getUnlockToolCodeSerial()
	{
		
		String[] unlockToolCodeSerial=new String[]{"K001-M999, N001-N718",
				"00001-17735",
				"60000-62113 ",
				"12897-A9999;AAAAAA-FFFFFF",
				"10001-11500",
				"0001-4000",
				"K0001-K2500;G0001-G2500;J0001-J2500",
				"T0001-T2500;V0001-V1200;T0001-T2500;H0001-H2500 ",
				"L0001-L1037",
				"40000-49999",
				"0001-5000;30001-31200;0001-5000",
				"2S0001-2S2675;BC0001-BC2865",
				"T0001-T3000",
				"DH0001-DH4000;DH6001-DH8000;DH6001-DH8000",
				"DE00001-DE11210",
				"0001-6000 ;6001-8100;0001-6000 EXT;6001-8100 EXT;0001-6000;00001-17850",
				"0001-8100",
				"HCA0001-HCA2000",
				"Z4001-Z6314",
				"111111-555555;0001-4092;5001-9092",
				"5001-8442",
				"W0001-W9640",
				"G0000-G3631;H0001-H3988;0001-1988",
				"J0001-J1200",
				"O5000-O6999;S000A-S999K",
				"V2001-V3200;T0001-T1200",
				"E5001-E7700",
				"AA00-7T51 ",
				"M0001-M2618;L0001-L3580",
				"M0001-M1200",
				"S5298-S6300",
				"V0001-V3056",
				"0001X-1706X;101A501-304E579",
				"FB0000-FB1863;FA0000-FA1863",
				"10100-12283",
				"70000-75928;10001-15000",
				"R0001-R1706",
				"A0001-A1000",
				"S0001-S1000",
				"00001-22185",
				"X0001-X8000;X8001-X9000",
				"H0001-H2500",
				"Y2001-Y3000",
				"10100-12283",
				"HM4001-HM7350",
				"30010-32009",
				"50001-51308;5001-6308",
				"S0001-S2000",
				"U0001-U2000",
				"30001-37850",
				"G0001-G2377;P0001-P2390",
				"AH7101-AH8154"
};
		
		return unlockToolCodeSerial;
	}
	
	private String getUnlockToolCodeCuts(int index)
	{
		int unlockToolCodesId=50000;
		if (index<unlockToolCodesId || index>unlockToolCodesId)
		{
			return null;
		}
		
		String[] unlockToolCodeCuts=new String[]{""};
		
		return unlockToolCodeCuts[index-unlockToolCodesId];
	}
	
	private String[] getUnlockToolCodeCuts()
	{
		
		String[] unlockToolCodeCuts=new String[]{"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8",
				"8-8"
};
		
		return unlockToolCodeCuts;
	}

}
