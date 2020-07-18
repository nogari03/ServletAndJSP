package main.sec01.Product;

import main.sec01.Test.CustomerVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public ProductDAO(){
        try{
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 여기에도 로직 합쳐야 하나? 메소드안에서 sql만 바꿔서 날릴수 있도록 짜는건 어떨지 생각해보자
    public List<Product> searchByProductNum(String productId){
        List<Product> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "SELECT * FROM products WHERE prod_id LIKE ?";
            pstmt = con.prepareStatement(query);
            String value = productId+"%";
            pstmt.setString(1, value);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String prodId = rs.getString("prod_id");
                String vendId = rs.getString("vend_id");
                String prodName = rs.getString("prod_name");
                String price = rs.getString("prod_price");
                String desc = rs.getString("prod_desc");
                Product vo = new Product();
                vo.setProdId(prodId);
                vo.setVendId(vendId);
                vo.setProdName(prodName);
                vo.setPrice(price);
                vo.setDesc(desc);
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

    public List<Product> searchByCompanyNum(String companyId){
        List<Product> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "SELECT * FROM products WHERE vend_id LIKE ?";
            pstmt = con.prepareStatement(query);
            String value = companyId+"%";
            pstmt.setString(1, value);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String prodId = rs.getString("prod_id");
                String vendId = rs.getString("vend_id");
                String prodName = rs.getString("prod_name");
                String price = rs.getString("prod_price");
                String desc = rs.getString("prod_desc");
                Product vo = new Product();
                vo.setProdId(prodId);
                vo.setVendId(vendId);
                vo.setProdName(prodName);
                vo.setPrice(price);
                vo.setDesc(desc);
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
}
