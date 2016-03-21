package cn.edu.znufe.dhf.apisapp;

import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.znufe.dhf.apisapp.adapter.NewsAdapter;
import cn.edu.znufe.dhf.apisapp.model.NewsMapObject;
import cn.edu.znufe.dhf.apisapp.service.NewsService;
import cn.edu.znufe.dhf.apisapp.util.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Main Activity.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * TAG
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // Settings.
            return true;
        } else if (id == R.id.action_about) {
            // Exit.
            Process.killProcess(Process.myPid());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int section = getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            final ListView mListView = (ListView) rootView.findViewById(R.id.listView);
            Log.i(TAG, "section----->" + section);

            // Test data.
            List<Map<String, String>> list = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                Map<String, String> map = new HashMap<>();
                map.put("title", "test" + section + i);
                map.put("time", "" + Calendar.getInstance().getTimeInMillis());
                list.add(map);
            }

            SimpleAdapter mSimpleAdapter = null;

            // Select Fragment.
            switch (section) {
                case 1:
                    // News
                    try {
                        NewsService newsService = RetrofitHelper.getInstance(NewsService.class);
                        Call<NewsMapObject> call = newsService.getData(10, 1);
                        call.enqueue(new Callback<NewsMapObject>() {
                            @Override
                            public void onResponse(Call<NewsMapObject> call, Response<NewsMapObject> response) {
                                Log.e(TAG, "code---->" + response.code());
                                Log.e(TAG, "result-->" + response.body().getNewslist().size());
                                mListView.setAdapter(new NewsAdapter(getContext(), response.body().getNewslist()));
                            }

                            @Override
                            public void onFailure(Call<NewsMapObject> call, Throwable t) {
                                Log.e(TAG, "exception-->" + t.getLocalizedMessage());
                            }
                        });

                    } catch (Exception e) {
                        Log.e(TAG, "exception-->" + e.getLocalizedMessage());
                    }
                    break;
                case 2:
                    // Healthy
                    mSimpleAdapter = new SimpleAdapter(container.getContext(), list,
                            R.layout.fragment_item_healthy,
                            new String[]{"title", "time"},
                            new int[]{R.id.healthy_title, R.id.healthy_time});
                    mListView.setAdapter(mSimpleAdapter);
                    break;
                case 3:
                    // Travels
                    mSimpleAdapter = new SimpleAdapter(container.getContext(), list,
                            R.layout.fragment_item_travels,
                            new String[]{"title", "time"},
                            new int[]{R.id.travels_title, R.id.travels_time});
                    mListView.setAdapter(mSimpleAdapter);
                    break;
                default:
                    // Nothing
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.activity_main_news);
                case 1:
                    return getString(R.string.activity_main_healthy);
                case 2:
                    return getString(R.string.activity_main_travels);
            }
            return null;
        }
    }
}
