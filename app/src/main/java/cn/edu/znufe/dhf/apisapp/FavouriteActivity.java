package cn.edu.znufe.dhf.apisapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.znufe.dhf.apisapp.adapter.FavouriteAdapter;
import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.entity.FavouriteData;
import cn.edu.znufe.dhf.apisapp.helper.DatabaseHelper;

public class FavouriteActivity extends AppCompatActivity {

    /**
     * TAG
     */
    private static final String TAG = FavouriteActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        try {
            DatabaseHelper dbHelper = DatabaseHelper.getInstance(getApplicationContext());
            Dao<FavouriteData, Integer> favouriteDataDao = dbHelper.getDao(FavouriteData.class);
            final List<FavouriteData> objects = favouriteDataDao.queryForAll();

            ListView favouriteListView = (ListView) findViewById(R.id.listview_favourite);
            favouriteListView.setAdapter(new FavouriteAdapter(getBaseContext(), objects));
            favouriteListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    FavouriteData favouriteData = objects.get(i);
                    Intent intent = new Intent();
                    intent.setClass(view.getContext(), BrowserActivity.class);
                    intent.putExtra(App.BROWSER_TITLE_KEY, favouriteData.getTitle());
                    intent.putExtra(App.BROWSER_REDIRECT_URL_KEY, favouriteData.getUrl());
                    intent.putExtra(App.BROWSER_IMAGE_URL_KEY, favouriteData.getImageUrl());
                    intent.putExtra(App.BROWSER_DESCRIPTION_KEY, favouriteData.getDescription());
                    intent.putExtra(App.BROWSER_TAG_KEY, favouriteData.getTagName());
                    startActivity(intent);
                }
            });


        } catch (SQLException e) {
            Log.e(TAG, "exception-->" + e.getLocalizedMessage());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Toast.makeText(this, "favourite", Toast.LENGTH_LONG).show();
                Intent intent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, intent)) {
                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(intent)
                            .startActivities();
                } else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    NavUtils.navigateUpTo(this, intent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
