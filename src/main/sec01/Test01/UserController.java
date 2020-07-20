package main.sec01.Test01;

import java.util.List;

public class UserController {

    private UserDAO dao = new UserDAO();
    private UserVO vo = new UserVO();

    public boolean checkUserId(String id){
        List<UserVO> list = dao.searchById(id);

        if(list==null){
            return false;
        }
        return true;
    }

    public List<UserVO> printList(String id){
        List<UserVO> list = dao.listCustomer();
        return list;
    }

    public List<UserVO> searchById(String id){
        List<UserVO> list = dao.searchById(id);
        return list;
    }

    public void addUser(UserVO vo){
        dao.addCustomer(vo);
    }

    public void updateUser(UserVO vo){
        dao.updateCustomer(vo);
    }
}
