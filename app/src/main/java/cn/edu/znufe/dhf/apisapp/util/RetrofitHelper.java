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

    private Retrofit singletonRetrofit;
    private static RetrofitHelper singletonRetrofitHelper;

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
                                .addHeader(App.BAIDU_APIKEY_NAME, App.BAIDU_APIKEY_VALUE)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        singletonRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(App.BAIDU_API_BASE_URL)
                .client(client)
                .build();
    }

    public static RetrofitHelper getInstance() {
        if (null == singletonRetrofitHelper) {
            synchronized (RetrofitHelper.class) {
                if (null == singletonRetrofitHelper) {
                    singletonRetrofitHelper = new RetrofitHelper();
                }
            }
        }
        return singletonRetrofitHelper;
    }

    public static <T> T getInstance(final Class<T> service) {
        return getInstance().getRetrofit().create(service);
    }

    public Retrofit getRetrofit() {
        return singletonRetrofit;
    }

}
