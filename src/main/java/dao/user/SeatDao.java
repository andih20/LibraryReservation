package dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Floor;
import pojo.Seat;

import java.util.List;

@Repository("seatDao")
@Mapper
public interface SeatDao {
    List<Seat> getAllSeatByFloor(Floor floor);

    Seat getSeatById(int id);

    void setSeatIsempty(Seat seat);
}
