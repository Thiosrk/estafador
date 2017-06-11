package com.module.controller;

import com.module.pojo.*;
import com.module.service.KstockService;
import com.module.service.StockService;
import com.module.service.WRCalService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

/**
 * Created by NJU on 2017/6/9.
 */
@Controller
@RequestMapping("/Stock")
public class StockController {
    /**
     * 跳转到具体股票界面
     * @param request
     * @return
     */

    @Autowired
    KstockService kstockService;
    @Autowired
    StockService stockService;
    @Autowired
    WRCalService wrCalService;

    @RequestMapping("/Stockspecific/{stockid}")
    public String Stockspecific(HttpServletRequest request, Model model,@PathVariable("stockid")String stockid){
        List<Kstock> kstocks = kstockService.selectByCode(stockid);
//        List<Echartskstock> echartskstocks =new ArrayList<Echartskstock>();
        Bank bank=stockService.getBank();
        List<Report> reportlist1=stockService.getXLReports(stockid);
        List<Report> reportlist2=stockService.getTCReports(stockid);
        List<News> newsList=stockService.getNews(stockid,1);
        List<News> noticeList=stockService.getNotices(stockid,1);
        List<Discuss> discussList=stockService.getDiscusses(stockid,1,"time");

        double wr2=wrCalService.GetWR2(stockid);
        WR wr=new WR();

        System.out.println(reportlist2.get(0).getTitle());
        Stock stock=stockService.getStock(stockid);

        double close=Double.parseDouble(stock.getPrice());
        double tomorrowclose;
//        for(int i=0;i<kstocks.size();i++){
//           echartskstocks.add(new Echartskstock(kstocks.get(i).getCode(), kstocks.get(i).getDate(), Double.valueOf(kstocks.get(i).getOpen()),Double.valueOf(kstocks.get(i).getClose()) ,Double.valueOf( kstocks.get(i).getLow()) , Double.valueOf(kstocks.get(i).getHigh()) ));
//        }

        JSONArray kstocksjson = new JSONArray();
        for(int i=0;i<kstocks.size();++i){
            JSONArray tmp = new JSONArray();
            tmp.put(kstocks.get(i).getDate());
            tmp.put(Double.valueOf(kstocks.get(i).getOpen()));
            tmp.put(Double.valueOf(kstocks.get(i).getClose()));
            tmp.put(Double.valueOf(kstocks.get(i).getLow()));
            tmp.put(Double.valueOf(kstocks.get(i).getHigh()));
//            JSONObject tmp = new JSONObject(echartskstocks.get(i));
//            kstocksjson.accumulate("data",tmp);
            kstocksjson.put(tmp);
        }

        if(wr2<=20){
            tomorrowclose=close*(wr2/20);
        }else if((wr2>20)&&(wr2<50)){
            tomorrowclose=close*0.95;
        }else if((wr2>50)&&(wr2<80)){
            tomorrowclose=close*1.05;
        }else {
            tomorrowclose=close*(wr2/80);
        }

        tomorrowclose=(int)(tomorrowclose*100)/100.0;
        wr.setWr2(wr2);
        wr.setTomorrowclose(tomorrowclose);

        model.addAttribute("stock", stock);
//        model.addAttribute("kstock", kstocks.get(0));
        model.addAttribute("bank", bank);
        model.addAttribute("kstocksjson", kstocksjson);
        model.addAttribute("reportlist1", reportlist1);
        model.addAttribute("reportlist2", reportlist2);
        model.addAttribute("newslist", newsList);
        model.addAttribute("noticelist", noticeList);
        model.addAttribute("discusslist", discussList);
        model.addAttribute("close",close);
        model.addAttribute("wr",wr);

        return "stock";
    }



//    @RequestMapping("/stock/{stockid}")
//    public  String Stock(Model model, @PathVariable("stockid")String stockid){
//        List<Kstock> kstocks = kstockService.selectByCode(stockid);
//        model.addAttribute("stock", kstocks.get(0));
//        return "show";
//    }

}
