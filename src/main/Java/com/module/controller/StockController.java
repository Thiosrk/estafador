package com.module.controller;

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

import java.util.List;

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

    @RequestMapping("/Stockspecific")
    public String Stockspecific(HttpServletRequest request, Model model){
        HttpSession session=request.getSession();
//        session.setAttribute(stockId);

//        request.setAttribute("stock", stockService.selectByPrimaryKey(id));
//        model.addAttribute("stock", stockService.selectByPrimaryKey(id));
        return "/stock";
    }

//    @RequestMapping("/showUserToJspById/{userId}")
//    public String showUser(Model model,@PathVariable("userId") Long userId){
//        SysUser user = this.sysUserService.getById(userId);
//        model.addAttribute("user", user);
//        return "showUser";
//    }

    @RequestMapping("/stock/{stockid}")
    public  String Stock(Model model, @PathVariable("stockid")String stockid){
        List<Kstock> kstocks = kstockService.selectByCode(stockid);
        model.addAttribute("stock", kstocks.get(0));
        return "show";
    }

}
