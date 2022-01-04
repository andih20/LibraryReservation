package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
import java.util.Date;

@Controller
public class ReservationController {
    @Autowired
    private UserService userService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private RecordingService recordingService;

    //开始签到
    //初始化扫码界面
    @RequestMapping("toSign")
    public String toSign(){
        return "user/sign";
    }
    //扫码操作
    @RequestMapping("sign")
    public String sign(HttpSession session) throws ParseException {
        Recording recording = (Recording) session.getAttribute("recording");
        Seat seat = (Seat) session.getAttribute("seat");

        //判断是否迟到
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        Date start_time = dateFormat.parse(recording.getStart_time());
        if (curDate.before(start_time)){
            //已经迟到
            session.setAttribute("late", true);
            return "user/sign";
        }
//        if(curDate.getTime()-start_time.getTime()>0)

        //设置座位不为空
        seat.setIsempty(false);
        seatService.SetSeatIsempty(seat);

        //设置记录出席
        recording.setPresence(true);
        recording.setEnd_presence(false);
        session.setAttribute("recording",recording);
        recordingService.SignRecording(recording);

        return "user/main";
    }

    //离开签到
    //初始化扫码界面
    @RequestMapping("toLeave")
    public String toLeave(){
        return "user/leave";
    }
    //扫码操作
    @RequestMapping("leave")
    public String leave(HttpSession session){
        //设置座位为空
        Seat seat = (Seat) session.getAttribute("seat");
        seat.setIsempty(true);
        seatService.SetSeatIsempty(seat);

        //正常两次签到,更改用户信息
        Recording recording = (Recording) session.getAttribute("recording");
        if(recording.getPresence() && !recording.getEnd_presence()){
            User user = (User) session.getAttribute("user");
            user = userService.QueryUser(user);
            user.setNumber(user.getNumber()-1);
            userService.updateUser(user);
            session.setAttribute("user",user);
        }

        //设置记录出席
        recording.setEnd_presence(true);
        session.setAttribute("recording",recording);
        recordingService.SignRecording(recording);

        return "user/main";
    }


    //初始化预约界面
    @RequestMapping("toReservation")
    public String toReservation(@ModelAttribute("recording")Recording recording, String id, HttpSession session){
        Seat seat = seatService.GetSeatById(Integer.parseInt(id));
        session.setAttribute("seat",seat);
        return "user/reservation";
    }
    //处理预约
    @RequestMapping("reservation")
    public String reservation(@ModelAttribute("recording") Recording recording, User user, HttpSession session){
        user = (User) session.getAttribute("user");
        //已加入黑名单者，不得预约
        if(user.getBlack()){
            session.setAttribute("black", true);
            return "user/reservation";
        }

        //添加一个记录
        user = (User) session.getAttribute("user");
        Seat seat = (Seat) session.getAttribute("seat");
        recording.setUser_id(user.getId());
        recording.setSeat_id(seat.getId());
        user.setNumber(user.getNumber()+1);
        userService.updateUser(user);
        recordingService.AddRecording(recording);
        session.setAttribute("recording", recording);
        session.setAttribute("user",user);

        return "user/main";
    }
}
