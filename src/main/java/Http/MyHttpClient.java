package Http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MyHttpClient {

    /*
        返回entity，用来fastjson来解析
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
            }
            System.out.println(statusLine.getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
