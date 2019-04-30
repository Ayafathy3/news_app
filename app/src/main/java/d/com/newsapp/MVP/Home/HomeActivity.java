package d.com.newsapp.MVP.Home;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import d.com.newsapp.MVP.Categories.Views.ArtFragment;
import d.com.newsapp.MVP.Categories.Views.BusinessFragment;
import d.com.newsapp.MVP.Categories.Views.HealthFragment;
import d.com.newsapp.MVP.Categories.Views.ScienceFragment;
import d.com.newsapp.MVP.Categories.Views.SportFragment;
import d.com.newsapp.MVP.Categories.Views.TechFragment;
import d.com.newsapp.MVP.Main.MainFragment;
import d.com.newsapp.R;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    public TextView tittle;
    ViewPager viewPager;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initiViews();
        setSupportActionBar(toolbar);
        setUpTabLayout();
    }

    private void setUpTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("الكل"));
        tabLayout.addTab(tabLayout.newTab().setText("الصحة"));
        tabLayout.addTab(tabLayout.newTab().setText("الصناعه"));
        tabLayout.addTab(tabLayout.newTab().setText("العلوم"));
        tabLayout.addTab(tabLayout.newTab().setText("التكنولوجيا"));
        tabLayout.addTab(tabLayout.newTab().setText("الفن"));
        tabLayout.addTab(tabLayout.newTab().setText("الرياضة"));

        viewPager.setAdapter(new AdapterViewPager(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected( TabLayout.Tab tab ) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tittle.setText("الكل");
                        break;
                    case 1:
                        tittle.setText("الصحة");
                        break;
                    case 2:
                        tittle.setText("الصناعة");
                        break;
                    case 3:
                        tittle.setText("العلوم");
                        break;
                    case 4:
                        tittle.setText("التكنولوجيا");
                        break;
                    case 5:
                        tittle.setText("الفن");
                        break;
                    case 6:
                        tittle.setText("الرياضة");
                        break;

                }
            }

            @Override
            public void onTabUnselected( TabLayout.Tab tab ) {

            }

            @Override
            public void onTabReselected( TabLayout.Tab tab ) {

            }
        });
    }

    private void initiViews() {
        toolbar = findViewById(R.id.tool_bar);
        tabLayout = findViewById(R.id.tablayout);
        tittle = findViewById(R.id.title_tool_bar);
        viewPager = findViewById(R.id.view_pager);
    }

    class AdapterViewPager extends FragmentPagerAdapter {

        public AdapterViewPager( FragmentManager fm ) {
            super(fm);
        }

        @Override
        public Fragment getItem( int position ) {
            switch (position) {
                case 0:
                    return new MainFragment();
                case 1:
                    return new HealthFragment();
                case 2:
                    return new BusinessFragment();
                case 3:
                    return new ScienceFragment();
                case 4:
                    return new TechFragment();
                case 5:
                    return new ArtFragment();
                case 6:
                    return new SportFragment();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 7;
        }
    }
}
