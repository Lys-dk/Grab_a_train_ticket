package grabticket.Http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyHttpClient {

    /*
        ����entity������fastjson������
     */
    public String HttpGet(String url){
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
                result="�������,����";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
        ������post����
     */
    public String httpPost(String url,Map<String,String> param){

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        String result=null;                         //respon������
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        if(param!=null){
            for(Map.Entry<String,String> entry: param.entrySet()){
                nvp.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvp, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("�����ַ��"+url);
        System.out.println("���������"+nvp.toString());
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
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
