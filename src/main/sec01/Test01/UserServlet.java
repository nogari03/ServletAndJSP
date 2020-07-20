package main.sec01.Test01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user01")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        UserController controller = new UserController();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = null;
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String contact = request.getParameter("contact");
        String email = request.getParameter("email");

        String command = request.getParameter("command");

        UserVO vo = new UserVO(id,name,address,city,state,zip,country,contact,email);

        List<UserVO> list = null;

        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;

        if("search".equals(command)){
            list = controller.searchById(id);
        }else if("add".equals(command)) {
            controller.addUser(vo);
        }else if("edit".equals(command)){
            request.setAttribute("UserVO",vo);
            dispatcher = context.getRequestDispatcher("/user01edit.jsp");
            dispatcher.forward(request, response);

            //foward 아래로 흐름 (return 및 로직 수정)
            return;

        }else if("update".equals(command)){
            controller.updateUser(vo);
        }

        request.setAttribute("list",list);

        dispatcher = context.getRequestDispatcher("/user01.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/user01.jsp");
    }
}
