package com.fy.backstage.travels.controller;

import com.fy.backstage.travels.domain.Travel;
import com.fy.backstage.travels.service.TravelsService;
import com.fy.backstage.travels.util.DataGridVo;
import com.fy.backstage.travels.util.Page;
import com.fy.backstage.travels.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tr")
public class TravelsController {

    @Autowired
    private TravelsService travelsService;

    @RequestMapping("selTrael")
    @ResponseBody
    public DataGridVo selTrael(Page page){
        DataGridVo list = travelsService.selTr(page);
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