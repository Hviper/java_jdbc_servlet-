package com.example.Controller;

import com.example.db.DbUtils;
import com.example.entity.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 拾光
 * @version 1.0
 */
@WebServlet("UpdateUserById")
public class UpdateUserByIdHandler  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String old_id = req.getParameter("old_id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String new_id = req.getParameter("new_id");
        List<User> users = null;
        JSONObject tempJson = new JSONObject();
        PrintWriter writer = resp.getWriter();
        try {
            users = DbUtils.SelectAllUser();
            tempJson.put("code",200);
            tempJson.put("msg","成功");
            tempJson.put("count",users.size());
            tempJson.put("data",users);
            writer.print(tempJson);
        } catch (SQLException e) {
            tempJson.put("code",400);
            tempJson.put("msg","失败");
            tempJson.put("count",0);
            tempJson.put("data",null);
            writer.print(tempJson);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
