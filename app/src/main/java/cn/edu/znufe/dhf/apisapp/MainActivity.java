package cn.edu.znufe.dhf.apisapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import cn.edu.znufe.dhf.apisapp.adapter.HealthyAdapter;
import cn.edu.znufe.dhf.apisapp.adapter.NewsAdapter;
import cn.edu.znufe.dhf.apisapp.adapter.TravelsAdapter;
import cn.edu.znufe.dhf.apisapp.model.HealthyMapObject;
import cn.edu.znufe.dhf.apisapp.model.NewsMapObject;
import cn.edu.znufe.dhf.apisapp.model.TravelsMapObject;
import cn.edu.znufe.dhf.apisapp.service.HealthyService;
import cn.edu.znufe.dhf.apisapp.service.NewsService;
import cn.edu.znufe.dhf.apisapp.service.TravelsService;
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
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_about) {
            // Exit.
            Process.killProcess(Process.myPid());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cn.edu.znufe.dhf.apisapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cn.edu.znufe.dhf.apisapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
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
                                //Log.e(TAG, "code---->" + response.code());
                                //Log.e(TAG, "result-->" + response.body().getNewslist().size());
                                mListView.setAdapter(new NewsAdapter(getContext(), response.body().getNewslist()));
                                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Intent intent = new Intent();
                                        intent.setClass(view.getContext(), BrowserActivity.class);
                                        intent.putExtra("title", "title");
                                        intent.putExtra("url", "http://www.baidu.com");
                                        startActivity(intent);
                                    }
                                });
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
                    try {
                        HealthyService healthyService = RetrofitHelper.getInstance(HealthyService.class);
                        Call<HealthyMapObject> call = healthyService.getData(0, 1, 10);
                        call.enqueue(new Callback<HealthyMapObject>() {
                            @Override
                            public void onResponse(Call<HealthyMapObject> call, Response<HealthyMapObject> response) {
                                //Log.e(TAG, "code---->" + response.code());
                                //Log.e(TAG, "result-->" + response.body().getTngou().size());
                                mListView.setAdapter(new HealthyAdapter(getContext(), response.body().getTngou()));
                            }

                            @Override
                            public void onFailure(Call<HealthyMapObject> call, Throwable t) {
                                Log.e(TAG, "exception-->" + t.getLocalizedMessage());
                            }
                        });

                    } catch (Exception e) {
                        Log.e(TAG, "exception-->" + e.getLocalizedMessage());
                    }
                    break;
                case 3:
                    // Travels
                    try {
                        TravelsService travelsService = RetrofitHelper.getInstance(TravelsService.class);
                        Call<TravelsMapObject> call = travelsService.getData("", 1);
                        call.enqueue(new Callback<TravelsMapObject>() {
                            @Override
                            public void onResponse(Call<TravelsMapObject> call, Response<TravelsMapObject> response) {
                                //Log.e(TAG, "code---->" + response.code());
                                //Log.e(TAG, "result-->" + response.body().getData().getBooks().size());
                                mListView.setAdapter(new TravelsAdapter(getContext(), response.body().getData().getBooks()));
                            }

                            @Override
                            public void onFailure(Call<TravelsMapObject> call, Throwable t) {
                                Log.e(TAG, "exception-->" + t.getLocalizedMessage());
                            }
                        });

                    } catch (Exception e) {
                        Log.e(TAG, "exception-->" + e.getLocalizedMessage());
                    }
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
