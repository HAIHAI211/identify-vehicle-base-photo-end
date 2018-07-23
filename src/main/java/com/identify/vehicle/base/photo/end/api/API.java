package com.identify.vehicle.base.photo.end.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.identify.vehicle.base.photo.end.entity.CarInfo;
import com.identify.vehicle.base.photo.end.utils.OKHttpUtil;
import okhttp3.FormBody;
import okhttp3.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class API {
    public static String APPID = "wx397544318206f249";
    public static String APPSECRET = "feb08eec8f485b428972ba00675b332e";
    public static String OPEN_ID_URL = "https://api.weixin.qq.com/sns/jscode2session";
    public static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;

    public static String getOpenId(String code) {
        String url = OPEN_ID_URL+"?appid="+APPID+"&secret="+APPSECRET+"&js_code="+code+"&grant_type=authorization_code";
        String result = OKHttpUtil.httpGet(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String openid = jsonObject.getString("openid");
        String session_key = jsonObject.getString("session_key");
        return openid;
    }

    public static Map<String, String> getToken() {
        String result = OKHttpUtil.httpGet(TOKEN_URL);
        JSONObject jsonpObject = JSONObject.parseObject(result);
        String access_token = jsonpObject.getString("access_token");
        String expires_in = jsonpObject.getString("expires_in");
        Map<String, String> map = new HashMap<>();
        map.put("access_token", access_token);
        map.put("expires_in", expires_in);
        return map;
    }

    public static String getCarInfo(String base64, String token, String num) {
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car?access_token=" + token;
        RequestBody formBody = new FormBody.Builder().add("image", base64)
                .add("top_num", num)
                .build();

        return OKHttpUtil.httpPost(url, formBody);
    }


//    public static JSONObject getCarInfo(String base64, String token) {
//        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car?access_token=" + token;
//        RequestBody formBody = new FormBody.Builder().add("image", base64)
//                .add("top_num", "3")
//                .build();
//
//        String result = OKHttpUtil.httpPost(url, formBody);
//        JSONObject jsonpObject = JSONObject.parseObject(result);
//        return jsonpObject;
//    }

//    public static List<CarInfo> getCarInfo(String base64, String token) {
//        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car?access_token=" + token;
//        RequestBody formBody = new FormBody.Builder().add("image", base64)
//                .add("top_num", "3")
//                .build();
//
//        String result = OKHttpUtil.httpPost(url, formBody);
//        JSONObject jsonpObject = JSONObject.parseObject(result);
//        JSONArray arr = jsonpObject.getJSONArray("result");
//        List<CarInfo> carInfoList = arr.toJavaList(CarInfo.class);
//        return carInfoList;
//    }





}
