package com.eversec.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tyx on 2017/9/14.
 * 通过selenium+phantomJS登录博客园
 */
public class CnblogLogin {
    public static void main(String[] args) throws Exception{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //ssl证书支持
        desiredCapabilities.setCapability("acceptSslCerts", true);
        //截屏支持
        desiredCapabilities.setCapability("takesScreenshot", true);
        //css搜索支持
        desiredCapabilities.setCapability("cssSelectorsEnabled", true);
        //js支持
        desiredCapabilities.setJavascriptEnabled(true);
        //驱动支持
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        //创建无界面浏览器对象

        WebDriver webDriver = new PhantomJSDriver(desiredCapabilities);
        try {
            webDriver.get("https://passport.cnblogs.com/user/signin?ReturnUrl=https%3A%2F%2Fwww.cnblogs.com%2F");
            WebElement usernameEle = webDriver.findElement(By.id("input1"));
            WebElement passwordEle = webDriver.findElement(By.id("input2"));
            usernameEle.sendKeys("liuxiaopang");
            passwordEle.sendKeys("dao_nimab2");
            WebElement loginButtom = webDriver.findElement(By.id("signin"));
            loginButtom.click();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<WebElement> elements = webDriver.findElements(By.xpath("//a[@class='titlelnk']"));
            for (WebElement element : elements){
                System.out.println(element.getText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            webDriver.close();
            webDriver.quit();
        }
    }
}
