package main;

import db.MYSQLControl;
import model.LagouModel;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import util.URLFecter;

import java.util.List;

public class LagouMain {
    static Logger logger = Logger.getLogger(LagouMain.class);

    public static void main(String[] args) throws Exception {
        HttpClient client = new DefaultHttpClient();
        String url = "https://www.lagou.com/";
        //抓取的数据
        List<LagouModel> Lagoudatas= URLFecter.URLParser(client, url);

        //循环输出抓取的数据
        for (LagouModel lagou:Lagoudatas) {
            logger.info("jobID:"+lagou.getJobID()+"\t"+"jobName:"+lagou.getJobName()+"\t"+"jobSalary:"+lagou.getJobSalary()+"\t"+"jobCompany:"+lagou.getJobCompany());
        }

        //将抓取的数据插入数据库
        MYSQLControl.executeInsert(Lagoudatas);

    }
}
