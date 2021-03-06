package com.b8games.beatpug.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.b8games.beatpug.R;
import com.b8games.beatpug.adapter.SimpleRecyclerAdapter;
import com.b8games.beatpug.model.VersionModel;

import java.util.ArrayList;
import java.util.List;

public class TabAnimationActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FrameLayout mContentFrame;

    private static final String PREFERENCES_FILE = "mymaterialapp_settings";
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private boolean mUserLearnedDrawer;
    private int mCurrentSelectedPosition;
    private boolean mFromSavedInstanceState;

    private AppBarLayout appbar;
    private Toolbar usttool;
    private NavigationView nnavview;
    TabLayout tabLayout;
     ViewPager viewPager;
    String left;
    String top;
    String right;
    String bottom;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_animation);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setUpToolbar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
        mUserLearnedDrawer = Boolean.valueOf(readSharedSetting(this, PREF_USER_LEARNED_DRAWER, "true"));

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        setUpNavDrawer();

        usttool = (Toolbar) findViewById(R.id.toolbar);
        nnavview = (NavigationView) findViewById(R.id.nav_view);
        appbar = (AppBarLayout) findViewById(R.id.tabanim_appbar);


        viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager);

          tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);



        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        break;
                    case 1:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        break;
                    case 2:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mUserLearnedDrawer = Boolean.valueOf(readSharedSetting(this, PREF_USER_LEARNED_DRAWER, "true"));

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        setUpNavDrawer();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mContentFrame = (FrameLayout) findViewById(R.id.nav_contentframe);

        mNavigationView.setCheckedItem(R.id.navigation_item_1);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_item_1:
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mCurrentSelectedPosition = 0;
                        return true;
                    case R.id.navigation_item_2:
                        mCurrentSelectedPosition = 1;
                        return true;
                    case R.id.navigation_item_3:
                        Intent intent = new Intent(TabAnimationActivity.this, klipler.class);
                        startActivity(intent);
                        mCurrentSelectedPosition = 2;
                        return true;
                    case R.id.navigation_item_4:
                        mCurrentSelectedPosition = 3;
                        return true;
                    case R.id.navigation_item_5:
                        mCurrentSelectedPosition = 4;
                        return true;
                    default:
                        return true;
                }
            }
        });
        appbar.measure(AppBarLayout.LayoutParams.WRAP_CONTENT, AppBarLayout.LayoutParams.WRAP_CONTENT);
         height = appbar.getMeasuredHeight();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            usttool.setVisibility(View.INVISIBLE);
            nnavview.setVisibility(View.INVISIBLE);
            tabLayout.setVisibility(View.INVISIBLE);

            appbar.setVisibility(View.INVISIBLE);

            ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(viewPager.getLayoutParams());
            marginParams.setMargins(0, 0, 0, 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
            viewPager.setLayoutParams(layoutParams);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            usttool.setVisibility(View.VISIBLE);
            nnavview.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.VISIBLE);
            appbar.setVisibility(View.VISIBLE);

            ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(viewPager.getLayoutParams());
            marginParams.setMargins(0, height, 0, 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
            viewPager.setLayoutParams(layoutParams);
        }
    }

    void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.accent_material_light)), "TWITTER");
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.ripple_material_light)), "FACEBOOK");
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.button_material_dark)), "CANLI YAYIN");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION, 0);
        Menu menu = mNavigationView.getMenu();
        menu.getItem(mCurrentSelectedPosition).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void setUpToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

    private void setUpNavDrawer() {
        if (mToolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationIcon(R.drawable.ic_drawer);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }

        if (!mUserLearnedDrawer) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            mUserLearnedDrawer = true;
            saveSharedSetting(this, PREF_USER_LEARNED_DRAWER, "false");
        }

    }

    public static void saveSharedSetting(Context ctx, String settingName, String settingValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(settingName, settingValue);
        editor.apply();
    }

    public static String readSharedSetting(Context ctx, String settingName, String defaultValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return sharedPref.getString(settingName, defaultValue);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_switch:
                Intent intent = new Intent(TabAnimationActivity.this, TabsHeaderActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);

        }

        @Override
        public Fragment getItem(int position) {

            switch (position){

                case 0:
                    return new SearchTimelineFragment();

                case 1:
                    return new facebookactivity();

                case 2:
                    return new canliyayinacticity();

                default:
                    break;
            }


            return null;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public static class DummyFragment extends Fragment {
        int color;
        SimpleRecyclerAdapter adapter;

        public DummyFragment() {
        }

        @SuppressLint("ValidFragment")
        public DummyFragment(int color) {
            this.color = color;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.dummy_fragment, container, false);

            final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
            frameLayout.setBackgroundColor(color);

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);

            List<String> list = new ArrayList<String>();
            for (int i = 0; i < VersionModel.data.length; i++) {
                list.add(VersionModel.data[i]);
            }

            adapter = new SimpleRecyclerAdapter(list);
            recyclerView.setAdapter(adapter);

            return view;
        }
    }

}
