package dao.admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Seat;
import java.util.List;
import java.util.Map;

@Repository("adminSeatDao")
@Mapper
public interface AdminSeatDao {
    // 增加座位

    // 删除座位

    // 修改座位情况

    // 查询所有座位
    public List<Seat> selectAllSeat();
    // 分页查询所有座位
    public List<Seat> selectAllSeatByPage(Map<String, Object> map);
    // 按层查询所有座位
    public List<Seat> selectAllSeatByFloorANDPage(Map<String, Object> map);
    public List<Seat> selectSeatByFloor(Integer floor);
    // 按层查询空闲座位
    public List<Seat> selectEmptySeatByFloor(Seat seat);
    // 查询所有损坏座位
    public List<Seat> selectAllImpairSeat(Map<String, Object> map);
    public List<Seat> selectImpairSeat();

}