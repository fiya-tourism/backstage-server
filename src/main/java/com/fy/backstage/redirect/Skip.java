package com.fy.backstage.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by monst on 2019/7/15.
 */
@RestController
@RequestMapping("skip")
public class Skip {

    /**
     * 旅游报表
     * @return
     */
    @RequestMapping("spotsEcharts")
    public ModelAndView spotsEcharts(){
        ModelAndView mav = new ModelAndView("backstage/spot/spotsEcharts");
        return mav;
    }

    /**
     * 商品报表
     * @return
     */
    @RequestMapping("itemEcharts")
    public ModelAndView itemEcharts(){
        ModelAndView mav = new ModelAndView("backstage/item/itemEcharts");
        return mav;
    }

    /**
     * 景点发布页面
     * @return
     */
    @RequestMapping("addSpots")
    public ModelAndView addSpots(){
        ModelAndView mav = new ModelAndView("backstage/spot/insertinto");
        return mav;
    }

    /**
     * 景点列表页面
     * @return
     */
    @RequestMapping("spotsList")
    public ModelAndView spotsList(){
        ModelAndView mav = new ModelAndView("backstage/spot/spotsList");
        return mav;
    }

    /**
     * 景点评论页面
     * @return
     */
    @RequestMapping("spotsComment")
    public ModelAndView spotsComment(){
        ModelAndView mav = new ModelAndView("backstage/spot/spotsComment");
        return mav;
    }

    /**
     * 商品发布页面
     * @return
     */
    @RequestMapping("addItem")
    public ModelAndView addItem(){
        ModelAndView mav = new ModelAndView("backstage/item/addItem");
        return mav;
    }

    /**
     * 商品列表页面
     * @return
     */
    @RequestMapping("itemList")
    public ModelAndView itemList(){
        ModelAndView mav = new ModelAndView("backstage/item/itemList");
        return mav;
    }

    /**
     * 商品评论页面
     * @return
     */
    @RequestMapping("itemComment")
    public ModelAndView itemComment(){
        ModelAndView mav = new ModelAndView("backstage/item/itemComment");
        return mav;
    }

    /**
     * 旅游订单
     * @return
     */
    @RequestMapping("stopsOrder")
    public ModelAndView stopsOrder(){
        ModelAndView mav = new ModelAndView("/backstage/order/stopsOrder");
        return mav;
    }

    /**
     * 商品订单
     * @return
     */
    @RequestMapping("itemOrder")
    public ModelAndView itemOrder(){
        ModelAndView mav = new ModelAndView("backstage/commons/itemOrder");
        return mav;
    }

    /**
     * 用户列表
     * @return
     */
    @RequestMapping("userList")
    public ModelAndView userList(){
        ModelAndView mav = new ModelAndView("backstage/user/userList");
        return mav;
    }

    /**
     * 游记列表
     * @return
     */
    @RequestMapping("travelsList")
    public ModelAndView travelsList(){
        ModelAndView mav = new ModelAndView("backstage/travels/travelsList");
        return mav;
    }

    /**
     * 游记评论
     * @return
     */
    @RequestMapping("travelsComment")
    public ModelAndView travelsComment(){
        ModelAndView mav = new ModelAndView("backstage/travels/travelsComment");
        return mav;
    }

    /**
     * 员工列表
     * @return
     */
    @RequestMapping("staffList")
    public ModelAndView staffList(){
        ModelAndView mav = new ModelAndView("backstage/staff/staffList");
        return mav;
    }
}
