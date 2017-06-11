package com.spider;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.module.pojo.Bank;
import com.module.pojo.Report;
import com.module.pojo.Stock;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * 网络爬虫，用于爬取股票信息，股票研报，行业研报等
 * 网站：http://finance.sina.com.cn/realstock/company/sh600000/nc.shtml
 * http://quote.eastmoney.com/sh600000.html
 * <p>
 * Created by xuyafan on 2017/6/8.
 */
public class Spider {


    public static final List<String> STOCKIDs = new ArrayList<String>(asList(
            "sh600000", "sh600015", "sh600016", "sh600036", "sh600908",
            "sh600919", "sh600926", "sh601009", "sh601128", "sh601166",
            "sh601169", "sh601229", "sh601288", "sh601328", "sh601398",
            "sh601818", "sh601939", "sh601988", "sh601997", "sh601998",
            "sh603323", "sz000001", "sz002142", "sz002807", "sz002839"));




    public static void main(String[] args) {

        Spider spider = new Spider();

        /**
         * 用法示例
         */
        //1.获取所有股票最新信息
        //[数据来源：金融界http://summary.jrj.com.cn/hybk/400128968.shtml?q=cn|s|bk400128968&c=m&n=hqa&o=pl,d&p=1030]
        List<Stock> allStocks = spider.getAllStocks();

        //2.单个获取某股票最新信息
//        Stock stock = spider.getStock("sh600015");

        //3.获得行业信息
//        Bank bank = spider.getBank();

        //4.获得银行行业的研究报告
        //[来源：新浪财经 http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/search/index.phtml?t1=3&industry=%D2%F8%D0%D0%D0%D0%D2%B5&symbol=&p=1]
        //[说明：直接获取不到，非API，参数是页数]
//        List<Report> bankReports = spider.getBankReports(1);


        //5.获得某股票的研究报告
        //[来源：新浪财经]
//        List<Report> stockReports = spider.getXLReports("sh600000");
        //[来源：腾讯论坛]
//        List<Report> stockReports =spider.getTCReports("sh600000");





    }


    public List<Stock> getAllStocks() {
        String url ="http://q.jrjimg.cn/?q=cn|s|bk400128968&c=m&n=hqa&o=pl,d&p=1030&_dc=1497160942162";

        List<Stock> stocks = new ArrayList<Stock>();

        BufferedReader br = null;
        String result = null;
        StringBuilder sbuilder = new StringBuilder();





        try {
            URL getUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) getUrl.openConnection();
            conn.setRequestMethod("GET");


            conn.connect();

            InputStream input = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(input, "GBK"));

            String tmpRead = null;
            while ((tmpRead = br.readLine()) != null) {
                sbuilder.append(tmpRead);
                sbuilder.append("\n");
            }

            br.close();
            result = sbuilder.toString().substring(8);
//            System.out.println(result);

