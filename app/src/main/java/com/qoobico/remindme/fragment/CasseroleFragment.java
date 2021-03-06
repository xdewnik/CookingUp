package com.qoobico.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qoobico.remindme.R;


public class CasseroleFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.example;



    public static CasseroleFragment getInstance(Context context){
        Bundle args = new Bundle();
        CasseroleFragment fragment = new CasseroleFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_casserole));
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container,false);
        return view;
    }
    public void setContext(Context context) {
        this.context = context;
    }


}
