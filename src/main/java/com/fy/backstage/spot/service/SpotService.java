package com.fy.backstage.spot.service;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.spot.entity.Spot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: backstage-server
 * @Package: com.fy.backstage.spot.service
 * @ClassName: SpotService
 * @Author: 彭志新
 * @Description: 业务处理层
 * @Date: 2019/7/16 15:24
 * @Version: 1.0
 */
@FeignClient(value = "SPOTE-SERVER")
public interface SpotService {

    @ResponseBody
    @RequestMapping(value = "spotsController/soptSelect",method = RequestMethod.POST)
    DataGrid<Spot> spotselect(@RequestBody PageUtils page);

    @ResponseBody
    @RequestMapping(value = "spotsController/deleteSopt",method = RequestMethod.POST)
    Integer spotdelete(@RequestParam("SpotsId") Integer SpotsId);

    @ResponseBody
    @RequestMapping(value = "spotsController/insertSopt",method = RequestMethod.POST)
    Integer spotinsert(@RequestBody Spot spot);

    @ResponseBody
    @RequestMapping(value = "spotsController/SoptIdSelect",method = RequestMethod.GET)
    Spot spotById(@RequestParam("id") Integer id);
}
