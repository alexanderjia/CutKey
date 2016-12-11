package com.example.zhangjia.cutkey.bean;

/**
 * Created by zhangjia on 16/5/22.
 */
public class UnlockTool {
    private int No;
    private int UnlockToolCodeIndex;
    private String UnlockToolCodeName;
    private String ManufaturesName;
    private String Serial;
    private String Cuts;
    private String Fistletter;

    public String getFistletter() {
        return Fistletter;
    }

    public void setFistletter(String fistletter) {
        Fistletter = fistletter;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public int getUnlockToolCodeIndex() {
        return UnlockToolCodeIndex;
    }

    public void setUnlockToolCodeIndex(int unlockToolCodeIndex) {
        UnlockToolCodeIndex = unlockToolCodeIndex;
    }

    public String getUnlockToolCodeName() {
        return UnlockToolCodeName;
    }

    public void setUnlockToolCodeName(String unlockToolCodeName) {
        UnlockToolCodeName = unlockToolCodeName;
    }

    public String getManufaturesName() {
        return ManufaturesName;
    }

    public void setManufaturesName(String manufaturesName) {
        ManufaturesName = manufaturesName;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getCuts() {
        return Cuts;
    }

    public void setCuts(String cuts) {
        Cuts = cuts;
    }
}
