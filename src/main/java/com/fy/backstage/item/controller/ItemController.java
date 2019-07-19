package com.fy.backstage.item.controller;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.commons.ResultVo;
import com.fy.backstage.commons.UpFile;
import com.fy.backstage.item.domain.ItemAllVo;
import com.fy.backstage.item.domain.ItemReShow;
import com.fy.backstage.item.domain.ItemSpu;
import com.fy.backstage.item.domain.ItemSpuSearchVo;
import com.fy.backstage.item.feigh.ItemServiceFeigh;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
    public DataGrid queryItemList(PageUtils pageUtil,ItemSpuSearchVo itemSpuSearchVo){
        //将对象转换为json字符串
        String pageJson = new Gson().toJson(pageUtil);
        String searchJson = new Gson().toJson(itemSpuSearchVo);
        DataGrid dataGrid = itemServiceFeigh.queryItemList(pageJson,searchJson);
        return dataGrid;
    }

    /**
     * 去修改页面
     * @return
     */
    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(){
        ModelAndView mav = new ModelAndView("/backstage/item/updateItem");
        return mav;
    }

    /**
     * 根据id查询item
     * @return
     */
    @RequestMapping("getItem")
    public ItemReShow getItem(Integer itemId){
        return itemServiceFeigh.getItemById(itemId);
    }

    /**
     * 调用修改接口
     * @param itemAllVo
     * @return
     */
    @RequestMapping("update")
    public ResultVo updateItem(ItemAllVo itemAllVo){
        return itemServiceFeigh.updateItem(itemAllVo);
    }

    /**
     * 调用删除接口
     * @param itemId
     * @return
     */
    @DeleteMapping("delete/{itemId}")
    public ResultVo deleteItem(@PathVariable("itemId") Integer itemId){
        return itemServiceFeigh.deleteItem(itemId);
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
