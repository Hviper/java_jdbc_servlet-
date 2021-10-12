package com.example.db;

import com.alibaba.druid.pool.DruidDataSource;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 拾光
 * @version 1.0
 */
public class dataSource {
    /**
     * 类内部进行：测试database数据源   【DruidDataSource  采用德鲁伊数据源配合apache中的commons下的DbUtils完成数据库的增删改查】
     */
    public static void main(String[] args) throws Exception {
        DataSource dataSource = GetDataSource();
        System.out.println(dataSource);
    }

    public static DataSource GetDataSource() throws Exception {
        Properties properties = new Properties();
        InputStream in = dataSource.class.getClassLoader().getResourceAsStream("config.properties");
        properties.load(in);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        DruidDataSource db = new DruidDataSource();
        db.setUsername(username);
        db.setPassword(password);
        db.setUrl(url);
        db.setDriverClassName(driver);
        return db;
    }
}
