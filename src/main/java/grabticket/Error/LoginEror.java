package grabticket.Error;

import java.util.Map;

public class LoginEror {

    public void error(Map map){
        if(map.containsKey("error")){
            System.out.println("错误信息：密码或账号为空,请检查user.properties配置文件是否填写正确");
            System.exit(0);
        }
    }
}
