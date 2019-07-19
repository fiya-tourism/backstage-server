package com.fy.backstage.order.controller;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.order.entity.Order;

import com.fy.backstage.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 51589 on 2019/7/15.
 */
@Controller
@RequestMapping("BackController")
public class BackController {
    @Autowired
    private OrderService orderService;


    /**
     *     //查询旅游订单数据
     * @param pageUtils
     * @return
     */
    @RequestMapping("getOrderList")
    @ResponseBody
    public DataGrid<Order> getOrderList(PageUtils pageUtils){
        return orderService.getOrderList(pageUtils);
    }

    /**
     *        //查询旅游订单数据
     * @param pageUtils
     * @return
     */
    @RequestMapping("getItemList")
    @ResponseBody
    public DataGrid<Order> getItemList(PageUtils pageUtils){
        return orderService.getItemList(pageUtils);
    }

    /**
     *        //删除订单数据
     * @param id
     * @return
     */
    @RequestMapping("deleteOrder")
    @ResponseBody
    //根据单号删除旅游订单数据
    public void deleteOrder(String id){
        orderService.deleteOrder(id);
    }




    @RequestMapping("getList")
    //前往主页面
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/backstage/commons/content");
        return mv;
    }



}
