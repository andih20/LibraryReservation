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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //从数据库中查找用户，判断是否存在
        //并进行跳转页面
        return userService.selectUserForLogin(user,session);
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
        return userService.selectUserForRegister(user);
    }



    //大界面嵌套小界面
    //初始化主界面
    @RequestMapping("newMain")
    public String tonewMain(){
        return "user/newMain";
    }
    //初始化副界面
    @RequestMapping("toMain")
    public String toMain(Floor floor, HttpSession session){
        return seatService.GetAllSeatByFloor(floor,session);
    }



    //去用户个人信息界面
    @RequestMapping("toUser_info")
    public String toUser_info(HttpSession session,Model model, Integer pageCur){
        return recordingService.QueryRecordingByUser(session,model,pageCur);
    }

}
