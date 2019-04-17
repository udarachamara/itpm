/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class librarian {
    String name;
    String userName;
    String password;
    
    PreparedStatement pst;
    Connection conn = null;
    ResultSet rs;
    
    public librarian() {
        conn = DBconnect.connect();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConn() {
        return conn;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
    
    public String checkAdmin(String userName, String password) {

        String pass = "";
        String uname = "";
        String id = "";


        boolean errlog = true;

        String sql = "select id, username, password from librarian";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            Check:
            while (rs.next()) {
                id = rs.getString("id");
                uname = rs.getString("userName");
                pass = rs.getString("password");

                if (uname.equalsIgnoreCase(userName) && pass.equalsIgnoreCase(password)) {

                    errlog = false;
                    data.loggedAdminId = id;
                    data.loggedUserName = uname;
                    return "0";
                }

            }

            if (errlog) {
                return "1";
            }

        } catch (SQLException e) {

        }
        return null;

    }

    
    
}
