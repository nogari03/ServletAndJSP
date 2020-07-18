package main.sec01.User;

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
    public List<UserVO> listUser(){
        List<UserVO> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String date = rs.getString("date");
                UserVO vo = new UserVO();
                vo.setId(id);
                vo.setPassword(password);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoindate(date);
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
    public List<UserVO> searchUser(String userId){
        List<UserVO> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "select * from t_member where id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,userId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String password = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String date = rs.getString("joindate");
                UserVO vo = new UserVO();
                vo.setId(id);
                vo.setPassword(password);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoindate(date);
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
    public void deleteUser(String id){
        try
        {
            con = dataFactory.getConnection();
            String query = "delete from t_member where id = ?";
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
