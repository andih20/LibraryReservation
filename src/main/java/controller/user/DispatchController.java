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
        user = userService.QueryUser(user);
        session.setAttribute("user",user);
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
    public String toMain(Floor floor,HttpSession session, Model model){
        if(floor.getId() != null){
            floor.setId(floor.getId()); //选页
        }else {
            floor.setId(1); //默认第一页
        }

        List<Seat> seats = seatService.GetAllSeatByFloor(floor);
        User user = (User) session.getAttribute("user");
        user = userService.QueryUser(user);
        model.addAttribute("seats",seats);
        model.addAttribute("floor",floor);
        model.addAttribute("user",user);
        session.setAttribute("user",user);

        return "user/main";
    }


    //去用户个人信息界面
    @RequestMapping("toUser_info")
    public String toUser_info(HttpSession session,Model model, Integer pageCur, String act){
        //找到个人信息
        User user = (User) session.getAttribute("user");
        user = userService.QueryUser(user);
        session.setAttribute("user",user);

        //找到个人记录
        List<Recording> recordings = recordingService.QueryRecordingByUser(user);
        int temp = recordings.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        if (temp == 0) {
            totalPage = 0;//总页数
        } else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp / 10);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 10 > temp) {
            pageCur = pageCur - 1;
        }
        //分页查询
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (pageCur - 1) * 10);//起始位置
        map.put("perPageSize", 10);//每页10个
        map.put("user_id",user.getId());
        recordings = recordingService.selectAllRecordingsByPage(map);
        model.addAttribute("allGoods", recordings);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);
        session.setAttribute("recordings",recordings);

        return "user/user_info";
    }

}
