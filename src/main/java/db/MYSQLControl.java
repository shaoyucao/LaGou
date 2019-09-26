package db;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;

import model.LagouModel;
/*
 * Mysql操作的QueryRunner方法
 * 一个数据库操作类，别的程序直接调用即可
 */
public class MYSQLControl {

    //根据自己的数据库地址修改
    static DataSource ds = MyDataSource.getDataSource("jdbc:mysql://localhost:3306/lagouwang?"+
            "useUnicode=true & characterEncoding=utf-8 & useSSL=false & serverTimezone=UTC");
    static QueryRunner qr = new QueryRunner(ds); //QueryRunner为一个数据库操作类

    //第一类更新方法（使用sql语句更新）
    public static void executeUpdate(String sql){
        try {
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //第二类插入方法（使用数据库插入方法）
    public static void executeInsert(List<LagouModel> lagoudata) throws SQLException {
        /*
         * 定义一个Object数组，行列
         * 3表示列数，根据自己的数据定义这里面的数字
         */
        Object[][] params = new Object[lagoudata.size()][4];
        for ( int i=0; i<params.length; i++ ){
            params[i][0] = lagoudata.get(i).getJobID(); //可以用.get(i)方法获取到list的第i个对象
            params[i][1] = lagoudata.get(i).getJobName();
            params[i][2] = lagoudata.get(i).getJobSalary();
            params[i][3] = lagoudata.get(i).getJobCompany();
        }
        //测试
        /*String sql = "insert into jingdongbook values (?,?,?)";
        Object[] p1 = {"2","新华","5"};
        qr.update(sql,p1);*/

        qr.batch("insert into lagoujob (jobID, jobName, jobSalary, jobCompany)"
                + "values (?,?,?,?)", params); //实际返回的是一个int型的数组int[] batch, 每条记录插入成功则数组中对应的值为1

        System.out.println("执行数据库完毕！"+"成功插入数据："+lagoudata.size()+"条");


    }
}

