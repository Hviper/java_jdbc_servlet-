package com.example.db;

import com.example.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


/**
 * @author 拾光
 * @version 1.0
 */
public class DbUtils {
    public static void main(String[] args) throws Exception {
        System.out.println(SelectByName("李慧娜"));
    }

    /**
     * @param user 待插入的user实体类
     * @return 返回 1 成功,设置捕获了异常：返回0表示失败，
     */
    public static int InsertUser(User user) throws Exception {
        QueryRunner run = new QueryRunner( ds );
        // Execute the SQL update statement and return the number of
        // inserts that were made
        int update = 0;
        try{
            update = run.update("INSERT INTO db_table (id,username,password) VALUES (?,?,?)",
                    user.getId(), user.getUsername(), user.getPassword());
        }catch (Exception e){
            //可以写入日志
            return update;
        }
        return update;
    }

    /** 查找通过 username，返回User对象
     * ch
     * @param username username
     * @return 返回User对象
     */
    public static User SelectByName(String username) throws SQLException {
        ResultSetHandler<User> h = new BeanHandler<>(User.class);
        QueryRunner run = new QueryRunner(ds);
        return run.query("SELECT * FROM db_table WHERE username=?", h, username);

    }




    public static List<User> SelectAllUser() throws SQLException {
        ResultSetHandler<List<User>> h = new BeanListHandler<>(User.class);
        QueryRunner run = new QueryRunner(ds);
        return run.query("SELECT * FROM db_table", h);
    }

    /**
     *
     * @param user  更新源（User）
     * @param id by id to update
     * @return  1：表示成功，0：表示失败
     */
    public static int UpdateUserById(User user,int id) throws SQLException {

        QueryRunner run = new QueryRunner(ds);
        return run.update( "UPDATE db_table SET id=?,username=?,password=? WHERE id=?",
                user.getId(),user.getUsername(),user.getPassword(), id );
    }




    /**
     * 类加载时初始化dataSource
     */
    static DataSource ds;

    static {
        try {
            ds = dataSource.GetDataSource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
