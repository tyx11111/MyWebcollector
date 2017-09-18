package com.eversec.crawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by 恒安 on 2017/5/31.
 */
public class CrawlerJs {
    public static void main(String args[]) throws IOException {
        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true
        webClient.getOptions().setCssEnabled(false); //禁用css支持
        webClient.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常
        webClient.getOptions().setTimeout(20000);
        HtmlPage page = webClient.getPage("http://www.yidianzixun.com/");
//我认为这个最重要
        String pageXml = page.asXml(); //以xml的形式获取响应文本

        System.out.println("-------------------------------------------------");
        System.out.println(pageXml);
        /**jsoup解析文档*/
//        Document doc = Jsoup.parse(pageXml, "http://cq.qq.com");
    }
}
