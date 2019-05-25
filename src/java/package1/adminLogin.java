/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ravinda Wickramasing
 */
public class adminLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        librarian u = new librarian();
        Encription en = new Encription();

        String a;
        String password = en.crypt(request.getParameter("password"));

        u.setUserName(request.getParameter("userName"));
        u.setPassword(password);

        a = u.checkAdmin(u.getUserName(), u.getPassword());

        if (a.equals("1")) {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Wrong User Name or Password!')");
            out.println("location = 'login.jsp';");
            out.println("</script>");

        } else if (a.equals("0")) {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('Successfully logged In!')");
            out.println("location = 'index.jsp';");
            out.println("</script>");

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
