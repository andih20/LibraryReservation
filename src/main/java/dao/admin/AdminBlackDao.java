package dao.admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;

import java.util.List;
import java.util.Map;

@Repository("adminBlackDao")
@Mapper
public interface AdminBlackDao {
    // 将用户添加至黑名单
    public int addUserToBlack(User user);
    // 将用户移除黑名单
    public int deleteUserOutBalck(User user);
    // 查询黑名单所有用户
    public List<User> selectAllBlackUser();
    public List<String> selectAllBlackUserByPage(Map<String, Object> map);
    public List<User> selectBlack();

    // 更新黑名单
    public int updateBlackUser();
    public int updateBlackToZero();
    public int updateBlackNum();
    public List<User> selectAllBlackUserByScanNum();

}
