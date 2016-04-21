package cn.edu.znufe.dhf.apisapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableRow;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TableRow tableRowFavourite = (TableRow) findViewById(R.id.activity_settings_tablerow_favourite);
        tableRowFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), FavouriteActivity.class);
                startActivity(intent);
            }
        });

        TableRow tableRowExit = (TableRow) findViewById(R.id.activity_settings_tablerow_exit);
        tableRowExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(view.getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定退出吗？")
                        .setContentText("该操作将关闭此程序。")
                        .setCancelText("取消")
                        .showCancelButton(true)
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog dialog) {
                                Process.killProcess(Process.myPid());
                                dialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Toast.makeText(this, "settings", Toast.LENGTH_LONG).show();
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
        }
        return super.onOptionsItemSelected(item);
    }

}
