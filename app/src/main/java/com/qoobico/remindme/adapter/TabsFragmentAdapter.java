package com.qoobico.remindme.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.qoobico.remindme.fragment.AbstractTabFragment;
import com.qoobico.remindme.fragment.GarnishFragment;
import com.qoobico.remindme.fragment.SoupFragment;
import com.qoobico.remindme.fragment.SaladFragment;
import com.qoobico.remindme.fragment.CasseroleFragment;


import java.util.HashMap;
import java.util.Map;


public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;

    private Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
            this.context = context;
        initTabsMap(context);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {

        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, SoupFragment.getInstance(context));
        tabs.put(1, SaladFragment.getInstance(context));
        tabs.put(2, CasseroleFragment.getInstance(context));
        tabs.put(3, GarnishFragment.getInstance(context));
    }
}
