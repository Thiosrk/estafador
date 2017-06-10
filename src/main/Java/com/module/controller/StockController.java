package com.module.controller;

import com.module.pojo.Echartskstock;
import com.module.pojo.Kstock;
import com.module.service.KstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.module.pojo.Stock;

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

    @RequestMapping("/Stockspecific/{stockid}")
    public String Stockspecific(HttpServletRequest request, Model model,@PathVariable("stockid")String stockid){
        List<Kstock> kstocks = kstockService.selectByCode(stockid);
        List<Echartskstock> echartskstocks =new ArrayList<Echartskstock>();
        for(int i=0;i<kstocks.size();i++){
           echartskstocks.add(new Echartskstock(kstocks.get(i).getCode(), kstocks.get(i).getDate(), Integer.valueOf(kstocks.get(i).getOpen()),Integer.valueOf(kstocks.get(i).getClose()) ,Integer.valueOf( kstocks.get(i).getLow()) , Integer.valueOf(kstocks.get(i).getHigh()) ));
        }
        model.addAttribute("stock", kstocks.get(0));
        model.addAttribute("echartstock", echartskstocks);
        return "stock";
    }



//    @RequestMapping("/stock/{stockid}")
//    public  String Stock(Model model, @PathVariable("stockid")String stockid){
//        List<Kstock> kstocks = kstockService.selectByCode(stockid);
//        model.addAttribute("stock", kstocks.get(0));
//        return "show";
//    }

}
