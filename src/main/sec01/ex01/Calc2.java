package main.sec01.ex01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String operator = request.getParameter("operator");

        if(command != null && command.equals("calculate"))
        {
            String result = calculate(Float.parseFloat(first),Float.parseFloat(second),operator);
            out.print("<html><body>");
            out.print("<h1>정답은 "+result+" 입니다</h1>");
            out.print("<a href='/calc2'>계산하기로 이동</a>");
            out.print("</body></html>");
        }
    }
    private static String calculate(float first, float second, String operator){
        String result = null;
        if(operator.equals("plus")){
            result = String.format("%.0f", first + second);
        }else if (operator.equals("minus")){
            result = String.format("%.0f", first - second);
        }else if (operator.equals("multi")){
            result = String.format("%.0f", first * second);
        }else if (operator.equals("div")){
            result = String.format("%.3f", first / second);
        }
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/servlet/calc2.html");
        rd.forward(request, response);
    }
}
