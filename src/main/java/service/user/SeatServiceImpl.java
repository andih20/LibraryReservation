package service.user;

import com.mysql.cj.Session;
import dao.user.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Floor;
import pojo.Seat;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("seatService")
public class SeatServiceImpl implements SeatService{
    @Autowired
    private SeatDao seatDao;

    //通过楼层查找所有座位
    @Override
    public String GetAllSeatByFloor(Floor floor,HttpSession session) {
        if(floor.getId() != null){
            floor.setId(floor.getId()); //选层数
        }else {
            floor.setId(1); //默认第一层
        }

        List<Seat> seats = seatDao.getAllSeatByFloor(floor);
        session.setAttribute("seats",seats);
        session.setAttribute("floor",floor);
        return "user/main";
    }



    //通过ID，查找座位
    @Override
    public Seat GetSeatById(int id) {
        return seatDao.getSeatById(id);
    }

    //设置座位是否为空
    @Override
    public void SetSeatIsempty(Seat seat) {
        seatDao.setSeatIsempty(seat);
    }


}
