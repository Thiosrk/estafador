package com.module.controller;

import com.module.service.calculateservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 69401 on 2017/7/8.
 */
@Controller
public class calculateController {

    @Autowired
    calculateservice calculateservice;

    @RequestMapping("/calculate")
    public String calculate(HttpServletRequest request, Model model){

        calculateservice.calculateMA(5);

        return null;
    }
}
