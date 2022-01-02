package service.user;

import pojo.Floor;
import pojo.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> GetAllSeatByFloor(Floor floor);

    Seat GetSeatById(int id);

    void SetSeatIsempty(Seat seat);
}
