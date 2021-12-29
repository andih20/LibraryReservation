package service.admin;

import org.springframework.ui.Model;
import pojo.User;

import java.util.List;

public interface AdminUserService {
    // 删除用户
    public String deleteUser(String uemail, Model model);
    public String TodeleteUser(String uemail, Model model);
    // 修改用户
    public String updateUser(String uemail, Model model);
    public String ToupdateUser(Model model);
    // 查询所有用户
    public List<User> selectAllUser();
    // 按 email 查询用户
    public List<User> selectUserByEmail(String uemail);
}
