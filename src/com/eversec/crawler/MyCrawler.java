package com.eversec.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.net.Proxys;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 恒安 on 2017/5/18.
 */
public class MyCrawler extends BreadthCrawler{
    private static int count = 0;
    private static List<String> Tencents = new ArrayList<String>();
    private static List<String> youkus = new ArrayList<String >();
    private static List<String> aiqiyis = new ArrayList<String>();
    private static List<String> mangguotvs = new ArrayList<String>();
    private static List<String> sohus = new ArrayList<String >();


    public MyCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
//        电影
//        this.addSeed("http://so.tv.sohu.com/list_p1100_p2_p3_p4_p5_p6_p7_p8_p9_p10_p11_p12_p13.html");
//        电视剧
//        this.addSeed("http://so.tv.sohu.com/list_p1101_p2_p3_p4_p5_p6_p7_p8_p9_p10_p11_p12_p13.html");
//        动漫
//        this.addSeed("http://so.tv.sohu.com/list_p1115_p2_p3_p4_p5_p6_p7_p8_p9_p101_p11_p12_p13.html");
//        综艺
//        this.addSeed("http://so.tv.sohu.com/list_p1106_p2_p3_p4_p5_p6_p7_p8_p9_p10_p11_p12_p13.html");
//        娱乐
//        this.addSeed("http://so.tv.sohu.com/list_p1112_p2_p3_p4_p5_p6_p77_p8_p9_p10_p11_p12_p13.html");
//        新闻
//        this.addSeed("http://so.tv.sohu.com/list_p1122_p2_p3_p4_p5_p6_p77_p8_p9_p10_p11_p12_p13.html");
//        纪录片
//        this.addSeed("http://so.tv.sohu.com/list_p1107_p2_p3_p4_p5_p6_p7_p8_p9_p10_p11_p121_p13.html");
//        体育
//        this.addSeed("http://so.tv.sohu.com/list_p1197_p2_p3_p4_p5_p6_p77_p8_p9_p10_p11_p12_p13.html");
//        搞笑
//        this.addSeed("http://so.tv.sohu.com/list_p1133_p2_p3_p4_p5_p6_p77_p8_p9_p10_p11_p12_p13.html");
//        做饭
//        this.addSeed("http://so.tv.sohu.com/list_p1208_p2_p3_p4_p5_p6_p77_p8_p9_p10_p11_p12_p13.html");
//        游戏
//        this.addSeed("http://so.tv.sohu.com/list_p1128_p2_p3_p4_p5_p6_p7_p8_p9_p10_p11_p12_p13.html");
//        学习考试
//        this.addSeed("http://so.tv.sohu.com/list_p1210_p2_p3_p4_p5_p6_p77_p8_p9_p10_p11_p12_p13.html");
//        汽车
//        this.addSeed("http://so.tv.sohu.com/list_p1126_p2_p3_p4_p5_p6_p7_p8_p9_p10_p11_p12_p13.html");
//        科技
//        this.addSeed("http://so.tv.sohu.com/list_p1127_p2_p3_p4_p5_p6_p7_p8_p9_p10_p11_p12_p13.html");
//        自媒体
//        this.addSeed("https://www.yidianzixun.com/home/q/news_list_for_channel?channel_id=13646059229&cstart=0&cend=10&infinite=true&refresh=1&__from__=pc&multi=5&appid=yidian&_=1496905724405");
//        for(int i=2;i<201;i++){
////            this.addSeed("http://so.tv.sohu.com/list_p1100_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1101_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1115_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1106_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1112_p2_p3_p4_p5_p6_p77_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1122_p2_p3_p4_p5_p6_p77_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1107_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p121_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1197_p2_p3_p4_p5_p6_p77_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1133_p2_p3_p4_p5_p6_p77_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1208_p2_p3_p4_p5_p6_p77_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1128_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1210_p2_p3_p4_p5_p6_p77_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1126_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p12_p13.html");
////            this.addSeed("http://so.tv.sohu.com/list_p1127_p2_p3_p4_p5_p6_p7_p8_p9_p10"+i+"_p11_p12_p13.html");
//            this.addSeed("http://so.tv.sohu.com/list_p11001_p2_p3_p4_p5_p6_p77_p8_p9_p10"+i+"_p11_p12_p13.html");
//            this.addRegex("-.*\\.(jpg|png|gif).*");
//            /*do not fetch url contains #*/
//            this.addRegex("-.*#.*");
//        }
        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
//        this.addRegex("http://news.hfut.edu.cn/show-.*html");
        /*do not fetch jpg|png|gif*/


//        //安卓市场
//        //影音
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/MediaAndVideo?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/DailyLife?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Social?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Finance?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Tools?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/TravelAndLocal?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Communication?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Shopping?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Reading?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Education?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/NewsAndMagazines?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/HealthAndFitness?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/AntiVirus?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Browser?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Productivity?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Personalization?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Input?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/apps/Photography?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/OnlineGames?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Casual?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/RolePlaying?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/BrainAndPuzzle?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Shooting?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Sports?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Children?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Chess?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Strategy?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Simulation?sort=5&pi="+i);
//        }
//        for (int i=1;i<51;i++){
//            this.addSeed("http://apk.hiapk.com/games/Racing?sort=5&pi="+i);
//        }
//        //小米应用商店
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/5#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=5&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/27#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=27&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/2#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=2&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/7#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=7&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/12#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=12&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/10#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=10&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/9#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=9&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/4#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=4&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/3#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=3&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/6#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=6&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/14#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=14&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/8#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=8&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/11#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=11&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/13#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=13&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/1#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=1&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/16#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=16&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/17#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=17&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/18#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=18&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/19#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=19&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/20#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=20&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/21#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=21&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/22#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=22&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/23#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=23&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/25#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=25&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/26#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=26&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/28#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=28&pageSize=30");
//        }
//        for (int i=0;i<70;i++){
////            this.addSeed("http://app.mi.com/category/29#page="+i);
//            this.addSeed("http://app.mi.com/categotyAllListApi?page="+i+"&categoryId=29&pageSize=30");
//        }
        CrawlDatum tencentAll = new CrawlDatum("https://v.qq.com/x/hotlist/search/?channel=0").
                meta("kind","腾讯总榜单");
        addSeed(tencentAll);
        CrawlDatum tencentdsj = new CrawlDatum("https://v.qq.com/x/hotlist/search/?channel=2").
                meta("kind","腾讯电视剧");
        addSeed(tencentdsj);
        CrawlDatum tencentzy = new CrawlDatum("https://v.qq.com/x/hotlist/search/?channel=10").
                meta("kind","腾讯综艺");
        addSeed(tencentzy);
        CrawlDatum tencentdm = new CrawlDatum("https://v.qq.com/x/hotlist/search/?channel=3").
                meta("kind","腾讯动漫");
        addSeed(tencentdm);
        CrawlDatum tencentdy = new CrawlDatum("https://v.qq.com/x/hotlist/search/?channel=1").
                meta("kind","腾讯电影");
        addSeed(tencentdy);
        CrawlDatum tencentjlp = new CrawlDatum("https://v.qq.com/x/hotlist/search/?channel=9").
                meta("kind","腾讯纪录片");
        addSeed(tencentjlp);
        CrawlDatum tencentyl = new CrawlDatum("https://v.qq.com/x/hotlist/search/?channel=5").
                meta("kind","腾讯娱乐");
        addSeed(tencentyl);
        CrawlDatum dsj = new CrawlDatum("http://index.api.youku.com/getData?num=700009&orderPro=vv&startindex=1&endindex=30&channelId=97&dateDim=d&jsoncallback=jQuery111207403951853484465_1501064225659&jsonp&_=1501064225660&visitDstTime=1")
                .putMetaData("kind", "电视剧优酷");
        addSeed(dsj);
        CrawlDatum dy = new CrawlDatum("http://index.api.youku.com/getData?num=700009&orderPro=vv&startindex=1&endindex=30&channelId=96&dateDim=d&jsoncallback=jQuery111200038587360988484587_1501064439274&jsonp&_=1501064439277&visitDstTime=1")
                .putMetaData("kind","电影优酷");
        addSeed(dy);
        CrawlDatum zy = new CrawlDatum("http://index.api.youku.com/getData?num=700009&orderPro=vv&startindex=1&endindex=30&channelId=85&dateDim=d&jsoncallback=jQuery111209003357551638695_1501065015986&jsonp&_=1501065015987&visitDstTime=1")
                .putMetaData("kind","综艺优酷");
        addSeed(zy);
        CrawlDatum dm = new CrawlDatum("http://index.api.youku.com/getData?num=700009&orderPro=vv&startindex=1&endindex=30&channelId=100&dateDim=d&jsoncallback=jQuery111206688181570553708_1501065141095&jsonp&_=1501065141096&visitDstTime=1")
                .putMetaData("kind","动漫优酷");
        addSeed(dm);
        CrawlDatum yy = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=95&dateDim=d&jsoncallback=jQuery111206331053388661287_1501065224481&jsonp&_=1501065224482&visitDstTime=1")
                .putMetaData("kind","音乐优酷");
        addSeed(yy);
        CrawlDatum yx = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=99&dateDim=d&jsoncallback=jQuery111207310769832017743_1501065295631&jsonp&_=1501065295632&visitDstTime=1")
                .putMetaData("kind","游戏优酷");
        addSeed(yx);
        CrawlDatum zx = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=91&dateDim=d&jsoncallback=jQuery1112008891071080465096_1501065349618&jsonp&_=1501065349619&visitDstTime=1")
                .putMetaData("kind","资讯优酷");
        addSeed(zx);
        CrawlDatum qc = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=104&dateDim=d&jsoncallback=jQuery1112047875318224780705_1501065385898&jsonp&_=1501065385899&visitDstTime=1")
                .putMetaData("kind","汽车优酷");
        addSeed(qc);
        CrawlDatum jy = new CrawlDatum("http://index.api.youku.com/getData?num=700009&orderPro=vv&startindex=1&endindex=30&channelId=87&dateDim=d&jsoncallback=jQuery1112007186287772268041_1501065422563&jsonp&_=1501065422564&visitDstTime=1")
                .putMetaData("kind","教育优酷");
        addSeed(jy);
        CrawlDatum js = new CrawlDatum("http://index.api.youku.com/getData?num=700009&orderPro=vv&startindex=1&endindex=30&channelId=84&dateDim=d&jsoncallback=jQuery111201628102208763742_1501065531007&jsonp&_=1501065531008&visitDstTime=1")
                .putMetaData("kind","纪实优酷");
        addSeed(js);
        CrawlDatum yl = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=86&dateDim=d&jsoncallback=jQuery111205792189437623385_1501065613755&jsonp&_=1501065613756&visitDstTime=1")
                .putMetaData("kind","娱乐优酷");
        addSeed(yl);
        CrawlDatum ty = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=98&dateDim=d&jsoncallback=jQuery111206081609943689277_1501065659700&jsonp&_=1501065659701&visitDstTime=1")
                .putMetaData("kind","体育优酷");
        addSeed(ty);
        CrawlDatum kj = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=105&dateDim=d&jsoncallback=jQuery111201412636561050915_1501065695134&jsonp&_=1501065695135&visitDstTime=1")
                .putMetaData("kind","科技优酷");
        addSeed(kj);
        CrawlDatum gx = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=94&dateDim=d&jsoncallback=jQuery11120038653764293618664_1501065734185&jsonp&_=1501065734186&visitDstTime=1")
                .putMetaData("kind","搞笑优酷");
        addSeed(gx);
        CrawlDatum sh = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=103&dateDim=d&jsoncallback=jQuery111205979413389693207_1501065768537&jsonp&_=1501065768538&visitDstTime=1")
                .putMetaData("kind","生活优酷");
        addSeed(sh);
        CrawlDatum zp = new CrawlDatum("http://index.api.youku.com/getData?num=700008&orderPro=vv&startindex=1&endindex=30&channelId=176&dateDim=d&jsoncallback=jQuery111204697906028800616_1501065863472&jsonp&_=1501065863473&visitDstTime=1")
                .putMetaData("kind","自拍优酷");
        addSeed(zp);
        CrawlDatum iqiyirbb = new CrawlDatum("http://top.iqiyi.com/rebobang.html")
                .putMetaData("kind","爱奇艺热播榜");
        addSeed(iqiyirbb);
        CrawlDatum iqiyidy = new CrawlDatum("http://top.iqiyi.com/dianying.html")
                .putMetaData("kind","爱奇艺电影");
        addSeed(iqiyidy);
        CrawlDatum iqiyidsj = new CrawlDatum("http://top.iqiyi.com/dianshiju.html")
                .putMetaData("kind","爱奇艺电视剧");
        addSeed(iqiyidsj);
        CrawlDatum iqiyidm = new CrawlDatum("http://top.iqiyi.com/dongman.html")
                .putMetaData("kind","爱奇艺动漫");
        addSeed(iqiyidm);
        CrawlDatum iqiyizy = new CrawlDatum("http://top.iqiyi.com/zongyi.html")
                .putMetaData("kind","爱奇艺综艺");
        addSeed(iqiyizy);
        CrawlDatum iqiyiet = new CrawlDatum("http://top.iqiyi.com/shaoer.html")
                .putMetaData("kind","爱奇艺儿童");
        addSeed(iqiyiet);
        CrawlDatum iqiyigx = new CrawlDatum("http://top.iqiyi.com/gaoxiao.html")
                .putMetaData("kind","爱奇艺搞笑");
        addSeed(iqiyigx);
        CrawlDatum iqiyijs = new CrawlDatum("http://top.iqiyi.com/junshi.html")
                .putMetaData("kind","爱奇艺军事");
        addSeed(iqiyijs);
        CrawlDatum iqiyijlp = new CrawlDatum("http://top.iqiyi.com/jilupian.html")
                .putMetaData("kind","爱奇艺纪录片");
        addSeed(iqiyijlp);
        CrawlDatum iqiyiyl = new CrawlDatum("http://top.iqiyi.com/yule.html")
                .putMetaData("kind","爱奇艺娱乐");
        addSeed(iqiyiyl);
        CrawlDatum mgtvzy = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=1&t=day&limit=30&rt=c&t=1502097208048&callback=jQuery18208530760372876649_1502097207933&_=1502097208049")
                .putMetaData("kind","芒果TV综艺");
        addSeed(mgtvzy);
        CrawlDatum mgtvdsj = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=2&t=day&limit=30&rt=c&t=1501835518343&callback=jQuery182009483263135430708_1501835518238&_=1501835518343")
                .putMetaData("kind","芒果TV电视剧");
        addSeed(mgtvdsj);
        CrawlDatum mgtvdy = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=3&t=day&limit=30&rt=c&t=1501835766364&callback=jQuery18208743767568441683_1501835766265&_=1501835766366")
                .putMetaData("kind","芒果TV电影");
        addSeed(mgtvdy);
        CrawlDatum mgtvdm = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=50&t=day&limit=30&rt=c&t=1501835834592&callback=jQuery18205551213368419006_1501835834424&_=1501835834593")
                .putMetaData("kind","芒果TV动漫");
        addSeed(mgtvdm);
        CrawlDatum mgtvxw = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=106&t=day&limit=30&rt=c&t=1501835886564&callback=jQuery182034266914745141386_1501835886475&_=1501835886568%20Request%20Method:GET")
                .putMetaData("kind","芒果TV新闻");
        addSeed(mgtvxw);
        CrawlDatum mgtvjlp = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=51&t=day&limit=30&rt=c&t=1501836053024&callback=jQuery18207100292858863786_1501836052919&_=1501836053025")
                .putMetaData("kind","芒果TV纪录片");
        addSeed(mgtvjlp);
        CrawlDatum mgtvsh = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=105&t=day&limit=30&rt=v&t=1501836123903&callback=jQuery18201889652239126578_1501836123676&_=1501836123904")
                .putMetaData("kind","芒果TV生活");
        addSeed(mgtvsh);
        CrawlDatum mgtvyc = new CrawlDatum("http://rc.mgtv.com/pc/ranklist?&c=111&t=day&limit=30&rt=v&t=1501836165106&callback=jQuery182008426260379073125_1501836164919&_=1501836165107")
                .putMetaData("kind","芒果TV原创");
        addSeed(mgtvyc);
        CrawlDatum sohudsj = new CrawlDatum("http://tv.sohu.com/hotdrama/")
                .putMetaData("kind","搜狐电视剧");
        addSeed(sohudsj);
        CrawlDatum sohudy = new CrawlDatum("http://tv.sohu.com/hotmovie/")
                .putMetaData("kind","搜狐电影");
        addSeed(sohudy);
        CrawlDatum sohuzy = new CrawlDatum("http://tv.sohu.com/hotshow/")
                .putMetaData("kind","搜狐综艺");
        addSeed(sohuzy);
        CrawlDatum sohudm = new CrawlDatum("http://tv.sohu.com/hotcomic/")
                .putMetaData("kind","搜狐动漫");
        addSeed(sohudm);
        CrawlDatum sohuty = new CrawlDatum("http://tv.sohu.com/hotsport/")
                .putMetaData("kind","搜狐体育");
        addSeed(sohuty);
        CrawlDatum sohuzmt = new CrawlDatum("http://tv.sohu.com/hotugc/")
                .putMetaData("kind","搜狐自媒体");
        addSeed(sohuzmt);
        CrawlDatum sohuxw = new CrawlDatum("http://tv.sohu.com/hotnews/")
                .putMetaData("kind","搜狐新闻");
        addSeed(sohuxw);
        CrawlDatum sohuyl = new CrawlDatum("http://tv.sohu.com/hotyule/")
                .putMetaData("kind","搜狐娱乐");
        addSeed(sohuyl);
        CrawlDatum sohujlp = new CrawlDatum("http://tv.sohu.com/hotdocumentary/")
                .putMetaData("kind","搜狐纪录片");
        addSeed(sohujlp);
        CrawlDatum sohuyy = new CrawlDatum("http://tv.sohu.com/hotmusic/")
                .putMetaData("kind","搜狐音乐");
        addSeed(sohuyy);
        CrawlDatum sohujy = new CrawlDatum("http://tv.sohu.com/hotedu/")
                .putMetaData("kind","搜狐教育");
        addSeed(sohujy);
//        CrawlDatum sohudsj = new CrawlDatum("http://tv.sohu.com/hotdrama/")
//                .putMetaData("kind","搜狐电视剧");
//        addSeed(sohudsj);
//        CrawlDatum sohudsj = new CrawlDatum("http://tv.sohu.com/hotdrama/")
//                .putMetaData("kind","搜狐电视剧");
//        addSeed(sohudsj);
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
//        用于对电影排行的爬取
//        Elements links = page.getDoc().select("ul.st-list li");
//        System.out.println("url:"+url);
//        for(Element element : links){
//            if(element.select("div.st-pic")!=null){
//                String link = element.select("div.st-pic a").first().attr("href").split("\\?")[0];
//                String idd = link.split("/")[link.split("/").length-1];
//                String id = idd.split("\\.")[0];
//                String time = "";
//                if(element.select("span.maskTx")!=null){
//                    time = element.select("span.maskTx").text();
//                }
//                String title = element.select("h3 a").text();
//                Element hover = element.select("div.list-hover").first();
//                Elements locations = hover.select("p.lh-area a");
//                Elements filmTypes = hover.select("p.lh-type a");
//                Elements mainPerformers = hover.select("p.lh-zy a");
//                String filmType = "";
//                String mainPerformer = "";
//                String location = "";
//                for(Element element1 : locations){
//                    location = location + "," +element1.text();
//                }
//                for(Element element1 : filmTypes){
//                    filmType = filmType + "," +element1.text();
//                }
//                for(Element element1 : mainPerformers){
//                    mainPerformer = mainPerformer + "," +element1.text();
//                }
//                String info = hover.select("p.lh-info").first().text();
//                String hits = hover.select("div.lh-mor a").first().text();
//                if (filmType.length()>1){
//                    filmType = filmType.substring(1);
//                }
//                if (location.length()>1){
//                    location = location.substring(1);
//                }
//                if (mainPerformer.length()>1){
//                    mainPerformer = mainPerformer.substring(1);
//                }
//                list.add(id+"|首页|综艺|"+filmType+"|"+location+"|"+time+"|"+title
//                        +"|"+hits+"|"+mainPerformer+"|"+info);
//            }
//        }

//        System.out.println(page.getUrl());
//        System.out.println(page.getHtml());
////      娱乐新闻等
//        if (page.getMetaData("depth")!=null){
//            String link = page.getUrl().split("\\?")[0];
//            String idd = link.split("/")[link.split("/").length-1];
//            String id = idd.split("\\.")[0];
//            String type = "";
//            String title = "";
//            String time = "";
//            String label = "";
//            String year = "";
//            String intro = "";
//            try {
//
//                if(page.getDoc().select("div.crumbs a")!=null){
//                    type = page.getDoc().select("div.crumbs a").text();
//                }
//                if (page.getDoc().select("title")!=null){
//                    title = page.getDoc().select("title").text();
//                    title = title.substring(0,title.length()-6);
//                }
//                if(page.getDoc().select("li#vtags a")!=null){
//                    label = page.getDoc().select("li#vtags a").text();
//                }
////                if (page.getDoc().select("li.s").select("li.h")!=null){
////                    year = page.getDoc().select("li.s").select("li.h").first().text();
////                }
////                if (page.getDoc().select("li.s")!=null){
////                    time = page.getDoc().select("li.s").first().text();
////                }
//                if (page.getDoc().select("p.intro")!=null){
//                    intro = page.getDoc().select("p.intro").text();
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            list.add(id+"|首页|自媒体|"+type+"|"+title+"|"+time+"|"+page.getMetaData("depth")+"|"+label+"|"+year+"|"+intro);
//        }else {
//            Elements links = page.getDoc().select("ul.st-list li");
//            for(Element element : links){
//                if(element.select("div.st-pic")!=null){
//                    String link = "http:"+element.select("div.st-pic a").first().attr("href");
//                    String hits = element.select("a.bcout").text();
//                    String time = "";
//                    if(element.select("span.maskTx")!=null){
//                        time = element.select("span.maskTx").text();
//                    }
//                    String date = "";
//                    if(element.select("a.bcout")!=null){
//                        date = element.select("a.bcount").text();
//                    }
//                    crawlDatums.add(link).putMetaData("depth",time+"|"+hits+"|"+date);
//                }
//            }
//        }


//        腾讯视频
        if (page.getMetaData("kind") != null && page.getMetaData("kind").contains("腾讯")){
            Elements els = page.select("a.name");
            Tencents.add(page.getMetaData("kind")+"----------------\n");
            for (Element el : els){
//                System.out.println(el.text());
                Tencents.add(el.text()+"\n");
            }
            Tencents.add("\n\n");
        }

//        优酷视频
        if (page.getMetaData("kind") != null && page.getMetaData("kind").contains("优酷")){
            String newspage = page.getHtml().substring(page.getHtml().indexOf("(")+1,page.getHtml().lastIndexOf(")"));
            JSONObject jsonObject = JSONObject.fromObject(newspage);
            JSONObject result = jsonObject.getJSONObject("result");
            JSONArray data = result.getJSONArray("data");
            youkus.add(page.getMetaData("kind")+"---------------\n");
            for (int i=0;i<data.size();i++){
                JSONObject jsonObject1 = data.getJSONObject(i);
                String title = jsonObject1.getString("title");
                youkus.add(title+"\n");
            }
            youkus.add("\n\n");
        }

//        爱奇艺
        if (page.getMetaData("kind") != null && page.getMetaData("kind").contains("爱奇艺")){
            Elements els = page.select("h2");
            aiqiyis.add(page.getMetaData("kind")+"----------------\n");
            for (int i=1;i<els.size();i++){
                aiqiyis.add(els.get(i).text()+"\n");
            }
            aiqiyis.add("\n\n");
        }

//        芒果TV视频
        if (page.getMetaData("kind") != null && page.getMetaData("kind").contains("芒果TV")){
            String newspage = page.getHtml().substring(page.getHtml().indexOf("(")+1,page.getHtml().lastIndexOf(")"));
            JSONObject jsonObject = JSONObject.fromObject(newspage);
            JSONArray data = jsonObject.getJSONArray("data");
            mangguotvs.add(page.getMetaData("kind")+"---------------\n");
            for (int i=0;i<data.size();i++){
                JSONObject jsonObject1 = data.getJSONObject(i);
                String title = jsonObject1.getString("name");
                mangguotvs.add(title+"\n");
            }
            mangguotvs.add("\n\n");
        }

//        搜狐视频
        if (page.getMetaData("kind") != null && page.getMetaData("kind").contains("搜狐")){
            Elements els = page.select("div.rList_subCon").get(0).getElementsByClass("at");
            sohus.add(page.getMetaData("kind")+"----------------\n");
            for (int i=0;i<els.size();i++){
                sohus.add(els.get(i).text()+"\n");
            }
            sohus.add("\n\n");
        }
//        原版内容
//        Document doc = Jsoup.parse(page.getHtml());
//        page.
//        if (page.matchUrl("http://news.hfut.edu.cn/show-.*html")) {
//            /*we use jsoup to parse page*/
//            Document doc = page.getDoc();
//
//             /*extract title and content of news by css selector*/
//            String title = page.select("div[id=Article]>h2").first().text();
//            String content = page.select("div#artibody", 0).text();
//
//            System.out.println("URL:\n" + url);
//            System.out.println("title:\n" + title);
//            System.out.println("content:\n" + content);
//
//            /*If you want to add urls to crawl,add them to nextLink*/
//            /*WebCollector automatically filters links that have been fetched before*/
//            /*If au优酷arse is true and the link you add to nextLinks does not
//            match the regex rules,the link will also been filtered.*/
//            //next.add("http://xxxxxx.com");
//        }
//        System.out.println(page.getHtml());
//        JSONObject jsonObject = JSONObject.fromObject(page.getHtml());
//        JSONArray jsonArray = jsonObject.getJSONArray("data");
//        if (jsonArray.size()>0){
//            for (int i=0;i<jsonArray.size();i++){
//                String name = jsonArray.getJSONObject(i).getString("displayName");
////                System.out.println(name);
//                if (!list.contains(name)){
//                    list.add(name);
//                }
//            }
//        }
    }

    //设置http请求参数,主要用于设置超时时间
    @Override
    public HttpResponse getResponse(CrawlDatum crawlDatum) throws Exception{
        HttpRequest httpRequest = new HttpRequest(crawlDatum.getUrl());
        httpRequest.setTimeoutForConnect(20000);
        httpRequest.setCookie("ASP.NET_SessionId=4pwj0jzbeitiqbms2eqpzxg5; UM_distinctid=15da0c1ccb431b-03aa961e85aaed-36624308-15f900-15da0c1ccb583c; CNZZDATA1261062804=1992805479-1501635768-%7C1501641174");
        return httpRequest.getResponse();
    }

    public static void main(String[] args){
        MyCrawler crawler = new MyCrawler("crawl", true);
        crawler.setThreads(10);
        crawler.setMaxExecuteCount(3);
        crawler.setExecuteInterval(500);
//        每次迭代爬取的上限
//        crawler.set优酷N(100);
        //是否断点爬取
//        crawler.setResumable(true);
        /*start crawl with depth of 4*/
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String time = simpleDateFormat.format(date);
//        String path = "/home/tyx/"+time+"/";
        String path = "D:\\工作\\江西\\排行榜\\"+time+"\\";
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        try {
            crawler.start(1);
            BufferedWriter tencentbw = new BufferedWriter(new FileWriter(path+"腾讯"+time+".txt"));
            for(int i=0;i<Tencents.size();i++){
                tencentbw.write(Tencents.get(i));
            }
            tencentbw.close();
            BufferedWriter youkubw = new BufferedWriter(new FileWriter(path+"优酷"+time+".txt"));
            for(int i=0;i<youkus.size();i++){
                youkubw.write(youkus.get(i));
            }
            youkubw.close();
            BufferedWriter iqiyibw = new BufferedWriter(new FileWriter(path+"爱奇艺"+time+".txt"));
            for(int i=0;i<aiqiyis.size();i++){
                iqiyibw.write(aiqiyis.get(i));
            }
            iqiyibw.close();
            BufferedWriter mangguobw = new BufferedWriter(new FileWriter(path+"芒果TV"+time+".txt"));
            for(int i=0;i<mangguotvs.size();i++){
                mangguobw.write(mangguotvs.get(i));
            }
            mangguobw.close();
            BufferedWriter sohubw = new BufferedWriter(new FileWriter(path+"搜狐视频"+time+".txt"));
            for(int i=0;i<sohus.size();i++){
                sohubw.write(sohus.get(i));
            }
            sohubw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
