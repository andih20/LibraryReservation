package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.user.UserService;

@Controller
public class DispatchController {
    @Autowired
    private UserService userService;


    @RequestMapping("/toLogin")
    public String toLogin(@ModelAttribute("user") User user){
        return "user/login";
    }

    @RequestMapping("toRegister")
    public String toRegister(@ModelAttribute("new_user") User new_user){
        //-------------拦截器-----------
//        if(new_user!=null){
//            //从数据库中查找用户，判断是否存在
//            User user = userService.QueryUserByEmail(new_user);
//            if(user!=null){
//                //已存在，则重新输入
//                return "user/register";
//            }else {
//                //未存在，则正常注册
//                userService.AddUser(new_user);
//                return "user/login";
//            }
//        }
        //-----------------------------
        return "user/register";
    }

    @RequestMapping("/toMain")
    public String toMain(@ModelAttribute("user") User user, Model model){
        model.addAttribute("user",user);

        //-------------拦截器-----------
        //从数据库中查找用户，判断是否存在
        user = userService.QueryUser(user);
        if(user!=null){
            //已存在，则正常跳转
            return "user/main";
        }else {
            //未存在则返回登录界面
            return  "user/login";
        }
        //-----------------------------

        //获取所有座位的使用情况

    }

    @RequestMapping("toReservation")
    public String toReservation(){

        return "user/reservation";
    }

    @RequestMapping("toUser_info")
    public String toUser_info(){

        return "user/user_info";
    }
}
