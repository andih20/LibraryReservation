package service.admin;

import org.springframework.ui.Model;
import pojo.Seat;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AdminSeatService {
    // 到查询界面
    public String ToselectSeat(Integer floor, Model model, HttpSession session, Integer pageCur);
    // 查询座位
    // public String selectSeat(Integer floor, Model model, HttpSession session);
    // 查询损坏座位 (impair 默认为 false)
    public String selectImpairSeat(Model model, Integer pageCur, Map<String, Object> map);
    // 查询空闲且未损坏的座位
    public String selectEmptySeatByFloor(Seat seat, Model model);
    // 分页查询座位
    public String selectSeatByPage(Model model, Integer pageCur, HttpSession session);

}
