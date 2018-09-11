package Http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class httppost {

    public static void main(String[] args) {
        String url = "http://api.12306.com/oauth/token";
        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","client");
        map.put("client_secret","secret");
        map.put("grant_type","password");
        map.put("password","57261d835a6d6a03f68b4ae024cd8765");
        map.put("username","18527305901");
        dopost(url,map);
    }
    public static void dopost(String url, Map<String,String> param) {
    }
}
