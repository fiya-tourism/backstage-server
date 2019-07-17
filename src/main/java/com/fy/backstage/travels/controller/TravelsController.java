package com.fy.backstage.travels.controller;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.travels.domain.Travel;
import com.fy.backstage.travels.service.TravelsService;
import com.fy.backstage.commons.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("tr")
public class TravelsController {

    @Autowired
    private TravelsService travelsService;

    @RequestMapping("selTrael")
    @ResponseBody
    public DataGrid selTrael(PageUtils page){
        DataGrid list = travelsService.selTr(page);
        return list;
    }
    @ResponseBody
    @RequestMapping("insertTravel")
    public void insertTravel(){
         travelsService.insertTravel();
    }


    @ResponseBody
    @RequestMapping(value = "delTravel")
    public ResultMsg delTravel(Travel travel){
      return travelsService.delTravel(travel);
    }

    @RequestMapping("upById")
    @ResponseBody
    public void upById(Integer travelsId){
         travelsService.upById(travelsId);
    }

}
