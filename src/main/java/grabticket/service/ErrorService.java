package grabticket.service;

import java.util.Map;

public class ErrorService {

    public void error(Map map) {
        if (map == null) {
            System.out.println("请求返回数据为空");
        }
        if (map.containsKey("code")) {
                if(!map.get("code").equals("00000")) {
                    System.out.println("错误信息为：" + map.get("message"));
                    System.out.println("请根据错误信息更改");
                    System.exit(0);
                }
        }
    }
}
