package service.user;

import dao.user.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Floor;
import pojo.Seat;

import java.util.List;

@Service("seatService")
public class SeatServiceImpl implements SeatService{
    @Autowired
    private SeatDao seatDao;

    //通过楼层查找所有座位
    @Override
    public List<Seat> GetAllSeatByFloor(Floor floor) {
        return seatDao.getAllSeatByFloor(floor);
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
