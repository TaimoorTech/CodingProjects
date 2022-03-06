package com.example.tablayout_practice;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageViewer_adapter extends FragmentPagerAdapter {

    int tabCounts;

    public pageViewer_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCounts = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return tabCounts;
    }
}
