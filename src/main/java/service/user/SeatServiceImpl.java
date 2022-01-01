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

    @Override
    public List<Seat> GetAllSeatByFloor(Floor floor) {
        return seatDao.getAllSeatByFloor(floor);
    }

    @Override
    public Seat GetSeatById(int id) {
        return seatDao.getSeatById(id);
    }

}
