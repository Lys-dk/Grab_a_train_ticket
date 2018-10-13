package grabticket.service;

import com.alibaba.fastjson.JSONObject;
import grabticket.Http.MyHttpClient;

import java.util.List;
import java.util.Map;

public class StationService {


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
        return "输入城市有误，请重新检查";
    }
}
