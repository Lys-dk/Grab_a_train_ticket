package main;
import grabticket.Http.MyHttpClient;
import grabticket.service.LoginService;
import grabticket.service.OrderService;

public class Run {

    //token
    String access_token =null;

    //订单编号
    String orderNo = null;

    MyHttpClient Client = new MyHttpClient();


    public static void main(String[] args) {
        Run run = new Run();
        run.run();
    }

    public void run(){

        LoginService login =new LoginService();
        OrderService o = new OrderService();

        //登陆之后获取token
        access_token = login.login();

        //获取订单号
        orderNo = o.order(access_token,orderNo);

        System.out.println("orderNo:"+orderNo);

        //用订单号和token去下单
        o.PlaceTheOrder(access_token,orderNo);
    }

}
