package main.sec01.Vending;

import main.sec01.User.UserVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public VendDAO(){
        try{
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<VendVO> searchByVendId(String vendId){
        List<VendVO> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "select * from vendors where vend_id LIKE ?";
            pstmt = con.prepareStatement(query);
            String value= "%"+vendId+"%";
            pstmt.setString(1, value);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("vend_id");
                String name = rs.getString("vend_name");
                String address = rs.getString("vend_address");
                String city = rs.getString("vend_city");
                String state = rs.getString("vend_state");
                String zip = rs.getString("vend_zip");
                String country = rs.getString("vend_country");

                VendVO vo = new VendVO();
                vo.setId(id);
                vo.setName(name);
                vo.setAddress(address);
                vo.setCity(city);
                vo.setState(state);
                vo.setZip(zip);
                vo.setCountry(country);

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
    public void modifyVend(VendVO vo){
        System.out.println(vo);
        List<UserVO> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query =
                    "update vendors set vend_id=?, vend_name=?, vend_address=?, vend_city=?, vend_state=?, vend_zip=?, vend_country=? where vend_id LIKE ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getName());
            pstmt.setString(3,vo.getAddress());
            pstmt.setString(4,vo.getCity());
            pstmt.setString(5,vo.getState());
            pstmt.setString(6,vo.getZip());
            pstmt.setString(7,vo.getCountry());

            String value = "%"+vo.getId()+"%";
            pstmt.setString(8,value);
            pstmt.executeQuery();
//            ResultSet rs = pstmt.executeQuery();
//            while(rs.next()){
//                return 1;
//            }
//            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
//        return 0;
    }
    public void deleteVend(String id){
        try
        {
            con = dataFactory.getConnection();
            String query = "delete from vendors where vend_id LIKE ?";
            pstmt = con.prepareStatement(query);
            String value= "%"+id+"%";
            pstmt.setString(1, value);
            pstmt.executeQuery();

            pstmt.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
