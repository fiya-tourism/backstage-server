package com.fy.backstage.item.controller;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtil;
import com.fy.backstage.commons.UpFile;
import com.fy.backstage.item.domain.ItemAllVo;
import com.fy.backstage.item.feigh.ItemServiceFeigh;
import com.fy.backstage.travels.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * 主要是通过feign
 * 调用商品服务
 * @author monst
 * @date 2019/7/15
 */
@RestController
@RequestMapping("itemFeigh")
public class ItemController {

    @Autowired
    private ItemServiceFeigh itemServiceFeigh;

    /**
     * 调用发布商品接口
     * @param itemAllVo
     * @return
     */
    @RequestMapping("insert")
    public ResultVo insertItem(ItemAllVo itemAllVo){
        ResultVo resultVo = itemServiceFeigh.insertItem(itemAllVo);
        return resultVo;
    }

    /**
     * 调用商品列表接口
     * @param pageUtil
     * @return
     */
    @RequestMapping("queryList")
    public DataGrid queryItemList(PageUtil pageUtil){
        DataGrid dataGrid = itemServiceFeigh.queryItemList(pageUtil);
        return dataGrid;
    }

    /**
     * 上传图片
     * @param request
     * @param img
     * @return
     */
    @RequestMapping("uploadFile")
    public Map<String,String> uploadFile(HttpServletRequest request,MultipartFile img){
        Map<String,String> map = new HashMap<String,String>();
        String url = UpFile.upFile(img, request, "photo");
        map.put("url",url);
        return map;
    }


}
