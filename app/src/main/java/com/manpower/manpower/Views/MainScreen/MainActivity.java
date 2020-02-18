package com.manpower.manpower.Views.MainScreen;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.manpower.manpower.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import devlight.io.library.ntb.NavigationTabBar;


// todo RENAME
public class MainActivity extends AppCompatActivity
{
        
        @BindView(R.id.pager)
        public ViewPager viewPager;
        
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setTheme(R.style.AppTheme);
                setContentView(R.layout.activity_main);
                ButterKnife.bind(this);
                
                
                InitTabBar();
        }
        
        private void InitTabBar() {
                PagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(adapter);
                
                final String[] colors = getResources().getStringArray(R.array.default_preview);
                
                final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(
                        R.id.ntb_horizontal);
                
                final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
                models.add(
                        new NavigationTabBar.Model.Builder(
                                getResources().getDrawable(R.drawable.ic_launcher_background),
                                Color.parseColor(colors[0]))
                                .title("Featured")
                                .badgeTitle("New")
                                .build()
                );
                models.add(
                        new NavigationTabBar.Model.Builder(
                                getResources().getDrawable(R.drawable.ic_launcher_background),
                                Color.parseColor(colors[0]))
                                
                                .title("Search")
                                // .badgeTitle("with")
                                .build()
                );
                models.add(
                        
                        new NavigationTabBar.Model.Builder(
                                getResources().getDrawable(R.drawable.ic_launcher_background),
                                Color.parseColor(colors[0]))
                                .title("My Foodle")
                                // .badgeTitle("state")
                                .build()
                );
                models.add(
                        new NavigationTabBar.Model.Builder(
                                getResources().getDrawable(R.drawable.ic_launcher_background),
                                Color.parseColor(colors[0]))
                                .title("Notifications")
                                .badgeTitle("3")
                                .build()
                );
                models.add(
                        new NavigationTabBar.Model.Builder(
                                getResources().getDrawable(R.drawable.ic_launcher_background),
                                Color.parseColor(colors[0]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                                .title("More")
                                // .badgeTitle("icon")
                                .build()
                );
                
                
                navigationTabBar.setModels(models);
                navigationTabBar.setViewPager(viewPager);
                navigationTabBar.setIsBadged(true);
                navigationTabBar.setBehaviorEnabled(true);
                
                
                navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
                {
                        @Override
                        public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                        
                        }
                        
                        @Override
                        public void onPageSelected(final int position) {
                                navigationTabBar.getModels()
                                        .get(position)
                                        .hideBadge();
                        }
                        
                        @Override
                        public void onPageScrollStateChanged(final int state) {
                        
                        }
                });
                
                navigationTabBar.postDelayed(new Runnable()
                {
                        @Override
                        public void run() {
                                for (int i = 0; i < navigationTabBar.getModels()
                                        .size(); i++) {
                                        final NavigationTabBar.Model model = navigationTabBar.getModels()
                                                .get(i);
                                        navigationTabBar.postDelayed(new Runnable()
                                        {
                                                @Override
                                                public void run() {
                                                        model.showBadge();
                                                }
                                        }, i * 100);
                                }
                        }
                }, 500);
                
                
        }
        
        public void FocusOnTab(MainTabsType tabType) {
                viewPager.setCurrentItem((tabType.getValue()), true);
        }
        
        
        
}
