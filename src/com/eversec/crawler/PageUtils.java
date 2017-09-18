package com.eversec.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by tyx on 2017/9/12.
 */
public class PageUtils {

    /**
     * 获取webcollector 自带 htmlUnitDriver实例(模拟默认浏览器)
     *
     * @param page
     * @return
     */
    public static HtmlUnitDriver getDriver(Page page) {
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        driver.get(page.getUrl());
        return driver;
    }

    /**
     * 获取webcollector 自带htmlUnitDriver实例
     *
     * @param page
     * @param browserVersion 模拟浏览器
     * @return
     */
    public static HtmlUnitDriver getDriver(Page page, BrowserVersion browserVersion) {
        HtmlUnitDriver driver = new HtmlUnitDriver(browserVersion);
        driver.setJavascriptEnabled(true);
        driver.get(page.getUrl());
        return driver;
    }

    public static WebDriver getWebDriver(Page page) {
        System.setProperty("phantomjs,binary,path", "D:\\Python3.6\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get(page.getUrl());
        return driver;
    }

    public static String getPhantomJSDrivwe(Page page) {
        Runtime rt = Runtime.getRuntime();
        Process process = null;
        try {
            process = rt.exec("D:\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe" +
                    "D:\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\parser.js" +
                    page.getUrl().trim());
            InputStream in = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "utf-8");
            BufferedReader br = new BufferedReader(reader);
            StringBuffer sb = new StringBuffer();
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                sb.append(tmp);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}