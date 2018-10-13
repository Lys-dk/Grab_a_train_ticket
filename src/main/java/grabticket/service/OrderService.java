package grabticket.service;

import com.alibaba.fastjson.JSONObject;
import grabticket.Http.MyHttpClient;
import grabticket.jsonBean.Data;
import grabticket.jsonBean.Seat;
import grabticket.jsonBean.TrafficInformation;
import grabticket.jsonBean.TrainInfos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {


    ErrorService error = new ErrorService();
    public String  order(String access_token,String orderNo){
        ServiceForTrain sft = new  ServiceForTrain();
        MyHttpClient Client  = new MyHttpClient();
        String body = sft.body();
        StringBuffer url = new StringBuffer();
        url.append("http://api.12306.com/v1/train/order?access_token=");
        url.append(access_token);
        String result=null;
        Map resultMap=null;


            result = Client.httpPost(url.toString(),null,body);

            resultMap = (Map) JSONObject.parse(result);

            //拿到返回的结果，先交给ErrorService，判断返回的数据是否正确
            error.error(resultMap);

        System.out.println();


        Map data = (Map) resultMap.get("data");
        if(orderNo==null){
            orderNo = (String)data.get("orderNo");
        }
        return orderNo;
    }

    public void PlaceTheOrder(String access_token,String orderNo){

        MyHttpClient Client = new MyHttpClient();

        StringBuffer url = new StringBuffer();
        url.append("http://api.12306.com/v1/train/order-detail/");
        url.append(orderNo);
        url.append("?access_token=");
        url.append(access_token);
        String result =Client.HttpGet(url.toString());
        Map resultMap = (Map) JSONObject.parse(result);
        error.error(resultMap);
        Map data = (Map) resultMap.get("data");
        String code = (String) resultMap.get("code");
        //占座状态   占座中   占座成功,待支付
        String statusText = (String) data.get("statusText");

        while(true) {
            System.out.println("占座状态："+statusText);
            if (statusText.equals("占座中")) {
                System.out.println("占座中");
                result =Client.HttpGet(url.toString());
                resultMap = (Map) JSONObject.parse(result);
                data = (Map) resultMap.get("data");
                statusText = (String) data.get("statusText");
            }else if(statusText.equals("占座成功,待支付")){
                System.out.println("占座成功,待支付,登陆www.12306.com网站赶紧去支付吧");
                return;
            }else if(statusText.equals("占座失败")){

                orderNo=null;
                LoginService login = new LoginService();
                login.login();
                OrderService order = new OrderService();
                orderNo= order.order(access_token,orderNo);
                System.out.println("占座失败,重新下单");
                PlaceTheOrder(access_token,orderNo);
            }else {
                break;
            }
        }
    }

    /*
         获取班次信息和座位信息
      */
    public Map getOrderInfo(String seatName,String time){


        ServiceForTrain sft = new  ServiceForTrain();
        Map<String,Object > map = new HashMap<String, Object>();
        TrafficInformation tif = sft.Search();
        Data data = tif.getData();
        List<TrainInfos> trainInfosList = data.getTrainInfos();
        List<Seat> seatList = null;
        Seat seat = new Seat();
        for(TrainInfos t :trainInfosList ){
            seatList = t.getSeatList();
            for (Seat s: seatList){
                if(s.getSeatName().equals(seatName)){
                    seat = s;
                    map.put("Seat",s);
                    map.put("TrainInfos",t);
                    return map;
                }
            }
        }

        return map;
    }
}
