package service.admin;

import dao.admin.AdminSeatDao;
import jdk.nashorn.internal.ir.IdentNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Seat;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminSeatService")
@Transactional
public class AdminSeatServiceImpl implements AdminSeatService {
    @Autowired
    private AdminSeatDao adminSeatDao;

    @Override
    public String ToselectSeat(Integer floor, Model model, Integer pageCur, Map<String, Object> map) {
        List<Seat> allSeat = adminSeatDao.selectAllSeat();
        model.addAttribute("AllSeat",adminSeatDao.selectAllSeat());
        model.addAttribute("SelectSeatInfoByFloor",adminSeatDao.selectSeatByFloor(floor));
        if(adminSeatDao.selectSeatByFloor(floor).size()!=0) {
            allSeat = adminSeatDao.selectSeatByFloor(floor);
        }
        int temp = allSeat.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        if (temp == 0) {
            totalPage = 0;//总页数
        } else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp / 4);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 4 > temp) {
            pageCur = pageCur - 1;
        }
        // 分页查询
        map.put("startIndex", (pageCur - 1) * 4); //起始位置
        map.put("perPageSize", 4); //每页 4 个;
        model.addAttribute("SelectAllSeatInfo",adminSeatDao.selectAllSeatByPage(map));

        model.addAttribute("allSeat", allSeat);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);

        map.put("floor", floor);
        model.addAttribute("floor", floor);

        if(adminSeatDao.selectSeatByFloor(floor).size()!=0){
            if(adminSeatDao.selectAllSeatByPage(map).size()!=0){
                model.addAttribute("SelectseatExitmsg","已找到");
                model.addAttribute("SelectFloorInfo",adminSeatDao.selectAllSeatByFloorANDPage(map));
            }

            model.addAttribute("SelectEmptyFloorExitmsg","已找到空位置");
        }
        return "admin/selectSeat";
    }


    @Override
    public String selectImpairSeat(Model model, Integer pageCur, Map<String, Object> map) {
        model.addAttribute("SelectAllImpairFloorInfo", adminSeatDao.selectImpairSeat());
        if(adminSeatDao.selectImpairSeat().size()>0){
            List<Seat> allSeat = adminSeatDao.selectImpairSeat();
            int temp = allSeat.size();
            model.addAttribute("totalCount", temp);
            int totalPage = 0;
            if (temp == 0) {
                totalPage = 0;//总页数
            } else {
                //返回大于或者等于指定表达式的最小整数
                totalPage = (int) Math.ceil((double) temp / 4);
            }
            if (pageCur == null) {
                pageCur = 1;
            }
            if ((pageCur - 1) * 4 > temp) {
                pageCur = pageCur - 1;
            }
            // 分页查询
            map.put("startIndex", (pageCur - 1) * 4); //起始位置
            map.put("perPageSize", 4); //每页 4 个
            model.addAttribute("allSeat", allSeat);
            model.addAttribute("totalPage", totalPage);
            model.addAttribute("pageCur", pageCur);
            if(adminSeatDao.selectAllImpairSeat(map).size()!=0){
                model.addAttribute("SelectImpairseatExitmsg","已找到");
                model.addAttribute("SelectImpairFloorInfo",adminSeatDao.selectAllImpairSeat(map));
            }
        }

        // 返回查询座位界面
        return "admin/selectImpairSeat";
    }

    @Override
    public String selectEmptySeatByFloor(Seat seat, Model model, Integer pageCur, Map<String, Object> map) {
        model.addAttribute("SelectAllSeatInfo",adminSeatDao.selectAllSeat());
        model.addAttribute("SelectAllEmptySeatInfo",adminSeatDao.selectEmptySeatByFloor(seat));

        List<Seat> allSeat = adminSeatDao.selectAllSeat();
        if(adminSeatDao.selectEmptySeatByFloor(seat).size()!=0) {
            allSeat = adminSeatDao.selectEmptySeatByFloor(seat);
        }
        int temp = allSeat.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        if (temp == 0) {
            totalPage = 0;//总页数
        } else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp / 4);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 4 > temp) {
            pageCur = pageCur - 1;
        }
        // 分页查询
        map.put("startIndex", (pageCur - 1) * 4); //起始位置
        map.put("perPageSize", 4); //每页 4 个
        model.addAttribute("SelectAllSeatInfoByPage",adminSeatDao.selectAllSeatByPage(map));
        model.addAttribute("allSeat", allSeat);
        map.put("floor", seat.getFloor());
        model.addAttribute("floor", seat.getFloor());
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);
        if(adminSeatDao.selectEmptySeatByFloor(seat).size()!=0){
            if(adminSeatDao.selectEmptySeatByFloorANDPage(map).size()!=0){
                model.addAttribute("SelectEmptyseatExitmsg","已找到");
                model.addAttribute("SelectEmptyFloorInfo",adminSeatDao.selectEmptySeatByFloorANDPage(map));
            }

            model.addAttribute("SelectEmptyFloorExitmsg","已找到空位置");
        }
        // 返回查询座位界面
        return "admin/selectEmptySeat";
    }



}
