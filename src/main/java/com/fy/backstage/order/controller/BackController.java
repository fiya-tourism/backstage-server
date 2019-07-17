package com.fy.backstage.order.controller;

import com.fy.backstage.order.entity.Order;

import com.fy.backstage.order.service.OrderService;
import com.fy.backstage.order.utils.DataGridVo;
import com.fy.backstage.order.utils.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
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
    //查询旅游订单数据
    public DataGridVo<Order> getOrderList(){
        Page pa = new Page();
        PageHelper.startPage(pa.getPage(), pa.getRows());
        List<Order> list = orderService.getOrderList();

        PageInfo<Order> pageInfo = new PageInfo<Order>(list,pa.getRows());

        DataGridVo<Order> gb = new DataGridVo<Order>();
        gb.setTotal(pageInfo.getTotal());
        gb.setRows(list);
        return gb;
    }
    @RequestMapping("deleteOrder")
    @ResponseBody
    //根据单号删除旅游订单数据
    public void deleteOrder(String id){
        orderService.deleteOrder(id);
    }
    @RequestMapping("selectByOrderId")
    @ResponseBody
    public Order selectByOrderId(String conId){
        Order order=orderService.selectByOrderId(conId);
        return order;
    }


    @RequestMapping("getList")
    //前往主页面
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/backstage/commons/content");
        return mv;
    }
    @RequestMapping("toupdate")
    //前往修改页面
    public ModelAndView toupdate(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/backstage/order/addAndUpdateOrder");
        return mv;
    }


}
