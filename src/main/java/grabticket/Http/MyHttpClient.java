package grabticket.Http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyHttpClient {
    public String HttpGet(String url){
        System.out.println("请求url:"+url);
        HttpClient httpClient = new DefaultHttpClient();
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
            }else {
                result="???????";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*

     */
    public String httpPost(String url,Map<String,String> param,String json){

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        String result=null;
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        if(param!=null){
            for(Map.Entry<String,String> entry: param.entrySet()){
                nvp.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
        }
        try {
            if(param!=null){
                httpPost.setEntity(new UrlEncodedFormEntity(nvp, "utf-8"));
            }
            else{
                StringEntity entity = new StringEntity(json,"utf-8");
                httpPost.setEntity(entity);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("请求url:"+url);


        if(param!=null){
            System.out.println("请求参数："+nvp.toString());
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        }else{
            System.out.println("请求参数："+json);
            httpPost.setHeader("Content-type", "application/json");
        }

        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        HttpResponse response=null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        try {
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
