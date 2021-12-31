package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Floor;
import pojo.Seat;
import pojo.User;
import service.user.SeatService;
import service.user.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class DispatchController {
    @Autowired
    private UserService userService;
    @Autowired
    private SeatService seatService;

    //登录界面初始化
    @RequestMapping("/toLogin")
    public String toLogin(@ModelAttribute("user") User user){
        return "user/login";
    }
    //处理登录功能
    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user,HttpSession session){
        session.setAttribute("user",user);
        //从数据库中查找用户，判断是否存在
        user = userService.QueryUser(user);
        if(user!=null){
            //已存在，则正常跳转
            return "user/main";
        }else {
            //未存在则返回登录界面
            return  "user/login";
        }
    }


    //初始化注册界面
    @RequestMapping("toRegister")
    public String toRegister(@ModelAttribute("user") User user){
        return "user/register";
    }
    //处理注册功能
    @RequestMapping("register")
    public String register(@ModelAttribute("user") User user){
        //从数据库中查找用户，判断是否存在
        User temp_user = userService.QueryUserByEmail(user);
        if(temp_user!=null){
            //已存在，则重新输入
            return "user/register";
        }else {
            //未存在，则正常注册
            userService.AddUser(user);
            return "user/login";
        }
    }


    //初始化主界面
    @RequestMapping("toMain")
    public String toMain(User user,HttpSession session, Model model){
        //获取所有座位的使用情况
        String lay = session.getAttribute("lay").toString();
        Floor floor = new Floor();
        if(Objects.equals(lay, "")){
            floor.setId(1); //默认第一页
        }else {
            floor.setId(Integer.parseInt(lay)); //选页
        }
        List<Seat> seats = seatService.GetAllSeatByFloor(floor);
        model.addAttribute("seats",seats);
        model.addAttribute("floor",floor);
        user = (User) session.getAttribute("user");
        model.addAttribute("user",user);

        return "user/main";
    }


    @RequestMapping("toReservation")
    public String toReservation(){

        return "user/reservation";
    }

    @RequestMapping("toUser_info")
    public String toUser_info(HttpSession session){
        //找到个人信息
        User user = (User) session.getAttribute("user");
        user = userService.QueryUser(user);
        session.setAttribute("user",user);
        return "user/user_info";
    }
}
