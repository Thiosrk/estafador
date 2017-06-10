package com.module.controller;

/**
 * Created by lenovo on 2017/6/10.
 */
import com.module.pojo.Echartskstock;
import com.module.pojo.Kstock;
import com.module.pojo.Stock;
import com.module.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BankTableController {
    @Autowired
    StockService stockService;

    @RequestMapping("/BankStock")
    public String BankStock(HttpServletRequest request, Model model){
      List<Stock> bankstock=stockService.getAllStocks();
        model.addAttribute("bankstocklist", bankstock);
        return "home";
    }

}
