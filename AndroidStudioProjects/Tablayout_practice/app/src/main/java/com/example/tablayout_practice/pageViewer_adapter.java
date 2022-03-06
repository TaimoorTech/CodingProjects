package com.example.tablayout_practice;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageViewer_adapter extends FragmentPagerAdapter {

    int tabCount;

    public pageViewer_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 : return new t_fragment();
            case 1 : return new h_fragment();
            case 2 : return new a_fragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
