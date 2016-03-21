package cn.edu.znufe.dhf.apisapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import cn.edu.znufe.dhf.apisapp.constant.App;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aaric on 2016/3/18.
 */
public final class RetrofitHelper {

    private Retrofit mRetrofit;
    private static RetrofitHelper mRetrofitHelper;

    private RetrofitHelper() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader(App.BAIDU_API_APIKEY_NAME, App.BAIDU_API_APIKEY_VALUE)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(App.BAIDU_API_BASE_URL)
                .client(client)
                .build();
    }

    public static RetrofitHelper getInstance() {
        if (null == mRetrofitHelper) {
            synchronized (RetrofitHelper.class) {
                if (null == mRetrofitHelper) {
                    mRetrofitHelper = new RetrofitHelper();
                }
            }
        }
        return mRetrofitHelper;
    }

    public static <T> T getInstance(final Class<T> service) {
        return getInstance().getRetrofit().create(service);
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

}
