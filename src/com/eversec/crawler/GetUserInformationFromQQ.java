package com.eversec.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by 恒安 on 2017/9/13.
 */
public class GetUserInformationFromQQ {

    /**
     * @Title: main
     * @Description: 通过QQ号码查询用户最新动态 ,只针对没设权限空间,设了权限此方法无用
     * @param @param args
     * @return void
     * @throws IOException
     * @throws MalformedURLException
//     * @throws FailingHttpStatusCodeException
     * @throws
     * @date 2016年9月27日下午5:30:46
     */
    public static void main(String[] args) throws Exception {

        //设置必要参数
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", true);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//        dcaps.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        //创建无界面浏览器对象
        PhantomJSDriver driver = new PhantomJSDriver(dcaps);

        try {
            // 让浏览器访问空间主页
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("http://xui.ptlogin2.qq.com/cgi-bin/xlogin?proxy_url=http%3A//qzs.qq.com/qzone/v6/portal/proxy.html&daid=5&&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=22&target=self&s_url=http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone&pt_qr_app=%E6%89%8B%E6%9C%BAQQ%E7%A9%BA%E9%97%B4&pt_qr_link=http%3A//z.qzone.com/download.html&self_regurl=http%3A//qzs.qq.com/qzone/v6/reg/index.html&pt_qr_help_link=http%3A//z.qzone.com/download.html");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Thread.sleep(1000L);
            WebElement pwdLoginbutton = driver.findElement(By.id("bottom_qlogin")).findElement(By.id("switcher_plogin"));
            pwdLoginbutton.click();
            //获取账号密码输入框的节点
            WebElement userNameElement = driver.findElement(By.id("u"));
            WebElement pwdElement = driver.findElement(By.id("p"));
            userNameElement.sendKeys("304033764");
            pwdElement.sendKeys("chunpangpang_l2");

            //获取登录按钮
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement loginButton = driver.findElement(By.id("login_button"));
            loginButton.click();
            //设置线程休眠时间等待页面加载完成
            Thread.sleep(1000L);
//
//            //获取新页面窗口句柄并跳转，模拟登陆完成
//            String windowHandle = driver.getWindowHandle();
//            driver.switchTo().window(windowHandle);
//
//            //设置说说详情数据页面的加载时间并跳转
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            driver.get("http://ic2.s21.qzone.qq.com/cgi-bin/feeds/feeds_html_module?i_uin=564227332&i_login_uin=2437801435&mode=4&previewV8=1&style=25&version=8&needDelOpr=true&transparence=true&hideExtend=false&showcount=5&MORE_FEEDS_CGI=http%3A%2F%2Fic2.s21.qzone.qq.com%2Fcgi-bin%2Ffeeds%2Ffeeds_html_act_all&refer=2&paramstring=os-winxp|100");

            //获取要抓取的元素,并设置等待时间,超出抛异常
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //设置设置线程休眠时间等待页面加载完成
            Thread.sleep(1000L);
            System.out.println(driver.getTitle());
//            WebElement firstTalk = driver.findElement(ByXPath.xpath(".f-info"));
            List<WebElement> elements = driver.findElementsByClassName("f-info");
//            WebElement talkTime = driver.findElement(ByXPath.xpath("/html/body/div[1]/div[1]/ul/li[1]/div[1]/div[2]/div[2]/span[1]"));
            for (WebElement webElement : elements){
                System.out.println(webElement.getText());
            }
//            String content = firstTalk.getText();
//            String time = talkTime.getText();
//            System.out.println("content="+content+"=========");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭并退出浏览器
            driver.close();
            driver.quit();
        }

    }
}
