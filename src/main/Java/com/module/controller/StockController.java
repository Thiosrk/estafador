package com.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.module.pojo.Stock;

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
    @RequestMapping("/Stockspecific")
    public String Stockspecific(HttpServletRequest request, Model model){
        HttpSession session=request.getSession();
//        session.setAttribute(stockid);

//        request.setAttribute("stock", stockService.selectByPrimaryKey(id));
//        model.addAttribute("stock", stockService.selectByPrimaryKey(id));
        return "/stock";
    }

}
