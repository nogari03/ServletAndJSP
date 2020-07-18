package main.sec01.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public OrderDAO(){
        try{
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<OrderVO> listOrders() {
        List<OrderVO> list = new ArrayList<>();
        try {
            con = dataFactory.getConnection();
            String query = "select * from orders";
            System.out.println("prepareStatement: " + query);
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String num = rs.getString("order_num");
                String date = rs.getString("order_date");
                OrderVO vo = new OrderVO();
                vo.setNum(num);
                vo.setDate(date);
                list.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
