package Http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Map;



public class httpTest {

    static String TOKEN =null;
    public static void main(String[] args) {
//        readJson1(getjson());
        getjson();
    }

    public static String getjson(){

        HttpClient httpClient = new DefaultHttpClient();
        String url = "http://api.12306.com/v1/train/trainInfos?" +
                "arrStationCode=GZQ&deptDate=2018-09-18&deptStationCode=SZQ&findGD=false";
        HttpGet httpGet = new HttpGet(url);
        String result=null;
        HttpResponse httpResponse = null;
        HttpEntity entity  = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            StatusLine statusLine  = httpResponse.getStatusLine();
            if(statusLine.getStatusCode()==200){
                entity = httpResponse.getEntity();
                result = EntityUtils.toString(entity);
//                TOKEN = httpResponse.getFirstHeader().g
            }
            System.out.println(statusLine.getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void readJson(String jsonStr){
        System.out.println(jsonStr);
            JSONObject jsonObject = new JSONObject(jsonStr);
            Map<String,Object > map= jsonObject.toMap();
//            Map<String,Object> map1=jsonObject.getJSONObject("data").toMap();
            Map<String,Object> data = (Map<String, Object>) map.get("data");
//            JSONObject trainDeptStations = new JSONObject(data.get("trainDeptStations"));
             ArrayList<String> trainDeptStations = (ArrayList<String>) data.get("trainDeptStations");

             for (int i=0;i<trainDeptStations.size();i++){
            String cityName=  trainDeptStations.get(i);
            System.out.println(cityName);
        }

    }

    public static  void readJson1(String jsonStr){
        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONObject dataJson=jsonObject.getJSONObject("data");
//        Map<String,Object> dataMap = dataJson.getJSONObject("data");
        Map<String, Object> trainInfos = dataJson.toMap();
//       Map<String,Object> trainInfosMap = (Map<String, Object>) trainInfos.get(trainInfos);
       Map<String,Object> trainDeptStations = (Map<String, Object>) trainInfos.get(trainInfos);
        ArrayList<String> cityNameArray = (ArrayList<String>) trainDeptStations.get("trainDeptStations");

    }

    public static void fastJsonTest(String jsonStr){
    }
}
