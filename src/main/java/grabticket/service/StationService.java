package grabticket.service;

import com.alibaba.fastjson.JSONObject;
import grabticket.Http.MyHttpClient;

import java.util.List;
import java.util.Map;

public class StationService {



    /*
     访问http://api.12306.com/v1/train/stations,就可以获取所有城市的编码
     然后遍历，查找所需要城市的编码
      */
    public static String  getCityCode( String cityName) {
        String url = "http://api.12306.com/v1/train/stations";
        ErrorService error = new ErrorService();
        MyHttpClient client = new MyHttpClient();
        String result = client.HttpGet(url);

        Map json = (Map) JSONObject.parse(result);
        error.error(json);
        List<Object> data = (List) json.get("data");
        for (int i = 0; i < data.size(); i++) {
            Map map = (Map) data.get(i);
            if (map.get("cityName").equals(cityName)) {
                return (String) map.get("cityCode");
            }
        }
        System.out.println("请检查配置文件，查看始发站和终点站是否填写正确");
        System.exit(0);
        return null;
    }
}
