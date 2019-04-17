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
public class addUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        member u = new member();
        boolean a;

        u.setName(request.getParameter("name"));
        u.setAddress(request.getParameter("address"));
        u.setTelephone(request.getParameter("phone"));
        u.setUserName(request.getParameter("userName"));
        u.setPassword(request.getParameter("password"));

        a = u.createProfile();
        if (a == true) {

            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('User Add Succesful');");
            out.println("location = 'index.jsp';");
            out.println("</script>");
        } else {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("confirm('User Add Unsuccesful');");
            out.println("location = 'addUser.jsp';");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
