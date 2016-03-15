package cn.edu.znufe.dhf.apisapp;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import cn.edu.znufe.dhf.apisapp.model.NewsMapObject;
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
     * 构造函数
     */
    public ApplicationTest() {
        super(Application.class);
    }

    /**
     * 测试网络工具GET请求功能
     *
     * @throws Exception
     */
    public void testGetForString() throws Exception {
        Log.e(TAG, "result----->" + NetworkUtils.getForString("http://apis.baidu.com/txapi/social/social?num=10&page=1"));
    }

    /**
     * 测试网络工具GET请求功能
     *
     * @throws Exception
     */
    public void testGetForObject() throws Exception {
        NewsMapObject resultObject = NetworkUtils.getForObject("http://apis.baidu.com/txapi/social/social?num=10&page=1", NewsMapObject.class);
        Log.e(TAG, "object----->" + resultObject);
        if(null != resultObject) {
            Log.e(TAG, "msg----->" + resultObject.getMsg());
            Log.e(TAG, "code----->" + resultObject.getCode());
            Log.e(TAG, "size----->" + resultObject.getNewslist().size());
        }

    }

}