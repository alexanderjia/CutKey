package com.example.zhangjia.cutkey.utile;

import com.example.zhangjia.cutkey.background.bean.UnlockToolCodes;


import java.util.Comparator;

/**
 * Created by zhangjia on 16/5/23.
 */
public class PinyinComparatorkey implements Comparator<UnlockToolCodes> {
    @Override
    public int compare(UnlockToolCodes lhs, UnlockToolCodes rhs) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (lhs.getFistletter().equals("@")
                || rhs.getFistletter().equals("#")){
            return -1;
        }else if (lhs.getFistletter().equals("#")
                || rhs.getFistletter().equals("@")){
            return 1;
        }else {
            return lhs.getFistletter().compareTo(rhs.getFistletter());
        }
    }
}
