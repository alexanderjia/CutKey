package com.example.zhangjia.cutkey.utile;

import com.example.zhangjia.cutkey.background.bean.Manufacturers;
import com.example.zhangjia.cutkey.bean.Factory;

import java.util.Comparator;

/**
 * 用来对ListView中的数据根据A-Z进行排序，前面两个if判断主要是将不是以汉字开头的数据放在后面
 */
public class PinyinComparator implements Comparator<Manufacturers> {


    @Override
    public int compare(Manufacturers lhs, Manufacturers rhs) {
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