            conn.disconnect();


        } catch (IOException e) {
            e.printStackTrace();
        }

        //parse String result
        if(result!=null){
            JSONObject object=new JSONObject(result);
            JSONArray hqData =object.getJSONArray("HqData");
            for(int i=0;i<hqData.length();i++){
                JSONArray data =hqData.getJSONArray(i);
                Stock stock =new Stock();
                stock.setId(data.getString(0));
                stock.setName(data.getString(2));
                stock.setClose(String.valueOf(data.getDouble(3)));
                stock.setOpen(String.valueOf(data.getDouble(5)));
                stock.setHigh(String.valueOf(data.getDouble(6)));
                stock.setLow(String.valueOf(data.getDouble(7)));
                stock.setPrice(String.valueOf(data.getDouble(8)));
                stock.setTradeVol(String.valueOf(data.getDouble(9))+"手");
                stock.setTotalValue(String.valueOf(data.getDouble(10))+"万");
                stock.setChange(String.valueOf(data.getDouble(11)));
                stock.setChangeP(String.valueOf(data.getDouble(12)));
                stock.setSwing(String.valueOf(data.getDouble(13)));
                stock.setChangeP(String.valueOf(data.getDouble(14)));
                stock.setTr(String.valueOf(data.getDouble(15)));
                stock.setPe(String.valueOf(data.getDouble(21)));



//                System.out.println(stock.toString());
                stocks.add(stock);
            }
        }




        return  stocks;


    }

    public Stock getStock(String stockId) {
        Stock stock =null;

        ArrayList<String> infos = new ArrayList<String>();

        String url1 = "https://gupiao.baidu.com/stock/" + stockId + ".html";
        String url2 = "http://quote.eastmoney.com/"+stockId+".html";

        try {
            //从百度股票通
            Document doc = Jsoup.connect(url1).get();

            String price = doc.select("#app-wrap > div.stock-info > div > div > strong").get(0).text();


            String change = doc.select("#app-wrap > div.stock-info > div > div> span:nth-child(2)").get(0).text();


            String changeP = doc.select("#app-wrap > div.stock-info > div > div> span:nth-child(3)").get(0).text();


            Elements sel = doc.getElementsByClass("line1");
            for (Element ele : sel) {
                String[] data = ele.text().split(" ");
                for (int i = 1; i < data.length; i += 2) {
                    infos.add(data[i]);
                }
            }

            sel = doc.getElementsByClass("line2");
            for (Element ele : sel) {
                String[] data = ele.text().split(" ");
                for (int i = 1; i < data.length; i += 2) {
                    infos.add(data[i]);
                }
            }

            String name = doc.select("#app-wrap > div.stock-info > div > h1 > a").text();


//            for(int i=0;i<infos.size();i++){
//                System.out.println(i+": "+infos.get(i));
//            }

            stock = new Stock(stockId, name, price,
                    infos.get(3), infos.get(14), change, changeP,
                    infos.get(11), infos.get(0), infos.get(2),
                    infos.get(13), infos.get(4), infos.get(5),
                    infos.get(18), infos.get(7), infos.get(12),
                    infos.get(19), infos.get(8), infos.get(17),infos.get(16)
            );

            //从东方财富网
            Document doc2 = Jsoup.connect(url2).get();

            String netAsset = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(3)").get(0).text();
            String netMargin =  doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(4)").get(0).text();
            String gpr = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(7)").get(0).text();
            String npr = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(8)").get(0).text();
            String roe =doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(9)").get(0).text();

            stock.setNetAsset(netAsset);
            stock.setNetMargin(netMargin);
            stock.setGpr(gpr);
            stock.setNpr(npr);
            stock.setRoe(roe);


            //该股票在行业的排名
            String rank_totalValue =doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(2)").get(0).text();
            String rank_netAsset = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(3)").get(0).text();
            String rank_netMargin = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(4)").get(0).text();
            String rank_pe =doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(5)").get(0).text();
            String rank_pb = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(6)").get(0).text();
            String rank_gpr = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(7)").get(0).text();
            String rank_npr = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(8)").get(0).text();
            String rank_roe = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(9)").get(0).text();

            stock.setRank_totalValue(rank_totalValue);
            stock.setRank_netAsset(rank_netAsset);
            stock.setRank_netMargin(rank_netMargin);
            stock.setRank_pe(rank_pe);
            stock.setRank_pb(rank_pb);
            stock.setRank_gpr(rank_gpr);
            stock.setRank_npr(rank_npr);
            stock.setRank_roe(rank_roe);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stock;

    }


    public Bank getBank() {
        Bank bank = null;
        //从某网站获取行业平均信息
        String url = "http://quote.eastmoney.com/sh600000.html";

        try {
            Document doc2 = Jsoup.connect(url).get();

            //行业的平均值信息
            String avg_totalValue = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(2)").get(0).text();
            String avg_netAsset = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(3)").get(0).text();
            String avg_netMargin = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(4)").get(0).text();
            String avg_pe = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(5)").get(0).text();
            String avg_pb = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(6)").get(0).text();
            String avg_gpr = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(7)").get(0).text();
            String avg_npr = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(8)").get(0).text();
            String avg_roe = doc2.select("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(9)").get(0).text();

            bank = new Bank();
            bank.setAvg_totalValue(avg_totalValue);
            bank.setAvg_netAsset(avg_netAsset);
            bank.setAvg_netMargin(avg_netMargin);
            bank.setAvg_pe(avg_pe);
            bank.setAvg_pb(avg_pb);
            bank.setAvg_gpr(avg_gpr);
            bank.setAvg_npr(avg_npr);
            bank.setAvg_roe(avg_roe);

            System.out.println(bank.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bank;

    }


    public List<Report> getXLReports(String stockCode) {
        String baseurl;
        int page = 1;
        boolean loop = true;


        baseurl = "http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/search/index.phtml?symbol="
                + stockCode + "&t1=all&p=";




        List<Report> reports = new ArrayList<Report>();

        while (loop) {
            String url = baseurl + page;

            try {
                Document doc = Jsoup.connect(url).get();


                if (!doc.select("body > div > div.main > table > tbody > tr:nth-child(3) > td").text().equals("没有找到相关内容..")) {

                    Element tbody = doc.getElementsByTag("tbody").get(0);

                    Elements trs = tbody.getElementsByTag("tr");
                    for (int i = 2; i < trs.size(); i++) {
                        Element tr = trs.get(i);
                        Elements tds = tr.getElementsByTag("td");
                        ArrayList<String> strings = new ArrayList<String>();
                        for (Element td : tds) {
                            strings.add(td.text());
                        }
                        Element link = tr.select("a[href]").first();
                        String linkString = link.attr("href");

                        Report report = new Report(stockCode,strings.get(1),strings.get(3),
                                strings.get(2),strings.get(4),strings.get(5),linkString);


                        System.out.println(report.toString());
                        reports.add(report);

                    }

                    page++;

                } else {
                    loop = false;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return reports;
    }

    public  List<Report> getBankReports(int i){
        // 定义即将访问的链接

        String url ="http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/search/index.phtml?t1=3&industry=%D2%F8%D0%D0%D0%D0%D2%B5&symbol=&p="+i;
        ArrayList<Report> bankReports = new ArrayList<Report>();
        try {


            WebClient webClient = getWebClient();
            HtmlPage page = webClient.getPage(url);
            String pageXml = page.asXml();

            DomNodeList<DomNode> trs = page.querySelectorAll("body > div > div.main > table > tbody > tr");
            for(int j=2;j<trs.size();j++){
                DomNode tr = trs.get(j);
                DomNodeList<DomNode> tds = tr.querySelectorAll("td");
                String title =tds.get(1).asText();
                String type =tds.get(2).asText();
                String date =tds.get(3).asText();
                String org =tds.get(4).asText();
                String reporter =tds.get(5).asText();

                String reportUrl =tds.get(1).querySelector("a").getAttributes().getNamedItem("href").getNodeValue();
                Report report = new Report("bank",title,date,type,org,reporter,reportUrl);
                System.out.println(report.toString());
                bankReports.add(report);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }

        return bankReports;
    }


    private WebClient getWebClient() {
        //创建一个webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        // 启动JS
        webClient.getOptions().setJavaScriptEnabled(true);
        //忽略ssl认证
        webClient.getOptions().setUseInsecureSSL(true);
        //运行错误时，不抛出异常
        webClient.getOptions().setThrowExceptionOnScriptError(false);
//          webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        //禁用Css，可避免自动二次请求CSS进行渲染
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setActiveXNative(false);
        // 设置Ajax异步
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        return webClient;
    }

    public  List<Report> getTCReports(String stockId) {
        List<Report> reports = new ArrayList<Report>();
        String url = "http://message.finance.qq.com/report/get_hq_report.php?n=50&zqdm="+stockId.substring(2)+"&seq=0&format=json";
        try {
            URL getUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String lines = reader.readLine().substring(12);

            JSONObject record = new JSONObject(lines);
            JSONObject news = record.getJSONObject("data");
            JSONArray list = news.getJSONArray("report");
            for (int i=0;i<list.length();i++) {
                JSONObject onenews = list.getJSONObject(i);
                String reporter = (String)(onenews.get("fxs"));
                String date = (String)(onenews.get("fbrq"));
                String title = (String)(onenews.get("title"));
                String reportUrl = "http://bbs.qq.com/finance/"+(String)(onenews.get("id"))+".html";
                String org = (String)(onenews.get("jgjc"));



                Report report =new Report(stockId,title,date,"公司报告",org,reporter,reportUrl);

//                System.out.println(report.toString());


                reports.add(report);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }





}
