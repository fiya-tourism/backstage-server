package com.fy.backstage.order.controller;

import com.fy.backstage.order.entity.Order;

import com.fy.backstage.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 51589 on 2019/7/15.
 */
@Controller
public class BackController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("getOrderList")
    @ResponseBody
    public List<Order> getOrderList(){
        List<Order> list = orderService.getOrderList();
        return list;
    }
    @RequestMapping("deleteOrder")
    @ResponseBody
    public void deleteOrder(String id){
        orderService.deleteOrder(id);
    }


    @RequestMapping("getList")
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/backstage/commons/content");
        return mv;
    }


}
