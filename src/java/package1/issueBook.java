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
public class issueBook extends HttpServlet {

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

        int a1;
        
        p1.setId(request.getParameter("bookId"));
        
        
        a1 = p1.issueBook(request.getParameter("memberId"));

        switch (a1) {
            case 1:
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("confirm('Book Issued!')");
                out.println("location = 'issueBook.jsp';");
                out.println("</script>");
                break;
            case 2:
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("confirm('Borrowed Book Count is at limit. Can't issue!')");
                out.println("location = 'issueBook.jsp';");
                out.println("</script>");
                break;
            case 3:
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("confirm('Book Issue Unsuccessful!')");
                out.println("location = 'issueBook.jsp';");
                out.println("</script>");
                break;
            case 4:
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("confirm('Unsuccessful!')");
                out.println("location = 'issueBook.jsp';");
                out.println("</script>");
                break;
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
