package main.sec01.miniProject.Login;

public class LoginController {

    LoginDAO dao = new LoginDAO();
    LoginDTO dto = new LoginDTO();

    public static boolean checkLogin(String id,String password){
        if(id!=null && password!=null){
            return false;
        }
        return true;
    }

    public 
}
