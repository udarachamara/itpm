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
public class deleteBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        book p1 = new book();

        boolean a1;
        
        p1.setISBN(request.getParameter("isbn"));
        p1.setBookName(request.getParameter("name"));

        a1 = p1.deleteBook(request.getParameter("id"));

        if (a1 == true) {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Delete Successful!')");
            out.println("location = 'manageBook.jsp';");
            out.println("</script>");

        } else {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Delete Unsuccessful!')");
            out.println("location = 'manageBook.jsp';");
            out.println("</script>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
