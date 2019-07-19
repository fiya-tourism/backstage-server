package com.fy.backstage.travels.service;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.commons.ResultMsg;
import com.fy.backstage.travels.domain.Comments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("TRAVELS-CRITIC-SERVER")
public interface TravelsCommentService {

    @RequestMapping(value = "com/selTravelsQuery",method = RequestMethod.POST)
    public DataGrid selTravelsQuery(@RequestBody PageUtils page);

    @RequestMapping(value = "com/insertTravels",method = RequestMethod.POST)
    public ResultMsg insertComment(@RequestBody Comments comments);

    @RequestMapping(value = "com/upTravelsYn",method = RequestMethod.POST)
    public ResultMsg upTravelsYn(@RequestBody Comments comments);
}
