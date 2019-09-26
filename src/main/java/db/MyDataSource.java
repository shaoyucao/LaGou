package db;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class MyDataSource {
    //用static修饰可以直接使用类名.方法名()，而不用再new一个对象
    public static DataSource getDataSource(String connectURI){
        BasicDataSource ds = new BasicDataSource();
        //MySQL的jdbc驱动
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");              //所要连接的数据库名
        ds.setPassword("123456");                //MySQL的登陆密码
        ds.setUrl(connectURI);
        return ds;
    }
}