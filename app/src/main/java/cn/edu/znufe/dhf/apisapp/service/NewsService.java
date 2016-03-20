package cn.edu.znufe.dhf.apisapp.service;

import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.model.NewsMapObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aaric on 2016/3/16.
 */
public interface NewsService {

    /**
     * Get list data.
     *
     * @param num default 10
     * @param page default 1
     * @return
     * @throws Exception
     */
    @GET(App.SUFFIX_URL_NEWS)
    Call<NewsMapObject> getData(@Query("num") Integer num, @Query("page") Integer page) throws Exception;

}
