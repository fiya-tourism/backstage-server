package com.fy.backstage.order.service;

import com.fy.backstage.order.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 51589 on 2019/7/15.
 */
@FeignClient(value = "orderser")
public interface OrderService {
    @RequestMapping(value = "getOrderList",method = RequestMethod.GET)
    List<Order> getOrderList();

    @RequestMapping(value = "deleteOrder",method = RequestMethod.DELETE)
    void deleteOrder(@RequestParam("id") String id);
}
