/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class book {
    
    String id;
    String ISBN;
    String bookName;
    String author;
    int bookCount;
    
    PreparedStatement pst;
    Connection conn = null;
    ResultSet rs;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    public book() {
        conn = DBconnect.connect();
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    

    public String getISBN() {
        return ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookCount() {
        return bookCount;
    }

    public String getAuthor() {
        return author;
    }
    
    public ResultSet searchBook(){
        
        String sql = "Select * From book Where bookCount > 0";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }

    }
    
    public ResultSet getNewBookList(){
        
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime ( date ); // convert your date to Calendar object
        int daysToDecrement = -5;
        cal.add(Calendar.DATE, daysToDecrement);
        date = cal.getTime(); // again get back your date object
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String prev_date = dateFormat.format(date); //2016/11/16 12:08:43
        prev_date += " 00:00:00"; 
        
        String sql = "SELECT * FROM `book` WHERE create_at > '"+prev_date+"' ORDER by `create_at` DESC LIMIT 5";
        System.out.println(sql);
    
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }

    }
    

    
    public boolean addBook(){
        try{
            String q = "Insert into book (isbn, name, author, bookCount) values('" + getISBN()+ "', '" + getBookName() + "', '" + getAuthor()+ "','" + getBookCount()+ "')";
            //String q2 = "Insert into new_book (isbn, name, author) values('" + getISBN()+ "', '" + getBookName() + "', '" + getAuthor()+ "')";
            pst = conn.prepareStatement(q);
            pst.execute();
            return true;
        }
        catch(SQLException e){
            return false;
        }
    
    }
    
    public boolean updateBook(String id){
        
        try {
            String q = "Update book set isbn = '" + ISBN + "', name = '" + bookName + "', author = '" + author + "', bookCount = '" + bookCount + "' where id = '" + id + "'";
            pst = conn.prepareStatement(q);
            pst.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean deleteBook(String id){
        
        try{
            String sql = "delete from book where id = '"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            return true;
        }
        catch(SQLException e){
            return false;
        }
    }
    public ResultSet searchMember(int id){
        
        String sql = "Select * From member where id = '"+id+"'";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }

    } 
    
    public int issueBook(String memberId){
        
        try{
            String bbsql = "select borrowedBookCount from member where id = '"+memberId+"'";
            pst = conn.prepareStatement(bbsql);
            rs = pst.executeQuery();
            
            int bbcount;
            
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date dateobj = new Date();
            
            String currentDate = df.format(dateobj);
            
            while(rs.next()){
                
                bbcount = Integer.parseInt(rs.getString("borrowedBookCount"));
                
                if((bbcount<3)&&(bbcount>=0)){
                
             
                    String sql1 = "Insert into borrowedBooks (bookId, memberId, librarianid, borrowedDate) values ('" + id + "','" + memberId + "','" + data.loggedAdminId + "' , '"+currentDate+"')";
                    pst = conn.prepareStatement(sql1);
                    pst.execute();

                    String sql2 = "update book b set b.bookCount = b.bookCount - 1 where id =  '" + id + "'";
                    pst = conn.prepareStatement(sql2);
                    pst.execute();

                    String sql3 = "update member m set m.borrowedBookCount = m.borrowedBookCount + 1 where id = '"+memberId+"'";
                    pst = conn.prepareStatement(sql3);
                    pst.execute();

                    return 1;
                
                    
                }
                else{
                    return 2;
                }
            }
            

            
        }
        catch(NumberFormatException | SQLException e){
            return 3;
        }
        return 4;
        
        
        
    }
    
    
}
