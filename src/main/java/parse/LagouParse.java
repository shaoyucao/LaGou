package parse;

import model.LagouModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class LagouParse {
    public static List<LagouModel> getData(String html) throws Exception{ //这里的html为entity
        //获取的数据，存放在集合中
        List<LagouModel> lagouData = new ArrayList<LagouModel>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(html);
        //获取html标签中的内容
        Elements elements=doc.select("ul[class=clearfix position_list_ul]").select("li[class=position_list_item default_list]");
        for (Element ele:elements) {
            String jobID=ele.attr("data-jobid");
            String jobName=ele.attr("data-positionname");
            String jobSalary=ele.attr("data-salary");
            String jobCompany=ele.attr("data-company");
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
            LagouModel lagouModel =new LagouModel();
            //对象的值
            lagouModel.setJobID(jobID);
            lagouModel.setJobName(jobName);
            lagouModel.setJobSalary(jobSalary);
            lagouModel.setJobCompany(jobCompany);
            //将每一个对象的值，保存到List集合中
            lagouData.add(lagouModel);
        }
        //返回数据
        return lagouData;
    }
}
