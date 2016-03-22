package cn.edu.znufe.dhf.apisapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import cn.edu.znufe.dhf.apisapp.abs.AbstractActivity;

/**
 * Welcome Activity.
 */
public class WelcomeActivity extends AbstractActivity {

    /**
     * Constants.
     */
    public static final String APPLICATION_IS_FIRST_LAUNCHER = "application_is_first_launcher";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Query configuration.
        SharedPreferences sp = this.getSharedPreferences("config", MODE_PRIVATE);
        boolean isFirst = sp.getBoolean(APPLICATION_IS_FIRST_LAUNCHER, true);

        if (isFirst) {
            // To Load Guidance Activity.
            startActivity(new Intent(this, GuidanceActivity.class));
        } else {
            // To Load Main Activity.
            startActivity(new Intent(this, MainActivity.class));
        }

        // Finish.
        finish();
    }

}
