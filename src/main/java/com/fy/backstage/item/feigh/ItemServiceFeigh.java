package com.fy.backstage.item.feigh;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.ResultVo;
import com.fy.backstage.item.domain.ItemAllVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by monst on 2019/7/15.
 */
@FeignClient(name="ITEM-SERVER")
public interface ItemServiceFeigh {
    @RequestMapping(value="item/insert",method = RequestMethod.POST)
    ResultVo insertItem(@RequestBody ItemAllVo itemAllVo);

    @RequestMapping(value="item/queryList",method = RequestMethod.POST)
    DataGrid queryItemList(@RequestBody PageUtil pageUtil);
}
