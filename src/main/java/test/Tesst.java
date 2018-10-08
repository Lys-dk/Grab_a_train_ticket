package test;

import grabticket.pojo.User;
import grabticket.util.MD5Utils;
import grabticket.util.Propertys;
import org.junit.Test;

public class Tesst {

    @Test
    public void md(){

       User u= Propertys.userProperty();

        System.out.println(MD5Utils.md5(u.getPassword()));
    }
}
