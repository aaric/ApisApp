package cn.edu.znufe.dhf.apisapp;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.util.NetworkUtils;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    /**
     * TAG
     */
    private static final String TAG = ApplicationTestCase.class.getSimpleName();

    /**
     * Constructor
     */
    public ApplicationTest() {
        super(Application.class);
    }

    /**
     * Test for get string by restTemplate
     *
     * @throws Exception
     */
    public void testGetForString() throws Exception {
        //Log.e(TAG, "result----->" + NetworkUtils.getForString(App.TEST_URL_NEWS));
        //Log.e(TAG, "result----->" + NetworkUtils.getForString(App.TEST_URL_HEALTHY));
        Log.e(TAG, "result----->" + NetworkUtils.getForString(App.TEST_URL_TRAVELS));
    }

    /**
     * Test for get object by retrofit
     *
     * @throws Exception
     */
    public void testRetrofit() throws Exception {
        /*String httpUrl = "";
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080")
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<TestObject> call = retrofitService.getMessZh("test");
        Log.e(TAG, "result----->" + call.execute().body().getMessage());*/

    }

}