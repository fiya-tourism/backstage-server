package com.fy.backstage.travels.service;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.travels.domain.Travel;
import com.fy.backstage.commons.ResultMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="TRAVELS-SERVER")
public interface TravelsService {


    @RequestMapping(value = "/travels/selTr", method = RequestMethod.POST)
    public DataGrid selTr(@RequestBody PageUtils page);

    @RequestMapping(value = "travles/insertTravel", method = RequestMethod.GET,params = "application/json; charset=UTF-8")
    public void insertTravel();

    @RequestMapping(value = "travels/delTravel", method = RequestMethod.POST)
    public ResultMsg delTravel(@RequestBody Travel travel);


    @RequestMapping("travels/upTravelById")
    public void upById(@RequestParam("travelsId") Integer travelsId);
}
