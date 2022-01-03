package dao.admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Recording;

import java.util.List;
import java.util.Map;

@Repository("adminRecordDao")
@Mapper
public interface AdminRecordDao {
    // 查询所有预约
    public List<Recording> selectAllRecord();
    // 分页查询所有预约
    public List<String> selectAllRecordByPage(Map<String, Object> map);

}
