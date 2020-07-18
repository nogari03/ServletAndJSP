package main.sec01.Product;

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

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        ProductDAO dao = new ProductDAO();

        String productId = request.getParameter("productId");
        String companyId = request.getParameter("companyId");

        System.out.println(productId);
        System.out.println(companyId);

        List<Product> list;
        //여기 중복코드 없앨것, 널처리 깨끗하게 (로직변경)
        if(productId!=null && companyId.equals("")){
            list = dao.searchByProductNum(productId);
            String json = new Gson().toJson(list);
            out.print(json);
        }else if(companyId!=null && productId.equals("")){
            list = dao.searchByCompanyNum(companyId);
            String json = new Gson().toJson(list);
            out.print(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/servlet/product.html");
        rd.forward(request, response);
    }
}
