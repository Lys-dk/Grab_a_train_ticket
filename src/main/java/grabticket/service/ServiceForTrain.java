package grabticket.service;
import com.alibaba.fastjson.JSON;
import grabticket.Http.MyHttpClient;
import grabticket.jsonBean.Seat;
import grabticket.jsonBean.TrafficInformation;
import grabticket.jsonBean.TrainInfos;
import grabticket.pojo.Passengers;
import grabticket.util.Propertys;

import java.util.Map;

public class ServiceForTrain {

    //token
    String access_token =null;

    //订单编号
    String orderNo = null;

    MyHttpClient Client = new MyHttpClient();


    public static void main(String[] args) {
        ServiceForTrain sft = new ServiceForTrain();
        sft.run();
    }

    public void run(){

        Login login =new Login();
        Order o = new Order();

        //登陆之后获取token
        access_token = login.login();

        //获取订单号
        orderNo = o.order(access_token,orderNo);

        System.out.println("orderNo:"+orderNo);

        //用订单号和token去下单
        o.PlaceTheOrder(access_token,orderNo);
    }


    public TrafficInformation Search(){

        String fromCity = Propertys.properties().getProperty("fromCity");
        String toCity = Propertys.properties().getProperty("toCity");
        String date = Propertys.properties().getProperty("date");

        String formCityCode = Station.getCityCode(fromCity);
        String toCityCode = Station.getCityCode(toCity);

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
        ServiceForTrain sft = new  ServiceForTrain();
        Order order = new Order();
        Map map = order.getOrderInfo("硬座",null);
        TrainInfos trainInfos = (TrainInfos) map.get("TrainInfos");
       Seat seat= (Seat) map.get("Seat");
       Passengers passenger= sft.getPassengers();

        StringBuffer sb = new StringBuffer();
        //????????
        sb.append("{\"deptStationCode\":");
        sb.append("\""+trainInfos.getDeptStationCode()  +"\",");

        //????????
        sb.append("\"arrStationCode\": ");
        sb.append("\""+trainInfos.getArrStationCode()   +"\",");

        //???α???
        sb.append(" \"trainCode\":");
        sb.append("\""+trainInfos.getTrainCode()       +"\",");

        //出发时间
        sb.append("\"deptDate\":");
//        sb.append("\""     +trainInfos.getDeptDate()    +"\",");
        sb.append("\""     +"2018-10-9"   +"\",");
        //??λ???
        sb.append("\"seatPrice\":");
        sb.append("\""     +seat.getSeatPrice()     +"\",");

        //???????
        sb.append("\"runTime\":");
        sb.append("\""+trainInfos.getRunTime()    +"\",");

        //???????
        sb.append("\"deptTime\":");
        sb.append("\""   +trainInfos.getDeptTime()   +"\",");

        sb.append("\"packId\":");
        sb.append("\""  +0   +"\",");

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

        //trainZWCode
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
//        p.setPassengerId(59566);
        return p;
    }
}
