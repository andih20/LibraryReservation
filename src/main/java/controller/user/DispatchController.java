package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Floor;
import pojo.Recording;
import pojo.Seat;
import pojo.User;
import service.user.RecordingService;
import service.user.SeatService;
import service.user.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DispatchController {
    @Autowired
    private UserService userService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private RecordingService recordingService;

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
        Floor floor = new Floor();
        //默认起始页为第一页
        Integer lay = (Integer) session.getAttribute("lay");
        if(lay != null){
            floor.setId(lay); //选页
        }else {
            floor.setId(1); //默认第一页
        }

        List<Seat> seats = seatService.GetAllSeatByFloor(floor);
        user = (User) session.getAttribute("user");
        model.addAttribute("seats",seats);
        model.addAttribute("floor",floor);
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

        //找到个人记录
        List<Recording> recordings = recordingService.QueryRecordingByUser(user);
        session.setAttribute("recordings",recordings);

        return "user/user_info";
    }
}
