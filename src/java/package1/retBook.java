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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author udara
 */
public class retBook {

    private int id;
    private double amount;
    private Timestamp ddate;
    private String ISBN;
    private String name;

    PreparedStatement pst;
    Connection conn = null;
    ResultSet rs;

    public retBook() {
        conn = DBconnect.connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDdate() {
        return ddate;
    }

    public void setDdate(Timestamp ddate) {
        this.ddate = ddate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

      public ResultSet getreturnList(){

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime ( date ); // convert your date to Calendar object
        int daysToDecrement = -5;
        cal.add(Calendar.DATE, daysToDecrement);
        date = cal.getTime(); // again get back your date object
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String prev_date = dateFormat.format(date); //2016/11/16 12:08:43
        prev_date += " 00:00:00";

        String sql = "SELECT * FROM `borrowedbooks`";


        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.println(rs);
            return rs;
        } catch (SQLException e) {
            return null;
        }
      }
      //to get the amount to pay after exceeding the return date
      public double getDelayAmount(String memberId , String isbn){
        double pAmount = 15.00;
        int delayDate = 0;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime ( date ); // convert your date to Calendar object
        int daysToDecrement = -15;
        cal.add(Calendar.DATE, daysToDecrement);
        date = cal.getTime(); // again get back your date object
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String delay = dateFormat.format(date); //2016/11/16 12:08:43
        delay += " 00:00:00";
          String sql = "SELECT * FROM `borrowedbooks` WHERE borrowedDate <= '"+delay+"' AND memberId = '"+memberId+"' AND isbn = '"+isbn+"' ";

          try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                try{
                    Date ddate = dateFormat.parse(delay);
                }catch(Exception e){

                }

                Date borrowdate = rs.getDate("borrowedDate");
                delayDate = (int) Math.abs(borrowdate.getTime() - borrowdate.getTime());
                //double retAmount = pAmount * delayDate;
            double retAmount = pAmount;
            return retAmount;
            }

        } catch (SQLException e) {

        }
          return 0.0;

      }
      //to delete a book

      public boolean returnBook(int id, String isbn){
         try{
            String sql = "delete from borrowedbooks where id = '"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            String sql2 = "update book b set b.bookCount = b.bookCount + 1 where isbn =  '" + isbn + "'";
            pst = conn.prepareStatement(sql2);
            pst.execute();
            return true;
        }
        catch(SQLException e){
            return false;
        }
      }

}
