package util;

import model.LagouModel;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import parse.LagouParse;

import java.util.ArrayList;
import java.util.List;

public class URLFecter {
    public static List<LagouModel> URLParser(HttpClient client, String url) throws Exception { //传入的client，是用HttpClient new出来的默认的http客户端
        //用来接收解析的数据
        List<LagouModel> LagouData = new ArrayList<LagouModel>(); //List是一个接口，ArrayList实现了这个接口
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = HTTPUtils.getRawHtml(client, url); ///////先获取html
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容或者json文件
        if(StatusCode == 200){
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");//获取实体内容
            LagouData = LagouParse.getData(entity); ///////通过html实体进行解析
            EntityUtils.consume(response.getEntity());//消耗实体
        }else {
            //否则，消耗掉实体
            EntityUtils.consume(response.getEntity());
        }
        return LagouData;
    }
}
