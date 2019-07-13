package com.fy.backstage.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 武豫
 * @create 2019-07-13 11:07
 * @desc
 **/
@Controller
@RequestMapping("backstage")
public class BackstageController {


    @RequestMapping("content")
    public ModelAndView statement(){
        ModelAndView mav = new ModelAndView("/backstage/content");
        return mav;
    }

}
