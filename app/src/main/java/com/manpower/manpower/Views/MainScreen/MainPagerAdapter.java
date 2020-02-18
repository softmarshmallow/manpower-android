package com.manpower.manpower.Views.MainScreen;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.manpower.manpower.Views.ProfileTabView.ProfileTabViewFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter
{
        
        private static final String TAG = "MainPagerAdapter";
        
        public MainPagerAdapter(FragmentManager fm) {
                super(fm);
        }
        
        
        
        ProfileTabViewFragment profileTabViewFragment = new ProfileTabViewFragment();
        
        
        @Override
        public int getCount() {
                return MainTabsType.values().length;
        }

        
        @Override
        public Fragment getItem(int position) {
                MainTabsType tabType = MainTabsType.MainTabsPositionMapping.get(position + 1);
                Log.d(TAG, "tab == null : " + (tabType  == null));
                Log.d(TAG, "position : " + position + ", tab : " + tabType);
                
                
                switch (tabType)
                {
                        case More:
                                return profileTabViewFragment;
                        default:
                                return new Fragment();
                }
        }
        
        
}

