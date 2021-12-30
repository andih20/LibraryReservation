package dao.admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import pojo.User;

import java.util.List;

@Repository("adminUserDao")
@Mapper
public interface AdminUserDao {
    // 增加用户
    public int addUser(User user);
    // 删除用户
    public int deleteUser(String uemail);
    // 修改用户
    public int updateUser(User user);
    // 查询所有用户
    public List<User> selectAllUser();
    // 按 email 查询用户
    public List<User> selectUserByEmail(String uemail);
}
