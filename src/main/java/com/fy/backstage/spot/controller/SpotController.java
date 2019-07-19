package com.fy.backstage.spot.controller;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.spot.entity.Spot;
import com.fy.backstage.spot.service.SpotService;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
    //上传图片
    private static String realPath = null;
    //上传图片文件夹
    private static final String FOLDER_NAME="upfile";

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
    public ModelAndView spotupdateftl(Spot spot){
        ModelAndView modelAndView = new ModelAndView("/backstage/spot/addSpots");
        modelAndView.addObject("spot",spot);
        return modelAndView;
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
    @RequestMapping(value = "spotinsert",method = RequestMethod.POST)
    public Integer spotinsert(Spot spot){
        Gson gson = new Gson();
        String Spotostr = gson.toJson(spot, Spot.class);
        return spotService.spotinsert(Spotostr);
    }
    @ResponseBody
    @PostMapping(value = "upload")
    public Map<String, String> upload(@RequestParam("file") MultipartFile file,HttpServletRequest request)throws IOException {
        //String separator = System.getProperty("file.separator");
        //separator=separator.replaceAll("\\\\","/");
       // 获取文件名
        String filename = file.getOriginalFilename();
        //文件名,如spring
        String name = filename.substring(0, filename.indexOf("."));
        //文件后缀,如.jpeg
        String suffix = filename.substring(filename.lastIndexOf("."));
        //创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1));

        //获取项目路径+端口号 比如：http://localhost:8080/
        String basePath =  request.getScheme() + "://"+ request.getServerName() + ":"+ request.getServerPort()+request.getContextPath();
        // 获取项目绝对路径
        realPath = request.getServletContext().getRealPath("/"+FOLDER_NAME+"/");

        // 创建一个文件夹
        File descFile = new File(realPath+name);
        String  newFilename = name + suffix;
        String parentPath = descFile.getParent();
        descFile = new File(parentPath + "/"+ newFilename);
 //       int i = 1;
        //若文件存在重命名
//        String newFilename = filename;
//        while (descFile.exists()) {
//            newFilename = name + "(" + i + ")" + suffix;
//            String parentPath = descFile.getParent();
//            descFile = new File(parentPath + "/"+ newFilename);
//            i++;
//        }
        //判断目标文件所在的目录是否存在
        if (!descFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            descFile.getParentFile().mkdirs();
        }
        //将内存中的数据写入磁盘
        file.transferTo(descFile);
        //完整的url
        //http://localhost:8011/upfile/02(1).jpg
        //原版
        //String fileUrl = "/uploads/" + dateDirs + "/" + newFilename;
        //改版
        //String fileUrl =realPath+"/"+FOLDER_NAME+ "/" + newFilename;
        //String[] data = {fileUrl};
        Map<String, String> map = new HashMap<String, String>();
        map.put("data",basePath+"/"+FOLDER_NAME+"/"+ newFilename);//这里应该是项目路径，返回前台url
         return map;


//        String separator = System.getProperty("file.separator");
//        separator=separator.replaceAll("\\\\","/");
//        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+ separator; //获取项目路径+端口号 比如：http://localhost:8080/
//
//        try {
//            String filePath="";
//            //获取源文件
//            //filePath="D:/FOLDER_NAME/" ;//存储地址，此处也可以在application.yml中配置对象用@Value("${*.**}")注解注入内容
//            String filename = file.getOriginalFilename();//获取图片名
//            String[] names=filename.split("\\.");//获取后缀格式
//            String uploadFileName=UUID.randomUUID().toString()+"."+names[names.length-1];//生成新图片
//            File targetFile = new File (filePath,uploadFileName);//目标文件
//            if (!targetFile.getParentFile().exists()){
//                targetFile.getParentFile().mkdirs();
//            }
//            //传图片一步到位
//            file.transferTo(targetFile);
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("data",basePath+FOLDER_NAME+"/"+uploadFileName);//这里应该是项目路径，返回前台url
//            return map;
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return  null;
//        }


    }







}
