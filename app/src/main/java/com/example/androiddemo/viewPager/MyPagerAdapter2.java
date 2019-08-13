package com.example.androiddemo.viewPager;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * @author Menglingshuai
 * @date 2019-08-13.
 * email：mlsnatalie@163.com
 * description：
 */
public class MyPagerAdapter2 extends PagerAdapter {
    private ArrayList<View> viewLists;
    private ArrayList<String> titleLists;

    public MyPagerAdapter2() {
    }

    public MyPagerAdapter2(ArrayList<View> viewLists, ArrayList<String> titleLists) {
        this.viewLists = viewLists;
        this.titleLists = titleLists;
    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleLists.get(position);
    }
}
