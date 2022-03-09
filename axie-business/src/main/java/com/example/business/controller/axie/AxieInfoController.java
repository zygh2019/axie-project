package com.example.business.controller.axie;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.business.CheckLogin;
import common.entity.axie.StatisticsDTO;
import common.utils.HttpClientUtil;
import common.utils.response.ApiResponse;
import common.utils.response.ResponseUtil;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liushengbin
 * @since 2021-12-02
 */
@RestController
@RequestMapping("/axie")

public class AxieInfoController {

    @GetMapping("/getCount")
    @CheckLogin
    public ApiResponse<List<StatisticsDTO>> getCount() {
        //登陆
        Map<String, String> map1 = new HashMap<>();
        String url = "https://api.hhwguild.com/index.php/summary/get_earning_table";
        map1.put("batch_id", "BAT657");
        map1.put("order_column", "Tag");
        map1.put("order_type", "Forward");
        map1.put("version", "1.0.6");
        String httpOrgCreateTestRtn1 = HttpClientUtil.doPost(url, map1);
        JSONObject tokenDTO = JSON.parseObject(httpOrgCreateTestRtn1);
        JSONObject data = tokenDTO.getJSONObject("data");
        String table = data.getString("table");
        List<StatisticsDTO> busLineList = JSON.parseObject(table, new TypeReference<List<StatisticsDTO>>() {});



        return ResponseUtil.success(busLineList);

    }

    @GetMapping("/getSlpPrice")
    public ApiResponse<List<StatisticsDTO>> getCount(Integer type) {
        String url = "https://min-api.cryptocompare.com/data/price";
        Map<String, Object> map = new HashMap<>();
        map.put("fsym", "SLP");
        map.put("tsyms", "CNY");
        String s = HttpClientUtil.doGet(url, map);
        return ResponseUtil.success(s);

    }

    @GetMapping("/getMMr")
    public ApiResponse<String> getMMr() throws IOException {
        HttpResponse<String> response = Unirest.get("https://axie-infinity.p.rapidapi.com/get-update/0xad89c3171ab8da76ab61d47f76f959742cb69135?id=0xad89c3171ab8da76ab61d47f76f959742cb69135")
                .header("x-rapidapi-host", "axie-infinity.p.rapidapi.com")
                .header("x-rapidapi-key", "3490c4fc64mshfb2b0c51119d515p1cb21djsne48162e51fae")
                .asString();
        return ResponseUtil.success( response.getBody());

    }
}

