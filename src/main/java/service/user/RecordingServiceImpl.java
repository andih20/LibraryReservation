package service.user;

import dao.user.RecordingDao;
import dao.user.SeatDao;
import dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pojo.Recording;
import pojo.Seat;
import pojo.User;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("RecordingService")
public class RecordingServiceImpl implements RecordingService {
    @Autowired
    private RecordingDao recordingDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SeatDao seatDao;

    //通过用户查找使用记录
    @Override
    public String QueryRecordingByUser(HttpSession session, Model model, Integer pageCur) {
        //找到个人信息
        User user = (User) session.getAttribute("user");

        //找到个人记录
        List<Recording> recordings = recordingDao.queryRecordingByUser(user);
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
        recordings = recordingDao.selectAllRecordingsByPage(map);
        model.addAttribute("allGoods", recordings);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);
        session.setAttribute("recordings",recordings);

        return "user/user_info";
    }

    //增加一个记录信息
    @Override
    public String AddRecording(Recording recording, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Seat seat = (Seat) session.getAttribute("seat");
        //已加入黑名单者，不得预约
        if(user.getBlack()){
            session.setAttribute("black", true);
            return "user/reservation";
        }

        //添加一个记录
        recording.setUser_id(user.getId());
        recording.setSeat_id(seat.getId());
        user.setNumber(user.getNumber()+1); //默认未签到啊，次数+1
        //更新数据库记录
        userDao.updateUser(user);
        recordingDao.addRecording(recording);
        session.setAttribute("recording", recording);
        session.setAttribute("user", user);

        return "user/main";
    }


    //设置该记录出席情况（开始签到）
    @Override
    public String SignRecordingStart(HttpSession session) throws ParseException {
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
        seatDao.setSeatIsempty(seat);

        //设置记录出席
        recording.setPresence(true);
        recording.setEnd_presence(false);
        session.setAttribute("recording",recording);
        recordingDao.signRecording(recording);

        return "user/main";
    }

    //设置该记录出席情况（离开签到）
    @Override
    public String SignRecordingEnd(HttpSession session) {
        //设置座位为空
        Seat seat = (Seat) session.getAttribute("seat");
        seat.setIsempty(true);
        seatDao.setSeatIsempty(seat);

        //正常两次签到,更改用户信息,视为出席
        Recording recording = (Recording) session.getAttribute("recording");
        if(recording.getPresence() && !recording.getEnd_presence()){
            User user = (User) session.getAttribute("user");
            user = userDao.queryUser(user);
            user.setNumber(user.getNumber()-1);
            userDao.updateUser(user);
            session.setAttribute("user",user);
        }

        //设置记录出席
        recording.setEnd_presence(true);
        session.setAttribute("recording",recording);
        recordingDao.signRecording(recording);

        return "user/main";
    }


    //按页查询所有的记录
    @Override
    public List<Recording> selectAllRecordingsByPage(Map<String, Object> map) {
        return recordingDao.selectAllRecordingsByPage(map);
    }
}
