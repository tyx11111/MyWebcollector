package com.eversec.crawler;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tyx on 2017/8/2.
 */
public class HttpClient {
    public static String httpPostWithJSON(String url) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = "";
        //        表单方式
        Map<String,List<NameValuePair>> map = new HashMap<>();
//        NameValuePair一般用于Java向Http发送post请求
        for (int i=1;i<=5;i++){
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("__VIEWSTATE","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"));
            nvps.add(new BasicNameValuePair("__EVENTTARGET","ctl00$ContentPlaceHolder1$AspNetPager1"));
            nvps.add(new BasicNameValuePair("__EVENTARGUMENT",i+""));
            map.put(i+"",nvps);
        }
        //向对方服务器发送Post请求
        try {
            //将参数进行封装，提交到服务器端
            for (String key : map.keySet()){
                httpPost.setEntity(new UrlEncodedFormEntity(map.get(key),"UTF8"));
                CloseableHttpResponse httpResponse = client.execute(httpPost);
//                200为成功访问的返回值
                if(httpResponse.getStatusLine().getStatusCode() == 200) {
                    Document doc = Jsoup.parse(EntityUtils.toString(httpResponse.getEntity()));
                    Elements elements = doc.select("table.data-list").select("a");
                    for (Element element : elements){
                        System.out.println(element.text());
                    }
//                    Header[] headers = httpResponse.getAllHeaders();
//                    for (Header header : headers) {
//                        System.out.println(header.getName() + ": " + header.getValue());
//                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpPost.abort();      //释放资源
        }
        return respContent;
    }


    public static void main(String[] args) throws Exception {
        String result = httpPostWithJSON("http://113.108.219.40/Dop/Open/EnterpriseList.aspx");
        System.out.println(result);
    }
}
