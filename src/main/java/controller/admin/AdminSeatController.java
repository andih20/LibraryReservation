package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Seat;
import service.admin.AdminSeatService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/adminSeat")
public class AdminSeatController {
    @Autowired
    private AdminSeatService adminSeatService;

    @RequestMapping("/ToselectSeat")
    public String ToselectSeat(Integer floor, Model model, Integer pageCur, Map<String, Object> map){
        return adminSeatService.ToselectSeat(floor, model, pageCur, map);
    }

    @RequestMapping("/selectImpairSeat")
    public String selectImpairSeat(Model model, Integer pageCur, Map<String, Object> map){
        return adminSeatService.selectImpairSeat(model, pageCur, map);
    }
    @RequestMapping("/selectEmptySeatByFloor")
    public String selectEmptySeatByFloor(Seat seat, Model model, Integer pageCur, Map<String, Object> map){
        return adminSeatService.selectEmptySeatByFloor(seat, model, pageCur, map);
    }

    // 增加座位
    @RequestMapping("/addSeat")
    public String addSeat(Seat seat, Model model){
        return adminSeatService.addSeat(seat, model);
    }

    // 删除座位
    @RequestMapping("/deleteSeat")
    public String deleteSeat(Integer floor, Model model, Integer pageCur, Map<String, Object> map, Seat seat){
        return adminSeatService.deleteSeat(floor, model, pageCur, map, seat);
    }

    // 更新座位信息
    @RequestMapping("/updateSeat")
    public String updateSeat(Seat seat, Model model, Integer floor, Integer pageCur, Map<String, Object> map){
        return adminSeatService.updateSeat(seat, model, floor, pageCur, map);
    }
    @RequestMapping("/updateRealSeat")
    public String updateRealSeat(Seat seat, Model model){
        return adminSeatService.updateRealSeat(seat, model);
    }

}
