package com.fy.backstage.travels.controller;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.commons.ResultMsg;
import com.fy.backstage.travels.domain.Comments;
import com.fy.backstage.travels.service.TravelsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("con")
public class TravelsCommentController {
    @Autowired
    private TravelsCommentService travelsCommentService;

    @RequestMapping("goAdd")
    public ModelAndView goAdd(){
        ModelAndView mav = new ModelAndView("backstage/travels/addtComment");
        return mav;
    }


    @RequestMapping("selTravelsQuery")
    @ResponseBody
    public DataGrid selTravelsQuery (PageUtils page){
        DataGrid travelsList = travelsCommentService.selTravelsQuery(page);
        return travelsList;
    }

    @RequestMapping("insertComment")
    @ResponseBody
    public ResultMsg insertComment(Comments comments){
        return travelsCommentService.insertComment(comments);
    }

    @RequestMapping("upTravelsYn")
    @ResponseBody
    public ResultMsg upTravelsYn(Comments comments){
        return travelsCommentService.upTravelsYn(comments);
    }
}
