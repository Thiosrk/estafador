package com.spider;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLLIElement;
import com.module.pojo.Bank;
import com.module.pojo.Report;
import com.module.pojo.Stock;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
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


    private static final int ThreadNumber = 5; //线程池的容量,5比较合适

    public static void main(String[] args) {

        Spider spider = new Spider();

        /**
         * 用法示例
         */
        //1.多线程获取所有股票信息,由于是网页获取的，都是最新的
//        List<Stock> allStocks = spider.getAllStock();

        //2.单个获取某股票信息,由于是网页获取的，都是最新的
//        Stock stock = spider.getStock("sh600015");

        //3.获得银行行业的信息
//        List<Report> bankReports = spider.getBankReports(1);


        //4.获得某股票的研究报告
//        List<Report> stockReports = spider.getReports("sh600000");


    }


    public List<Stock> getAllStock() {

        List<Stock> stocks = new ArrayList<Stock>();

        // 创建容量为ThreadNumber的线程池。
        ExecutorService pool = Executors.newFixedThreadPool(ThreadNumber);
        //将stocks分为ThreadNumber份
        List<List<String>> spilts = subList(STOCKIDs, ThreadNumber);


        List<Future> futures = new ArrayList<Future>();

        for (int i = 0; i < spilts.size(); i++) {

            SpiderThread t = new SpiderThread(spilts.get(i));

            Future f = pool.submit(t);
            futures.add(f);
        }

        System.out.println("获取结果中...");
        for (Future f : futures) {
            try {
                stocks.addAll((ArrayList<Stock>) f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("得到结果.");

        // 关闭线程池。
        pool.shutdown();

        for (Stock stock : stocks) {
            System.out.println(stock.toString());
        }

        return stocks;

    }

    public Stock getStock(String stockId) {
        Stock stock = null;

        String url = "http://quote.eastmoney.com/" + stockId + ".html";

        try {
            WebClient webClient = getWebClient();
            HtmlPage page = webClient.getPage(url);
            //等待js执行，最多10s,setAjaxController后不需要这步，如果不行则开启
//          webClient.waitForBackgroundJavaScriptStartingBefore(10000);
//            String pageAsXml = page.asXml();

            //股票基本信息
            String name = page.querySelector("#name").asText();
            String price = page.querySelector("#price9").asText();
            String change = page.querySelector("#km1").asText();
            String changeP = page.querySelector("#km2").asText();
            String upStaying = page.querySelector("#gt3").asText();
            String fallStaying = page.querySelector("#gt10").asText();
            //*[@id="hqDetails"]/table/tbody/tr[1]/td[1]
            String open = page.querySelector("#gt1").asText();
            String close = page.querySelector("#gt8").asText();
            String high = page.querySelector("#gt2").asText();
            String low = page.querySelector("#gt9").asText();
            String tradeVol = page.querySelector("#gt5").asText();
            String tradeAmount = page.querySelector("#gt12").asText();
            String totalValue = page.querySelector("#gt7").asText();
            String freeValue = page.querySelector("#gt14").asText();

            String tr = page.querySelector("#gt4").asText();
            String pb = page.querySelector("#gt13").asText();
            String pe = page.querySelector("#gt6").asText();
            String qr = page.querySelector("#gt11").asText();
            String datetime = page.querySelector("#hqTime").asText();

            stock = new Stock(stockId, name, price, upStaying, fallStaying
                    , change, changeP, close, open, high, low, tradeVol, tradeAmount,
                    totalValue, freeValue, tr, pb, pe, qr, datetime);

            String netAsset = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(3)").asText();
            String netMargin = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(4)").asText();
            String gpr = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(7)").asText();
            String npr = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(8)").asText();
            String roe = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(1) > td:nth-child(9)").asText();

            stock.setNetAsset(netAsset);
            stock.setNetMargin(netMargin);
            stock.setGpr(gpr);
            stock.setNpr(npr);
            stock.setRoe(roe);


            //该股票在行业的排名
            String rank_totalValue = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(2)").asText();
            String rank_netAsset = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(3)").asText();
            String rank_netMargin = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(4)").asText();
            String rank_pe = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(5)").asText();
            String rank_pb = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(6)").asText();
            String rank_gpr = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(7)").asText();
            String rank_npr = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(8)").asText();
            String rank_roe = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(3) > td:nth-child(9)").asText();

            stock.setRank_totalValue(rank_totalValue);
            stock.setRank_netAsset(rank_netAsset);
            stock.setRank_netMargin(rank_netMargin);
            stock.setRank_pe(rank_pe);
            stock.setRank_pb(rank_pb);
            stock.setRank_gpr(rank_gpr);
            stock.setRank_npr(rank_npr);
            stock.setRank_roe(rank_roe);


            System.out.println(stock.toString());
            webClient.close();
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
            WebClient webClient = getWebClient();
            HtmlPage page = webClient.getPage(url);
            //行业的平均值信息
            String avg_totalValue = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(2)").asText();
            String avg_netAsset = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(3)").asText();
            String avg_netMargin = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(4)").asText();
            String avg_pe = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(5)").asText();
            String avg_pb = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(6)").asText();
            String avg_gpr = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(7)").asText();
            String avg_npr = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(8)").asText();
            String avg_roe = page.querySelector("body > div:nth-child(15) > div.fr.w790 > div:nth-child(2) > div.w578 > div.cwzb > table > tbody > tr:nth-child(2) > td:nth-child(9)").asText();

            bank = new Bank();
            bank.setAvg_totalValue(avg_totalValue);
            bank.setAvg_netAsset(avg_netAsset);
            bank.setAvg_netMargin(avg_netMargin);
            bank.setAvg_pe(avg_pe);
            bank.setAvg_pb(avg_pb);
            bank.setAvg_gpr(avg_gpr);
            bank.setAvg_npr(avg_npr);
            bank.setAvg_roe(avg_roe);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bank;

    }


    public List<Report> getReports(String stockCode) {
        String baseurl;
        int page = 1;
        boolean loop = true;


        baseurl = "http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/search/index.phtml?symbol="
                + stockCode + "&t1=all&p=";




        List<Report> reports = new ArrayList<Report>();

        while (loop) {
            String url = baseurl + page;
            System.out.println(url);
            try {
                Document doc = Jsoup.connect(url).get();


                if (!doc.select("body > div > div.main > table > tbody > tr:nth-child(3) > td").text().equals("没有找到相关内容..")) {
                    System.out.println("1----");
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

                        Report report = new Report();

                        report.setTitle(strings.get(1));
                        report.setType(strings.get(2));
                        report.setDate(strings.get(3));
                        report.setOrg(strings.get(4));
                        report.setReporter(strings.get(5));
                        report.setReportUrl(linkString);


                        System.out.println(report.toString());
                        report = getReportDetail(report);
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
        String url = "http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/search/index.phtml?t1=3&industry=%D2%F8%D0%D0%D0%D0%D2%B5&symbol=&p=" + i;
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
                Report report = new Report();

                report.setTitle(title);
                report.setType(type);
                report.setDate(date);
                report.setOrg(org);
                report.setReporter(reporter);
                report.setReportUrl(reportUrl);

                report = getReportDetail(report);
                System.out.println(report.toString());

                bankReports.add(report);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }

        return bankReports;
    }

    private Report getReportDetail(Report report) {

        try {
            Document doc = Jsoup.connect(report.getReportUrl()).get();

            Element title = doc.getElementsByTag("h1").get(0);

            Element detail = doc.getElementsByClass("creab").get(0);

            Element content = doc.getElementsByTag("p").get(0);

            // 格式化
            String contentString = content.outerHtml();

            contentString = "      " + contentString;
            contentString = contentString.replaceAll("<br>", "\n");
            contentString = contentString.replaceAll("<.*?>", "");
            contentString = contentString.replaceAll("&nbsp;", "  ");


            report.setmTitle(title.text());
            report.setmDetail(detail.text());
            report.setmContent(contentString);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return report;

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

    private class SpiderThread implements Callable<Object> {
        List<String> stockIds;

        private SpiderThread(List<String> stockIds) {
            this.stockIds = stockIds;
        }

        @Override
        public List<Stock> call() throws Exception {
            System.out.println("线程开始");
            List<Stock> results = new ArrayList<Stock>();
            for (String stockId : stockIds) {
                results.add(getStock(stockId));
            }
            System.out.println("线程结束");
            return results;
        }
    }

    private static <T> List<List<T>> subList(List<T> list, int blockSize) {
        List<List<T>> lists = new ArrayList<List<T>>();
        if (list != null && blockSize > 0) {
            int listSize = list.size();
            if (listSize <= blockSize) {
                lists.add(list);
                return lists;
            }
            int batchSize = listSize / blockSize;
            int remain = listSize % blockSize;
            for (int i = 0; i < batchSize; i++) {
                int fromIndex = i * blockSize;
                int toIndex = fromIndex + blockSize;

                lists.add(list.subList(fromIndex, toIndex));
            }
            if (remain > 0) {

                lists.add(list.subList(listSize - remain, listSize));
            }
        }
        return lists;
    }


}
