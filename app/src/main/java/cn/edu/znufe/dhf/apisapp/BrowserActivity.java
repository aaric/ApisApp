package cn.edu.znufe.dhf.apisapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;
import java.util.List;

import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.entity.FavouriteData;
import cn.edu.znufe.dhf.apisapp.helper.DatabaseHelper;

public class BrowserActivity extends AppCompatActivity {

    private String mTitle;
    private String mRedirectUrl;
    private String mImageUrl;
    private String mDescription;
    private String mTag;
    private boolean mFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        mTitle = getIntent().getStringExtra(App.BROWSER_TITLE_KEY);
        mRedirectUrl = getIntent().getStringExtra(App.BROWSER_REDIRECT_URL_KEY);
        mImageUrl = getIntent().getStringExtra(App.BROWSER_IMAGE_URL_KEY);
        mDescription = getIntent().getStringExtra(App.BROWSER_DESCRIPTION_KEY);
        mTag = getIntent().getStringExtra(App.BROWSER_TAG_KEY);

        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(mTitle);
        }

        WebView mWebView = (WebView) this.findViewById(R.id.webView);
        mWebView.loadUrl(mRedirectUrl);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        try {
            DatabaseHelper dbHelper = DatabaseHelper.getInstance(getApplicationContext());
            Dao<FavouriteData, Integer> favouriteDataDao = dbHelper.getDao(FavouriteData.class);
            List<FavouriteData> favouriteDataList = favouriteDataDao.queryForEq("title", mTitle);
            if(null == favouriteDataList && 0 != favouriteDataList.size()) {
                mFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_browser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = NavUtils.getParentActivityIntent(this);
                if(NavUtils.shouldUpRecreateTask(this, intent)) {
                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(intent)
                            .startActivities();
                } else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    NavUtils.navigateUpTo(this, intent);
                }
                return true;
            case R.id.action_favourite:
                if(!mFlag) {
                    try {
                        DatabaseHelper dbHelper = DatabaseHelper.getInstance(getApplicationContext());
                        Dao<FavouriteData, Integer> favouriteDataDao = dbHelper.getDao(FavouriteData.class);
                        List<FavouriteData> favouriteDataList = favouriteDataDao.queryForEq("title", mTitle);
                        if(null == favouriteDataList || 0 == favouriteDataList.size()) {
                            FavouriteData favouriteData = new FavouriteData(mTitle, mRedirectUrl, "");
                            favouriteDataDao.create(favouriteData);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    item.setIcon(R.drawable.favourited);
                    Toast.makeText(this, "添加收藏成功！", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        DatabaseHelper dbHelper = DatabaseHelper.getInstance(getApplicationContext());
                        Dao<FavouriteData, Integer> favouriteDataDao = dbHelper.getDao(FavouriteData.class);
                        List<FavouriteData> favouriteDataList = favouriteDataDao.queryForEq("title", mTitle);
                        if (null != favouriteDataList && 0 != favouriteDataList.size()) {
                            FavouriteData favouriteData = favouriteDataList.get(0);
                            favouriteDataDao.deleteById(favouriteData.getId());
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    item.setIcon(R.drawable.favourite);
                    Toast.makeText(this, "取消收藏成功！", Toast.LENGTH_LONG).show();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
