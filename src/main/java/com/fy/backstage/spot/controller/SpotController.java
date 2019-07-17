package com.fy.backstage.spot.controller;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.spot.entity.Spot;
import com.fy.backstage.spot.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: backstage-server
 * @Package: com.fy.backstage.spot.controller
 * @ClassName: SpotController
 * @Author: 彭志新
 * @Description: 控制层
 * @Date: 2019/7/16 15:23
 * @Version: 1.0
 */
@Controller
@RequestMapping("spotController")
public class SpotController {

    @Autowired
    private SpotService spotService;

    @ResponseBody
    @RequestMapping("spotById")
    public Spot spotById(Integer Id){
        return spotService.spotById(Id);
    }

    @ResponseBody
    @RequestMapping("spotselect")
    public DataGrid<Spot> spotselect(PageUtils page){
        DataGrid<Spot> spotselect = spotService.spotselect(page);
        return spotselect;
    }
    @RequestMapping("spotupdateftl")
    public String spotupdateftl(){
        return "backstage/spot/addSpots";
    }

    @ResponseBody
    @RequestMapping("spotdelete")
    public Integer spotdelete(Integer Id){
        Integer spotdelete = spotService.spotdelete(Id);
        if (spotdelete==1){
            return 1;
        }
        return 2;
    }
    @ResponseBody
    @RequestMapping("spotinsert")
    public Integer spotinsert(Spot spot){
        return spotService.spotinsert(spot);

    }







}
