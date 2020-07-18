package main.sec01.Vending;

import com.google.gson.Gson;
import main.sec01.ex01.input;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/vending")
public class VendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        VendDAO dao = new VendDAO();

        String id = request.getParameter("vendId");
        String name = request.getParameter("vendName");
        String address = request.getParameter("vendAddress");
        String city = request.getParameter("vendCity");
        String state = request.getParameter("vendState");
        String zip = request.getParameter("vendPostNo");
        String country = request.getParameter("vendCountry");

        String command = request.getParameter("command");

        out.print(
                "<html><head>" +
                "<style> table, tr, th { border: solid 1px black; }</style>" +
                "</head><body>");


        if("delete".equals(command)){ // 삭제
            dao.deleteVend(id);

        }else if("modify".equals(command)) { // 수정전 페이지
            out.print("<form id=\"addForm\" method=\"get\" action=\"/vending\">" +
                    "공급업체번호 <input type=\"text\" name=\"vendId\"value=\"" + id + "\"><br>" +
                    "공급업체이름 <input type=\"text\" name=\"vendName\"value=\"" + name + "\"><br>" +
                    "공급업체주소 <input type=\"text\" name=\"vendAddress\"value=\"" + address + "\"><br>" +
                    "공급업체 시 <input type=\"text\" name=\"vendCity\"value=\"" + city + "\"><br>" +
                    "공급업체 주 <input type=\"text\" name=\"vendState\"value=\"" + state + "\"><br>" +
                    "공급업체 우편번호 <input type=\"text\" name=\"vendPostNo\"value=\"" + zip + "\"><br>" +
                    "공급업체 국가<input type=\"text\" name=\"vendCountry\"value=\"" + country + "\"><br>"+
                    "<input type=\"hidden\" name=\"command\" value=\"update\">" +
                    "<button id=\"submit\">수정</button>" +
                    "</form>");

        }else if("update".equals(command)){ //수정
            System.out.println("test");
            VendVO vo = new VendVO(id, name, address, city, state, zip, country);
            dao.modifyVend(vo);

        }else if("search".equals(command)) { // 찾기

            List<VendVO> list = dao.searchByVendId(id);

            out.print("<table><tr>" +
                    "<th>공급업체번호</th>" +
                    "<th>공급업체이름</th>" +
                    "<th>공급업체주소</th>" +
                    "<th>공급업체 시</th>" +
                    "<th>공급업체 주</th>" +
                    "<th>공급업체 우편번호</th>" +
                    "<th>공급업체 국가</th>" +
                    "<th><font color=\"red\">수정</font> </th>" +
                    "<th>삭제</th><tr>");

            for (int i = 0; i < list.size(); i++) {
                out.print("<tr>" +
                        "<th>" + list.get(i).getId() + "</th>" +
                        "<th>" + list.get(i).getName() + "</th>" +
                        "<th>" + list.get(i).getAddress() + "</th>" +
                        "<th>" + list.get(i).getCity() + "</th>" +
                        "<th>" + list.get(i).getState() + "</th>" +
                        "<th>" + list.get(i).getZip() + "</th>" +
                        "<th>" + list.get(i).getCountry() + "</th>" +
                        "<th><a href=\"/vending?" +
                        "command=modify&vendId="+
                        list.get(i).getId()+"&vendName="+
                        list.get(i).getName()+"&vendAddress="+
                        list.get(i).getAddress()+"&vendCity="+
                        list.get(i).getCity()+"&vendState="+
                        list.get(i).getState()+"&vendPostNo="+
                        list.get(i).getZip()+"&vendCountry="+
                        list.get(i).getCountry()+"\">수정</a></th>" +
                        "<th><a href=\"/vending?command=delete&vendId=" + list.get(i).getId() + "\">삭제</a></th>" +
                        "</tr>");
            }
            out.print("</table>");
        }out.print("</body></html>");
    }
}
