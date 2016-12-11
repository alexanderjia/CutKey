package com.example.zhangjia.cutkey.bean;

/**
 * Created by zhangjia on 16/5/8.
 */
public class Factory {
    private int No;
    private int ManufactureIndex;
    private String Manufacture;
    private String Serial;
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

    public int getManufactureIndex() {
        return ManufactureIndex;
    }

    public void setManufactureIndex(int manufactureIndex) {
        ManufactureIndex = manufactureIndex;
    }

    public String getManufacture() {
        return Manufacture;
    }

    public void setManufacture(String manufacture) {
        Manufacture = manufacture;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }
}
