package Http;

import com.alibaba.fastjson.JSON;

import java.util.List;


public class fastJson {
    public static void main(String[] args) {
        readFastJson();
    }
    public static void readFastJson(){
        String jsonStr = httpTest.getjson();
        System.out.println(jsonStr);
        JSON json = (JSON) JSON.parse(jsonStr);
        JsonRootBean jsonRootBean = new JsonRootBean();
        jsonRootBean = JSON.parseObject(jsonStr, JsonRootBean.class);
        List<TrainInfos>  trainInfosList= jsonRootBean.getData().getTrainInfos();
    }
}
