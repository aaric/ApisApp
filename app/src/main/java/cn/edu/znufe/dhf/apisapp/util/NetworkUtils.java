package cn.edu.znufe.dhf.apisapp.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import cn.edu.znufe.dhf.apisapp.constant.App;

/**
 * Created by Aaric on 2016/3/15.
 */
public class NetworkUtils {

    /**
     * 获得自定义请求头信息对象
     *
     * @param mediaType 内容类型
     * @return
     * @throws Exception
     */
    private static HttpHeaders getHttpHeaders(MediaType mediaType) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(App.BAIDU_APIKEY_NAME, App.BAIDU_APIKEY_VALUE);
        httpHeaders.setContentType(mediaType);
        return httpHeaders;
    }

    /**
     * 获得GET请求字符串
     *
     * @param requestUrl 请求地址
     * @return
     * @throws Exception
     */
    public static String getForString(String requestUrl) throws Exception {
        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Add the String message converter
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        // Make the HTTP GET request, marshaling the response to a String
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, new HttpEntity<String>(getHttpHeaders(MediaType.TEXT_PLAIN)), String.class);

        return responseEntity.getBody();
    }

    /**
     * 获得GET请求对象
     *
     * @param requestUrl 请求地址
     * @param responseType 响应对象类型
     * @return
     * @throws Exception
     */
    public static <T> T getForObject(String requestUrl, Class<T> responseType) throws Exception {
        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Add the String json converter
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        // Make the HTTP GET request, marshaling the response to a object
        ResponseEntity<T> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, new HttpEntity<String>(getHttpHeaders(MediaType.TEXT_PLAIN)), responseType);

        return responseEntity.getBody();
    }

}
