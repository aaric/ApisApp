package cn.edu.znufe.dhf.apisapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by aaric on 16/3/20.
 */
public class GsonUtils {

    /**
     * Get json string.
     *
     * @param object
     * @return
     */
    public static String getString(Object object) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        return gson.toJson(object);
    }

}
