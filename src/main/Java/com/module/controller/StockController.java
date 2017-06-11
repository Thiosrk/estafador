package com.module.controller;

import com.module.pojo.*;
import com.module.service.KstockService;
import com.module.service.StockService;
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

    @RequestMapping("/Stockspecific/{stockid}")
    public String Stockspecific(HttpServletRequest request, Model model,@PathVariable("stockid")String stockid){
        List<Kstock> kstocks = kstockService.selectByCode(stockid);
        List<Echartskstock> echartskstocks =new ArrayList<Echartskstock>();
        Bank bank=stockService.getBank();
        List<Report> reportlist1=stockService.getXLReports(stockid);
        List<Report> reportlist2=stockService.getTCReports(stockid);
        Stock stock=stockService.getStock(stockid);
        for(int i=0;i<kstocks.size();i++){
           echartskstocks.add(new Echartskstock(kstocks.get(i).getCode(), kstocks.get(i).getDate(), Double.valueOf(kstocks.get(i).getOpen()),Double.valueOf(kstocks.get(i).getClose()) ,Double.valueOf( kstocks.get(i).getLow()) , Double.valueOf(kstocks.get(i).getHigh()) ));
        }
        model.addAttribute("stock", stock);
        model.addAttribute("kstock", kstocks.get(0));
        model.addAttribute("bank", bank);
        model.addAttribute("echartstock", echartskstocks);
        model.addAttribute("reportlist1", reportlist1);
        model.addAttribute("reportlist2", reportlist2);
        return "stock";
    }



//    @RequestMapping("/stock/{stockid}")
//    public  String Stock(Model model, @PathVariable("stockid")String stockid){
//        List<Kstock> kstocks = kstockService.selectByCode(stockid);
//        model.addAttribute("stock", kstocks.get(0));
//        return "show";
//    }

}
