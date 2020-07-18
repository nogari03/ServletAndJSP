package main.sec01.User;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        UserDAO dao = new UserDAO();

        String input = request.getParameter("id");
        String delete = request.getParameter("delete");

        List<UserVO> list;
        if(input!=null & delete==null){
            list = dao.searchUser(input);
            String json = new Gson().toJson(list);
            out.print(json);
        }else if(input==null & delete!=null){
            dao.deleteUser(delete);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/servlet/user.html");
        rd.forward(request, response);
    }
}
