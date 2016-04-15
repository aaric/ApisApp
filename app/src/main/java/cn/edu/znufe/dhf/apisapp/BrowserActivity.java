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

import cn.edu.znufe.dhf.apisapp.constant.App;

public class BrowserActivity extends AppCompatActivity {

    private String mTitle;
    private String mRedirectUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        mTitle = getIntent().getStringExtra(App.BROWSER_TITLE_KEY);
        mRedirectUrl = getIntent().getStringExtra(App.BROWSER_REDIRECT_URL_KEY);

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_browser, menu);
        return true;
    }

    boolean flag = false;

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
                if(!flag) {
                    item.setIcon(R.drawable.favourited);
                    Toast.makeText(this, "添加收藏成功！", Toast.LENGTH_LONG).show();
                } else {
                    item.setIcon(R.drawable.favourite);
                    Toast.makeText(this, "取消收藏成功！", Toast.LENGTH_LONG).show();
                }
                flag = !flag;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
