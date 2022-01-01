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

}
