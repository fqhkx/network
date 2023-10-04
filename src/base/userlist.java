package base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet("/userlist")
public class userlist extends HttpServlet {
    String driver = "com.mysql.cj.jdbc.Driver";
    String URL="jdbc:mysql://localhost/test?serverTimezone=GMT%2B8";
    String USERNAME="kingjames";
    String PASSWORD="fq10113613";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sql = "INSERT INTO people VALUES (null,?,?)";
        Connection con = null;
        PreparedStatement pre = null;
        //ResultSet resultSet = null;
        //测试2
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pre = con.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,password);
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
