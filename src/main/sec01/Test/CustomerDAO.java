package main.sec01.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

        private Connection con;
        private PreparedStatement pstmt;
        private DataSource dataFactory;

        public CustomerDAO(){
            try{
                Context ctx = new InitialContext();
                Context envContext = (Context) ctx.lookup("java:/comp/env");
                dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public List<CustomerVO> listCustomer(){
            List<CustomerVO> list = new ArrayList<>();
            try
            {
                con = dataFactory.getConnection();
                String query = "select * from customers";
                pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    String id = rs.getString("cust_id");
                    String name = rs.getString("cust_name");
                    String address = rs.getString("cust_address");
                    CustomerVO vo = new CustomerVO();
                    vo.setId(id);
                    vo.setName(name);
                    vo.setAddress(address);
                    list.add(vo);
                }
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
        public List<CustomerVO> searchCustomer(String userId){
            List<CustomerVO> list = new ArrayList<>();
            try
            {
                con = dataFactory.getConnection();
                String query = "select * from CUSTOMERS where CUST_ID = ?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1,userId);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    String id = rs.getString("cust_id");
                    String name = rs.getString("cust_name");
                    String address = rs.getString("cust_address");
                    CustomerVO vo = new CustomerVO();
                    vo.setId(id);
                    vo.setName(name);
                    vo.setAddress(address);
                    list.add(vo);
                }
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
        public void deleteCustomer(String id){
            try
            {
                con = dataFactory.getConnection();
                String query = "delete from customers where cust_id = ?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1,id);
                pstmt.executeQuery();

                pstmt.close();
                con.close();
            } catch (Exception e){
                e.printStackTrace();
            }
    }
}
