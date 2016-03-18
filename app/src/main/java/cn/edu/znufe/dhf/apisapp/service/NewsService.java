package cn.edu.znufe.dhf.apisapp.service;

import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.model.NewsMapObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Aaric on 2016/3/16.
 */
public interface NewsService {

    @GET(App.TEST_URL_NEWS)
    @Headers(App.BAIDU_APIKEY_AUTH)
    Call<NewsMapObject> getData() throws Exception;

}
