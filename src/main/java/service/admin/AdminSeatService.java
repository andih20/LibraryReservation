package service.admin;

import org.springframework.ui.Model;
import pojo.Seat;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AdminSeatService {
    // 到查询界面
    public String ToselectSeat(Integer floor, Model model, Integer pageCur, Map<String, Object> map);

    // 查询损坏座位 (impair 默认为 false)
    public String selectImpairSeat(Model model, Integer pageCur, Map<String, Object> map);
    // 查询空闲且未损坏的座位
    public String selectEmptySeatByFloor(Seat seat, Model model, Integer pageCur, Map<String, Object> map);

    // 添加一个座位
    public String addSeat(Seat seat, Model model);

    // 删除一个座位
    public String deleteSeat(Integer floor, Model model, Integer pageCur, Map<String, Object> map, Seat seat);

    // 更新一个座位信息
    public String updateSeat(Seat seat, Model model, Integer floor, Integer pageCur, Map<String, Object> map);
    public String updateRealSeat(Seat seat, Model model);
}
