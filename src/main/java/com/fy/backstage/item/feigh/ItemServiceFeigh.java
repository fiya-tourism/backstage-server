package com.fy.backstage.item.feigh;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.commons.ResultVo;
import com.fy.backstage.item.domain.ItemAllVo;
import com.fy.backstage.item.domain.ItemReShow;
import com.fy.backstage.item.domain.ItemSpu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by monst on 2019/7/15.
 */
@FeignClient(name="ITEM-SERVER")
public interface ItemServiceFeigh {
    //新增
    @RequestMapping(value="item/insert",method = RequestMethod.POST)
    ResultVo insertItem(@RequestBody ItemAllVo itemAllVo);

    //查询
    @RequestMapping(value="item/queryList",method = RequestMethod.POST)
    DataGrid queryItemList(@RequestParam("pageJson") String pageJson,
                           @RequestParam("searchJson") String searchJson);

    //回显
    @RequestMapping(value="item/getItemById",method = RequestMethod.GET)
    ItemReShow getItemById(@RequestParam("itemId") Integer itemId);

    //修改
    @RequestMapping(value="item/update",method = RequestMethod.POST)
    ResultVo updateItem(@RequestBody ItemAllVo itemAllVo);

    //删除
    @RequestMapping(value="item/delete",method = RequestMethod.DELETE)
    ResultVo deleteItem(@RequestParam("itemId") Integer itemId);
}
