package com.eversec.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 恒安 on 2017/8/7.
 */
public class PhoneInfoCrawler extends BreadthCrawler{

    private static List<String> ZOLList = new ArrayList<>();
    private static List<String> CNMOList = new ArrayList<>();

    public PhoneInfoCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
//        中关村在线
        for (int i=1;i<105;i++){
            CrawlDatum crawlDatum = new CrawlDatum("http://detail.zol.com.cn/cell_phone_index/subcate57_0_list_1_0_1_2_0_"+i+".html")
                    .meta("kind","ZOL中关村在线列表");
            addSeed(crawlDatum);
        }
//        手机中国
        for (int i=1;i<166;i++){
            CrawlDatum crawlDatum = new CrawlDatum("http://product.cnmo.com/all/product_t1_p"+i+".html")
                    .meta("kind","手机中国列表");
            addSeed(crawlDatum);
        }
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        if (page.getMetaData("kind").contains("ZOL中关村在线列表")){
            Elements els = page.select("ul#J_PicMode").get(0).select("li");
            for (Element el:els){
//                System.out.println(el.select("a.comment-num").attr("href").replaceAll("review","param"));
                String price = el.select("span.price-normal").select("b").text();
                CrawlDatum crawlDatum = new CrawlDatum("http://detail.zol.com.cn"+el.select("a.comment-num").attr("href").replaceAll("review","param"))
                        .meta("kind","ZOL中关村在线参数").meta("price",price);
                crawlDatums.add(crawlDatum);
            }
        } else if (page.getMetaData("kind").contains("ZOL中关村在线参数")){
//            System.out.print(page.getUrl()+"|");
            String name = page.select("h1").text();
//            所有详细列表，因格式不统一暂时放弃
//            Document doc = Jsoup.parse(page.getHtml().replace("<textarea hidden>","").replaceAll("</textarea>",""));
//            String size = doc.select("div#MP-screen").get(0).getElementsByClass("current-parameter").get(0).getElementsByTag("em").text();
//            String ppi = doc.select("div#MP-PPI").get(0).select(".current-parameter").get(0).getElementsByTag("em").text();
//            String battery = doc.select("div#MP-battery").get(0).getElementsByClass("current-parameter").get(0).getElementsByTag("em").text();
//            String camera = doc.select("div#MP-camera").get(0).getElementsByClass("current-parameter").get(0).getElementsByTag("em").text();
//            String ram = doc.select("div#MP-romram").get(0).getElementsByClass("current-parameter").get(0).getElementsByTag("em").get(0).text();
//            String rom = doc.select("div#MP-romram").get(0).getElementsByClass("current-parameter").get(0).getElementsByTag("em").get(1).text();
//            System.out.println(name+"|"+size+"|"+ppi+"|"+battery+"|"+camera+"|"+ram+"|"+rom);
//            System.out.print(name.replaceAll("参数","")+"|");
            ZOLList.add(name.replaceAll("参数","")+"|");
            ZOLList.add(page.getMetaData("price")+"|");
//            System.out.print(page.select("ul.versions").select("li").get(0).text());
            if (!page.select("ul.versions").isEmpty()){
                String rom = page.select("ul.versions").select("li").get(0).text().split("，")[1];
                rom = rom.substring(0,rom.indexOf(")"));
//                System.out.print(rom);
                ZOLList.add(rom);
            }
            Elements els = page.select("dd#mParam").get(0).select("p");
            for (Element el : els){
//                System.out.print("|");
//                System.out.print(el.text());
                ZOLList.add("|"+el.text());
            }
            ZOLList.add("\n");
        } else if (page.getMetaData("kind").contains("手机中国列表")){
            Elements els = page.select("p.pul-btn");
            for (Element el : els){
                String link = el.getElementsByTag("a").get(0).attr("href");
                CrawlDatum crawlDatum = new CrawlDatum(link).meta("kind","手机中国参数");
                crawlDatums.add(crawlDatum);
            }
        } else if (page.getMetaData("kind").contains("手机中国参数")){
            String name = page.select("#baseParamInfo").text().replaceAll("产品概要","");
            String price = page.select("em.Bid-price").text();
            Elements els = page.select("ul.outline").get(0).select("li");
            String param = "";
            for (Element el:els){
                param = param+el.text()+"|";
            }
//            System.out.println(name+"|"+price+"|"+param.substring(0,param.length()-1));
            CNMOList.add(name+"|"+price+"|"+param.substring(0,param.length()-1)+"\n");
        }
    }

    public static void main(String[] args) {
        PhoneInfoCrawler phoneInfoCrawler = new PhoneInfoCrawler("crawl",false);
        phoneInfoCrawler.setMaxExecuteCount(3);
        phoneInfoCrawler.setExecuteInterval(500);
        phoneInfoCrawler.setThreads(20);
        try {
            phoneInfoCrawler.start(2);
//            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\工作\\手机信息库\\ZOLPhoneInfo.txt")));
            BufferedWriter ZOLbw = new BufferedWriter(new FileWriter(new File("/home/tyx/ZOLPhoneInfo.txt")));
            for (String str : ZOLList){
                ZOLbw.write(str);
            }
            ZOLbw.close();
//            BufferedWriter CNMObw = new BufferedWriter(new FileWriter(new File("D:\\工作\\手机信息库\\CNMOPhoneInfo.txt")));
            BufferedWriter CNMObw = new BufferedWriter(new FileWriter(new File("/home/tyx/CNMOPhoneInfo.txt")));
            for (String str : CNMOList){
                CNMObw.write(str);
            }
            CNMObw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
