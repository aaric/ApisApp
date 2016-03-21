package cn.edu.znufe.dhf.apisapp.constant;

/**
 * Created by aigo on 2016/3/16.
 */
public final class App {

    /**
     * Baidu
     */
    public static final String BAIDU_API_BASE_URL = "http://apis.baidu.com";
    public static final String BAIDU_API_APIKEY_NAME = "apikey";
    public static final String BAIDU_API_APIKEY_VALUE = "35035c1095f3bc7f16926dfb30db92f7";

    /**
     * News
     */
    public static final String SUFFIX_URL_NEWS = "/txapi/social/social";
    public static final String TEST_URL_NEWS = "/txapi/social/social?num=10&page=1";

    /**
     * Healthy
     */
    public static final String SUFFIX_URL_HEALTHY = "/tngou/info/list";
    public static final String TEST_URL_HEALTHY = "/tngou/info/list?id=0&page=1&rows=10";
    public static final String SUFFIX_URL_HEALTHY_DETAILS = "/tngou/info/show";
    public static final String TEST_URL_HEALTHY_DETAILS = "/tngou/info/show?id=6426";

    /**
     * Travels
     */
    public static final String SUFFIX_URL_TRAVELS = "/qunartravel/travellist/travellist";
    public static final String TEST_URL_TRAVELS = "/qunartravel/travellist/travellist?query=&page=1";

}
