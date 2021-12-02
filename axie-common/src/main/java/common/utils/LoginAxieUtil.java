package common.utils;

import com.alibaba.fastjson.JSON;
import common.entity.axie.TokenDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class LoginAxieUtil {
    public static String TOKEN = null;
    public static boolean INIT = false;

    public static void login() {
        if (!INIT) {
            String url = "https://api.hhwguild.com/index.php/user/login";
            Map<String, String> map = new HashMap<>();
            map.put("account", "");
            map.put("password", "");
            String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, map);
            TokenDTO tokenDTO = JSON.parseObject(httpOrgCreateTestRtn, TokenDTO.class);
            if (!Objects.isNull(tokenDTO.getData())) {
                TOKEN = tokenDTO.getData().getToken();
                INIT = true;

            }
        }

    }

}
