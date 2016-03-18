package cn.edu.znufe.dhf.apisapp;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.model.NewsMapObject;
import cn.edu.znufe.dhf.apisapp.service.NewsService;
import cn.edu.znufe.dhf.apisapp.util.NetworkUtils;
import cn.edu.znufe.dhf.apisapp.util.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //Log.e(TAG, "result----->" + NetworkUtils.getForString(App.BAIDU_API_BASE_URL + App.TEST_URL_NEWS));
        //Log.e(TAG, "result----->" + NetworkUtils.getForString(App.BAIDU_API_BASE_URL + App.TEST_URL_HEALTHY));
        Log.e(TAG, "result----->" + NetworkUtils.getForString(App.BAIDU_API_BASE_URL + App.TEST_URL_TRAVELS));
    }

    /**
     * Test for get object by retrofit
     *
     * @throws Exception
     */
    public void testRetrofit() throws Exception {
        NewsService newsService = RetrofitHelper.getInstance(NewsService.class);
        Call<NewsMapObject> call = newsService.getData();
        call.enqueue(new Callback<NewsMapObject>() {
            @Override
            public void onResponse(Call<NewsMapObject> call, Response<NewsMapObject> response) {
                Log.e(TAG, "code------->" + response.code());
                Log.e(TAG, "result----->" + response.body().getMsg());
            }

            @Override
            public void onFailure(Call<NewsMapObject> call, Throwable t) {

            }
        });
    }

}