package com.example.zhangjia.cutkey.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangjia.cutkey.R;

/**
 * A simple {@link Fragment} subclass.
 * 加工记录
 */
public class Process_recodFragment extends Fragment {


    public Process_recodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_process_recod,null);
        return view;
    }

}
