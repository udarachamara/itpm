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

/**
 *
 * @author Ravinda Wickramasing
 */
public class member {
    
    String name;
    String telephone;
    String address;
    int bookCount;
    String userName;
    String password;

    
    PreparedStatement pst;
    Connection conn = null;
    ResultSet rs;
    
    public member() {
        conn = DBconnect.connect();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public int getBookCount() {
        return bookCount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
    public boolean createProfile(){
        
        try{
            String q = "Insert into member (name, username, password, telephone, address, borrowedBookCount) value('" + getName() + "', '" + getUserName() + "', '" + getPassword() + "','" + getTelephone()+ "', '" + getAddress()+ "',  '" + 0+ "')";
            pst = conn.prepareStatement(q);
            pst.execute();
            return true;
        }
        catch(SQLException e){
            return false;
        }
    }
    
    public String checkUser(String userName, String password) {

        String pass = "";
        String uname = "";
        String id = "";
        String bookCount = "";

        boolean errlog = true;

        String sql = "select id, username, password, borrowedBookCount from member";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            Check:
            while (rs.next()) {
                id = rs.getString("id");
                uname = rs.getString("userName");
                pass = rs.getString("password");
                bookCount = rs.getString("borrowedBookCount");

                if (uname.equalsIgnoreCase(userName) && pass.equalsIgnoreCase(password)) {

                    errlog = false;
                    data.loggedUserId = id;
                    data.loggedUserName = uname;
                    data.loggedUserBookCount = bookCount;
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
