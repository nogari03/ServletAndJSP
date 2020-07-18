package main.sec01.ex01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class Calc extends HttpServlet {

    private static float USD_RATE = 1124.70F;
    private static float JPY_RATE = 10.113F;
    private static float CNY_RATE = 163.30F;
    private static float GBP_RATE = 1444.35F;
    private static float EUR_RATE = 1295.97F;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");
        String won = request.getParameter("won");
        String operator = request.getParameter("operator");

        if(command != null && command.equals("calculate"))
        {
            String result = calculate(Float.parseFloat(won),operator);
            out.print("<html><body>");
            out.print("<h1>변환결과</h1>");
            out.print("<h1>"+result+"</h1>");
            out.print("<a href='/calc'>환율 계산기</a>");
            out.print("</body></html>");
        }
    }
    private static String calculate(float won, String operator){
        String result = null;
        if(operator.equals("dollar")){
            result = String.format("%.6f", won / USD_RATE);
        }else if (operator.equals("en")){
            result = String.format("%.6f", won / JPY_RATE);
        }else if (operator.equals("wian")){
            result = String.format("%.6f", won / CNY_RATE);
        }else if (operator.equals("pound")){
            result = String.format("%.6f", won / GBP_RATE);
        }else if (operator.equals("euro")){
            result = String.format("%.6f", won / EUR_RATE);
        }
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/servlet/calc.html");
        rd.forward(request, response);
    }
}
