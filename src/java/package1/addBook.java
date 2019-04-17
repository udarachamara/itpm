/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ravinda Wickramasing
 */
public class addBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        book u = new book();
        boolean a;

        u.setISBN(request.getParameter("isbn"));
        u.setBookName(request.getParameter("name"));
        u.setAuthor(request.getParameter("author"));
        u.setBookCount(Integer.parseInt(request.getParameter("count")));
        

        a = u.addBook();
        if (a == true) {

            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Book Add Succesful');");
            out.println("location = 'addBook.jsp';");
            out.println("</script>");
        } else {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Book Add Unsuccesful');");
            out.println("location = 'addBook.jsp';");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
