package com.example.androiddemo.coordinatorLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author: mlsnatalie
 * @date: 2020/12/22 5:39 PM
 * @UpdateDate: 2020/12/22 5:39 PM
 * email：mlsnatalie@163.com
 * description：
 */
class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTitles;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragments, List<String> titles) {
        super(fm, behavior);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
