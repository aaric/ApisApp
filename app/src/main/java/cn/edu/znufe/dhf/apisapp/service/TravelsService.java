package cn.edu.znufe.dhf.apisapp.service;

import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.model.TravelsMapObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aaric on 2016/3/16.
 */
public interface TravelsService {

    /**
     * Get list data.
     *
     * @param query default ""
     * @param page default 1
     * @return
     * @throws Exception
     */
    @GET(App.SUFFIX_URL_TRAVELS)
    Call<TravelsMapObject> getData(@Query("query") String query, @Query("page") Integer page) throws Exception;

}
