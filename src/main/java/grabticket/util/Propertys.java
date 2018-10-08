package grabticket.util;

import grabticket.pojo.Passengers;
import grabticket.pojo.User;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Properties;

/*
    ��ȡ�����ļ�
 */
public class Propertys {

    public static void main(String[] args) {

    }

    /*
     ��ȡuser.properties�����ļ�
     */
    public static User userProperty(){
        User user = new User();
        Properties prop = new Properties();
        try{
            InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/user.properties"));
            prop.load(new InputStreamReader(in, "utf-8"));     ///���������б�

            Iterator<String> it=prop.stringPropertyNames().iterator();
            user.setName(prop.getProperty("name"));
            user.setPassword(prop.getProperty("password"));
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return user;
    }

    public static Properties properties(){

      Passengers passengers = new Passengers();
        Properties prop = new Properties();
        try{
            InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/passengers.properties"));
            prop.load(new InputStreamReader(in, "utf-8"));     ///���������б�
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return  prop;
    }
}
