package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private SeatService seatService;
    @Autowired
    private RecordingService recordingService;

    //初始化预约界面
    @RequestMapping("toReservation")
    public String toReservation(@ModelAttribute("recording")Recording recording, String id, HttpSession session){
        Seat seat = seatService.GetSeatById(Integer.parseInt(id));
        session.setAttribute("seat",seat);
        return "user/reservation";
    }
    //处理预约
    @RequestMapping("reservation")
    public String reservation(@ModelAttribute("recording") Recording recording, HttpSession session){
        return recordingService.AddRecording(recording,session);
    }


    //开始签到
    //初始化扫码界面
    @RequestMapping("toSign")
    public String toSign(){
        return "user/sign";
    }
    //扫码操作
    @RequestMapping("sign")
    public String sign(HttpSession session) throws ParseException {
        return recordingService.SignRecordingStart(session);
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
        return recordingService.SignRecordingEnd(session);
    }
}
