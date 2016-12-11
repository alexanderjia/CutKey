package com.example.zhangjia.cutkey.bean;

/**
 * Created by zhangjia on 16/6/3.
 */
public class Tooth {
    private int No;
    private  int SerialId;
    private int KeyWidth;
    private String Cuts;
    private String SerialStart;
    private  String SerialIdEnd;
    private int SerialCount;
    private String Jaw;
    private boolean bool;
    private String Tooth;
    private String ToothCode;
    private String Fistletter;

    public String getFistletter() {
        return Fistletter;
    }

    public void setFistletter(String fistletter) {
        Fistletter = fistletter;
    }

    public String getTooth() {
        return Tooth;
    }

    public void setTooth(String tooth) {
        Tooth = tooth;
    }

    public String getToothCode() {
        return ToothCode;
    }

    public void setToothCode(String toothCode) {
        ToothCode = toothCode;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public int getSerialId() {
        return SerialId;
    }

    public void setSerialId(int serialId) {
        SerialId = serialId;
    }

    public int getKeyWidth() {
        return KeyWidth;
    }

    public void setKeyWidth(int keyWidth) {
        KeyWidth = keyWidth;
    }

    public String getCuts() {
        return Cuts;
    }

    public void setCuts(String cuts) {
        Cuts = cuts;
    }

    public String getSerialStart() {
        return SerialStart;
    }

    public void setSerialStart(String serialStart) {
        SerialStart = serialStart;
    }

    public String getSerialIdEnd() {
        return SerialIdEnd;
    }

    public void setSerialIdEnd(String serialIdEnd) {
        SerialIdEnd = serialIdEnd;
    }

    public int getSerialCount() {
        return SerialCount;
    }

    public void setSerialCount(int serialCount) {
        SerialCount = serialCount;
    }

    public String getJaw() {
        return Jaw;
    }

    public void setJaw(String jaw) {
        Jaw = jaw;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
