package dao.admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Seat;
import pojo.User;

import java.util.List;
import java.util.Map;

@Repository("adminSeatDao")
@Mapper
public interface AdminSeatDao {
    // 增加座位
    public int addSeat(Seat seat);
    // 删除座位
    public int deleteSeat(Seat seat);
    // 修改座位情况
    public int updateSeat(Seat seat);
    // 查询所有座位
    public List<Seat> selectAllSeat();
    // 分页查询所有座位
    public List<Seat> selectAllSeatByPage(Map<String, Object> map);
    // 按层查询所有座位
    public List<Seat> selectAllSeatByFloorANDPage(Map<String, Object> map);
    public List<Seat> selectSeatByFloor(Integer floor);
    // 按层查询空闲座位
    public List<Seat> selectEmptySeatByFloor(Seat seat);
    public List<Seat> selectEmptySeatByFloorANDPage(Map<String, Object> map);
    public List<Seat> selectEmptySeat();
    public List<Seat> selectAllEmptySeatByPage(Map<String, Object> map);
    // 查询所有损坏座位
    public List<Seat> selectAllImpairSeat(Map<String, Object> map);
    public List<Seat> selectImpairSeat();


}
