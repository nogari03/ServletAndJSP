package main.sec01.miniProject.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import main.sec01.miniProject.Login.LoginController;

@WebServlet("/name")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        LoginController.checkLogin(id,password);

//        LoginController controller = new LoginController();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/static/html/page.html");
        rd.forward(request, response);
    }
}
