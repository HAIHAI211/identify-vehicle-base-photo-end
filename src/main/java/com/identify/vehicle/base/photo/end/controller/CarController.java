package com.identify.vehicle.base.photo.end.controller;

import com.identify.vehicle.base.photo.end.api.API;
import com.identify.vehicle.base.photo.end.entity.CarInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class CarController {
    /*
    * 从客户端获取图片并转成base64
    * */

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String wx_upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getBase64(request);
    }

    @RequestMapping(value = "/complex", method = RequestMethod.POST)
    public List<CarInfo> wx_upload_car(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String base64 = getBase64(request);
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        String token = params.getParameter("token");
        List<CarInfo> carInfoList = API.getCarInfo(base64, token);
        System.out.println(carInfoList);
        return carInfoList;
    }





    private String getBase64 (HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("utf-8");  //设置编码
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile mFiles =  req.getFile("file");
        File f=File.createTempFile("tmp", null);
        mFiles.transferTo(f);

        FileInputStream inputFile = new FileInputStream(f);
        String base64=null;
        byte[] buffer = new byte[(int) f.length()];
        inputFile.read(buffer);
        inputFile.close();
        base64=new BASE64Encoder().encode(buffer);
        return base64;
    }


}

