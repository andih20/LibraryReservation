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
    public String toLogin(@ModelAttribute User user){
        return "user/login";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "user/register";
    }

    @RequestMapping("/toMain")
    public String toMain(@ModelAttribute("user") User user, Model model){

        return "user/main";
    }
}
