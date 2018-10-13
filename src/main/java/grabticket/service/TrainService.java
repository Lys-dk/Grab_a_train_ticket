package grabticket.service;

import com.alibaba.fastjson.JSON;
import grabticket.Http.MyHttpClient;
import grabticket.jsonBean.Seat;
import grabticket.jsonBean.TrafficInformation;
import grabticket.jsonBean.TrainInfos;
import grabticket.pojo.Passengers;
import grabticket.util.Propertys;

import java.util.Map;

public class TrainService {

    MyHttpClient Client = new MyHttpClient();
    StationService station  = new StationService();

    public TrafficInformation Search(){

        String fromCity = Propertys.properties().getProperty("fromCity");
        String toCity = Propertys.properties().getProperty("toCity");
        String date = Propertys.properties().getProperty("date");

        String formCityCode = station.getCityCode(fromCity);
        String toCityCode = station.getCityCode(toCity);

        StringBuffer url = new StringBuffer();
        url.append("http://api.12306.com/v1/train/trainInfos?arrStationCode=");
        url.append(formCityCode);
        url.append("&deptDate=");
        url.append(date);
        url.append("&deptStationCode=");
        url.append(toCityCode);
        url.append("&findGD=false");
        String result=Client.HttpGet(url.toString());
        TrafficInformation trafficInformation = JSON.parseObject(result,TrafficInformation.class);
        JSON h = JSON.parseObject(result);

        return  trafficInformation;
    }

    /*
       下订单所需要的参数
    */
    public String body(){
        OrderService order = new OrderService();
        Map map = order.getOrderInfo("硬座",null);
        TrainInfos trainInfos = (TrainInfos) map.get("TrainInfos");
        Seat seat= (Seat) map.get("Seat");
        Passengers passenger= getPassengers();

        StringBuffer sb = new StringBuffer();
        //始发站编码
        sb.append("{\"deptStationCode\":");
        sb.append("\""+trainInfos.getDeptStationCode()  +"\",");

        //终点站编码
        sb.append("\"arrStationCode\": ");
        sb.append("\""+trainInfos.getArrStationCode()   +"\",");

        //班次编码
        sb.append(" \"trainCode\":");
        sb.append("\""+trainInfos.getTrainCode()       +"\",");

        //出发时间
        sb.append("\"deptDate\":");
        sb.append("\""     +"2018-10-9"   +"\",");

        //座位价格
        sb.append("\"seatPrice\":");
        sb.append("\""     +seat.getSeatPrice()     +"\",");

        //所需时间
        sb.append("\"runTime\":");
        sb.append("\""+trainInfos.getRunTime()    +"\",");

        //出发时间
        sb.append("\"deptTime\":");
        sb.append("\""   +trainInfos.getDeptTime()   +"\",");

        //不知道
        sb.append("\"packId\":");
        sb.append("\""  +0   +"\",");

        //乘客信息
        String p= "\"passengers\":["+"{"
                +"\"birthday\":"           +"\""                      +"\","
                +"\"insurancePrice\":"     +0          +     ","
                +"\"isPassengerSave\":"    +true                 +","
                +"\"passengerMobile\":"    +null                  +","
                +"\"passengerName\":"      +"\""     +passenger.getPassengerName()        +"\","
                +"\"passportTypeId\":"     +"\""     +1                   +"\","
                +"\"policyProductNo\":"    +"\""                        +"\","
                +"\"passportNo\":"         +"\""    + passenger.getPassportNo()                  +"\","
                +"\"passengerId\":"        + "\""   +passenger.getPassengerId()                  +"\","
                +"\"sex\":"                +"\""     +passenger.getSex()               +"\","
                +"\"trainTicketType\":"    +"\""     +1                 +"\"}],";

        sb.append(p);

        String contactsInfo = "\"contactsInfo\":{"
                +"\"contactEmail\":"       +"\""                               +"\","
                +"\"contactMobile\":"      +"\""          +passenger.getPassengerMobile()       +"\","
                +"\"contactName\":"        +"\""          +passenger.getPassengerName()          +"\","
                +"\"contactPassportNo\":"  +"\""          +passenger.getPassportNo()                    +"\","
                +"\"contactPassportType\":"+"\""          +1                   +"\"},";

        sb.append(contactsInfo);

        //usingTrainAccount
        sb.append("\"usingTrainAccount\":");
        sb.append(false+",");


        //source
        sb.append("\"source\":");
        sb.append("\""    +trainInfos.getSource()      +"\",");

        //座位编号
        sb.append("\"trainZWCode\":");
        sb.append("\""+ "1" +  "\",");


        sb.append("\"clientTotalFee\":");
        sb.append("\"\",");

        //reserveTrainCode
        sb.append("\"reserveTrainCode\":");
        sb.append("\"\",");

        //reserveZwCode
        sb.append("\"reserveZwCode\":");
        sb.append("\"\"}");
        return sb.toString();
    }

    //从配置文件获取乘客的信息
    public Passengers getPassengers(){
        Passengers p = new Passengers();
        p.setPassengerMobile(Propertys.properties().getProperty("passengerMobile"));
        p.setSex(Propertys.properties().getProperty("sex"));
        p.setPassengerName(Propertys.properties().getProperty("passengerName"));
        p.setPassportTypeId(Propertys.properties().getProperty("passportTypeId"));
        p.setPassportNo(Propertys.properties().getProperty("passportNo"));
        p.setInsurancePrice(0);
        p.setIsPassengerSave(true);
        p.setTrainTicketType("1");
        return p;
    }
}
