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
    public String updateUser(@ModelAttribute("User") User user, HttpSession session){
        //设置新值
        User new_user = (User) session.getAttribute("user");
        new_user.setUname(user.getUname());
        new_user.setUpassword(user.getUpassword());
        new_user.setUemail(user.getUemail());
        //更新用户信息
        userService.updateUser(new_user);
        session.setAttribute("user",new_user);
        return "user/main";
    }


    //跳转到注销界面
    @RequestMapping("toDeleteUser")
    public String toDeleteUser(){
        return "user/deleteUser";
    }
    //用户注销，返回登录界面
    @RequestMapping("deleteUser")
    public String deleteUser(@ModelAttribute("user") User user,HttpSession session){
        user = (User) session.getAttribute("user");
        return userService.deleteUser(user);
    }


    //用户退出，返回登录界面
    @RequestMapping("toQuit")
    public String toQuit(@ModelAttribute("user") User user,HttpSession session){
        //移除user，拦截器监听user是否存在
        //如果user存在，则返回主界面
        //如果user不存在，则返回登录界面
//        session.invalidate();
//        session.setAttribute("user",null);
        session.removeAttribute("user");
        return "user/login";
    }
}
