package service.admin;

import dao.admin.AdminSeatDao;
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
    public String ToselectSeat(Integer floor, Model model, HttpSession session, Integer pageCur) {
        Map map = (Map<String, Object>) session.getAttribute("map");
        model.addAttribute("SelectAllSeatInfo",adminSeatDao.selectAllSeatByPage(map));

        map.put("floor", floor);
        model.addAttribute("floor", floor);

        model.addAttribute("SelectFloorInfo", adminSeatDao.selectAllSeatByFloorANDPage(map));
        if(adminSeatDao.selectAllSeatByFloorANDPage(map).size()!=0) {
            List<Seat> allSeat = adminSeatDao.selectSeatByFloor(floor);
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

            model.addAttribute("allSeat", allSeat);
            model.addAttribute("totalPage", totalPage);
            model.addAttribute("pageCur", pageCur);
            model.addAttribute("SelectFloorInfo", adminSeatDao.selectAllSeatByFloorANDPage(map));
        }
        if(adminSeatDao.selectAllSeatByFloorANDPage(map).size()!=0){
            model.addAttribute("SelectseatExitmsg","已找到");
        }
        return "admin/selectSeat";
    }

//    @Override
//    public String selectSeat(Integer floor, Model model, HttpSession session) {
//        Map map = (Map<String, Object>) session.getAttribute("map");
//        model.addAttribute("SelectAllSeatInfo",adminSeatDao.selectAllSeatByPage(map));
//        map.put("floor", floor);
//        if (adminSeatDao.selectAllSeatByFloor(map).size()>0){
//            model.addAttribute("SelectFloormsg", "座位查找成功！");
//        }
//        // 返回查询座位界面
//        return "forward:/adminUser/ToselectSeat";
//    }

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
    public String selectEmptySeatByFloor(Seat seat, Model model) {
        model.addAttribute("SelectAllSeatInfo",adminSeatDao.selectAllSeat());
        model.addAttribute("SelectEmptyFloorInfo", adminSeatDao.selectEmptySeatByFloor(seat));
        if(adminSeatDao.selectEmptySeatByFloor(seat).size()!=0){
            model.addAttribute("SelectEmptyFloorExitmsg","已找到空位置");
        }
        // 返回查询座位界面
        return "admin/selectEmptySeat";
    }

    @Override
    public String selectSeatByPage(Model model, Integer pageCur, HttpSession session) {
        List<Seat> allSeat = adminSeatDao.selectAllSeat();
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
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (pageCur - 1) * 4); //起始位置
        map.put("perPageSize", 4); //每页 4 个
        model.addAttribute("allSeat", allSeat);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);
        session.setAttribute("map", map);

        return "forward:/adminSeat/ToselectSeat";
    }


}
