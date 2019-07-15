package com.fy.backstage.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 51589 on 2019/7/15.
 */
@Controller
public class BackController {
    @RequestMapping("tolist")
    public ModelAndView toList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/backstage/commons/orderList");
        return mv;
    }
}
