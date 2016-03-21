package cn.edu.znufe.dhf.apisapp.service;

import cn.edu.znufe.dhf.apisapp.constant.App;
import cn.edu.znufe.dhf.apisapp.model.HealthyDetailsObject;
import cn.edu.znufe.dhf.apisapp.model.HealthyMapObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aaric on 2016/3/16.
 */
public interface HealthyService {

    /**
     * Get data list.
     *
     * @param id default 0
     * @param page default 1
     * @param rows default 10
     * @return
     * @throws Exception
     */
    @GET(App.SUFFIX_URL_HEALTHY)
    Call<HealthyMapObject> getData(@Query("id") Integer id, @Query("page") Integer page, @Query("rows") Integer rows) throws Exception;

    /**
     * Get data details.
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GET(App.SUFFIX_URL_HEALTHY_DETAILS)
    Call<HealthyDetailsObject> getDataDetails(@Query("id") Integer id) throws Exception;

}
