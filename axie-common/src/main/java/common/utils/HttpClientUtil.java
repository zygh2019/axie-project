package common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 利用HttpClient进行post请求的工具类
 *
 * @author Devin <xxx>
 * @ClassName: HttpClientUtil
 * @Description: TODO
 * @date 2017年2月7日 下午1:43:38
 */
public class HttpClientUtil {
    public static final String CHARSET = "UTF-8";


    @SuppressWarnings("resource")
    public static String doPost(String url, Map<String, String> map) {

        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            //httpPost.addHeader("token", LoginAxieUtil.TOKEN);
            List<NameValuePair> params = new ArrayList<>();
            map.forEach((key, val) -> {
                BasicNameValuePair account = new BasicNameValuePair(key, val);
                params.add(account);
            });
            UrlEncodedFormEntity e = new UrlEncodedFormEntity(params, CHARSET);
            httpPost.setEntity(e);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, CHARSET);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    /**
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String doGet(String url, Map<String, Object> params) {
        String result = null;
        try {
            if (params != null && !params.isEmpty()) {

                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());

                for (String key : params.keySet()) {
                    pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs), CHARSET);
            }

            CloseableHttpClient httpclient = HttpClients.createDefault();
            RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(3000).build();
            httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
                response.close();
                return result;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}