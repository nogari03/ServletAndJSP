package main.sec01.Test01;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public UserDAO(){
        try{
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<UserVO> listCustomer(){
        List<UserVO> list = new ArrayList<>();
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
                String state = rs.getString("cust_state");
                String zip = rs.getString("cust_zip");
                String country = rs.getString("cust_country");
                String contact = rs.getString("cust_contact");
                String email = rs.getString("cust_email");

                UserVO vo = new UserVO();
                vo.setCust_id(id);
                vo.setCust_name(name);
                vo.setCust_address(address);
                vo.setCust_state(state);
                vo.setCust_zip(zip);
                vo.setCust_country(country);
                vo.setCust_contact(contact);
                vo.setCust_email(email);
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
    public List<UserVO> searchById(String cust_Id){
        List<UserVO> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "select * from CUSTOMERS where CUST_ID LIKE ?";
            pstmt = con.prepareStatement(query);
            String value = "%"+cust_Id+"%";
            pstmt.setString(1,value);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("cust_id");
                String name = rs.getString("cust_name");
                String address = rs.getString("cust_address");
                String state = rs.getString("cust_state");
                String zip = rs.getString("cust_zip");
                String country = rs.getString("cust_country");
                String contact = rs.getString("cust_contact");
                String email = rs.getString("cust_email");

                UserVO vo = new UserVO();
                vo.setCust_id(id);
                vo.setCust_name(name);
                vo.setCust_address(address);
                vo.setCust_state(state);
                vo.setCust_zip(zip);
                vo.setCust_country(country);
                vo.setCust_contact(contact);
                vo.setCust_email(email);
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
    public void addCustomer(UserVO vo){
        try
        {
            con = dataFactory.getConnection();
            String query = "insert into customers" +
                    "(cust_id,cust_name,cust_address,cust_state," +
                    "cust_zip,cust_country,cust_contact,cust_email) " +
                    "values (?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,vo.getCust_id());
            pstmt.setString(2,vo.getCust_name());
            pstmt.setString(3,vo.getCust_address());
            pstmt.setString(4,vo.getCust_state());
            pstmt.setString(5,vo.getCust_zip());
            pstmt.setString(6,vo.getCust_country());
            pstmt.setString(7,vo.getCust_contact());
            pstmt.setString(8,vo.getCust_email());
            pstmt.executeQuery();

            pstmt.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateCustomer(UserVO vo){
        try
        {
            con = dataFactory.getConnection();
            String query = "update customers " +
                    "set cust_id=?,cust_name=?,cust_address=?,cust_state=?, " +
                    "cust_zip=?,cust_country=?,cust_contact=?,cust_email=? where cust_id LIKE ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,vo.getCust_id());
            pstmt.setString(2,vo.getCust_name());
            pstmt.setString(3,vo.getCust_address());
            pstmt.setString(4,vo.getCust_state());
            pstmt.setString(5,vo.getCust_zip());
            pstmt.setString(6,vo.getCust_country());
            pstmt.setString(7,vo.getCust_contact());
            pstmt.setString(8,vo.getCust_email());
            String value = "%"+vo.getCust_id()+"%";
            pstmt.setString(9,value);
            pstmt.executeQuery();

            pstmt.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
