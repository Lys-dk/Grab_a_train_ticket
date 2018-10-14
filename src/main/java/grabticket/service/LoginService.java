package grabticket.service;

import com.alibaba.fastjson.JSONObject;
import grabticket.Error.LoginEror;
import grabticket.Http.MyHttpClient;
import grabticket.util.MD5Utils;
import grabticket.util.Propertys;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    LoginEror loginEror = new LoginEror();
    MyHttpClient hc = new MyHttpClient();

    public String login(){

        String url = "http://api.12306.com/oauth/token";
        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","client");
        map.put("client_secret","secret");
        map.put("grant_type","password");
        map.put("password", MD5Utils.md5(Propertys.userProperty().getPassword()));
        map.put("username",Propertys.userProperty().getName());
        String result = hc.httpPost(url,map,null);
        Map resultMap = (Map) JSONObject.parse(result);
        loginEror.error(resultMap);
        String  access_token = (String) resultMap.get("access_token");
        System.out.println("login:"+result);
        return access_token;
    }
}
