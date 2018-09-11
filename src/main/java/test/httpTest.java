package test;

import grabticket.Http.MyHttpClient;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class httpTest {

    @Test
    public void postTest(){
        MyHttpClient hc = new MyHttpClient();
        String url = "http://api.12306.com/oauth/token";
        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","client");
        map.put("client_secret","secret");
        map.put("grant_type","password");
        map.put("password","57261d835a6d6a03f68b4ae024cd8765");
        map.put("username","18527305901");
        String resutlt = hc.httpPost(url,map);
        System.out.println(resutlt);
    }

    @Test
    public  void getTest(){
        MyHttpClient hc = new MyHttpClient();
        String url ="http://api.12306.com/v1/train/trainInfos?"+
                "arrStationCode=GZQ&deptDate=2018-09-17&deptStationCode=SZQ&findGD=false";
        String result=hc.HttpGet(url);
        JSON h = JSON.parseObject(result);
        System.out.println(h.toString());
    }
}
