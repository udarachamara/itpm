/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ravinda Wickramasing
 */
public class returnBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        retBook p1 = new retBook();

        boolean a1, a2;
        
        p1.setId(parseInt(request.getParameter("id")));
        p1.setISBN(request.getParameter("id"));
        
        a1 = p1.returnBook(parseInt(request.getParameter("id")),request.getParameter("isbn"));

        if (a1 == true) {
            
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Update Successful!')");
            out.println("location = 'returnbooks.jsp';");
            out.println("</script>");
           

        } else {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Update Unsuccessful!')");
            out.println("location = 'returnbooks.jsp';");
            out.println("</script>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
