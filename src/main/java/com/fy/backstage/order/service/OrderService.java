package com.fy.backstage.order.service;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.order.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by 51589 on 2019/7/15.
 */
@FeignClient(value = "orderser")
public interface OrderService {
    //查询旅游订单
    @RequestMapping(value = "getOrderList",method = RequestMethod.GET)
    DataGrid<Order> getOrderList(@RequestBody PageUtils pageUtils);
    //删除旅游订单
    @RequestMapping(value = "deleteOrder",method = RequestMethod.DELETE)
    void deleteOrder(@RequestParam("id") String id);

    //查询商品订单
    @RequestMapping(value = "getItemList",method = RequestMethod.GET)
    DataGrid<Order> getItemList(@RequestBody PageUtils pageUtils);
}
