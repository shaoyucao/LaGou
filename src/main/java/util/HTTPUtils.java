package util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;
import org.apache.log4j.Logger;

import java.io.IOException;

public abstract class HTTPUtils {
    public static HttpResponse getRawHtml(HttpClient client, String personalUrl){
        //获取响应文件，即html，采用get方法获取响应数据
        HttpGet getMethod = new HttpGet(personalUrl);//get方法请求
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
                HttpStatus.SC_OK, "OK");//初始化http响应
        try {
            response = client.execute(getMethod); //执行响应
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //getMethod.abort();
        }
        return response;
    }
}
