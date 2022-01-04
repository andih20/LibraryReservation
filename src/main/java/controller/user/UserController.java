package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.user.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    //跳转更新信息界面
    @RequestMapping("toUpdateUser")
    public String toUpdateUser(){
        return "user/updateUser";
    }
    //用户修改个人信息，返回主界面
    @RequestMapping("updateUser")
    public String updateUser(@ModelAttribute("user") User new_user, HttpSession session){
        //设置新值
        User user = (User) session.getAttribute("user");
        user.setUname(new_user.getUname());
        user.setUpassword(new_user.getUpassword());
        user.setUemail(new_user.getUemail());
        //更新用户信息
        userService.updateUser(user);
        session.setAttribute("user",user);
        return "user/main";
    }


    //跳转到注销界面
    @RequestMapping("toDeleteUser")
    public String toDeleteUser(){
        return "user/deleteUser";
    }
    //用户注销，返回登录界面
    @RequestMapping("deleteUser")
    public String deleteUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        return userService.deleteUser(user);
    }


    //用户退出，返回登录界面
    @RequestMapping("toQiut")
    public String toQuit(HttpSession session){
        //移除user，拦截器监听user是否存在
        //如果user存在，则返回主界面
        //如果user不存在，则返回登录界面
        session.removeAttribute("user");
        return "user/main";
    }
}
