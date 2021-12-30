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
    // 到查询界面
    public String ToselectUser(String uemail, Model model);
    // 查询用户
    public String selectUser(String uemail, Model model);
    // 增加用户
    public String addUser(User user);
    // 到增加页面
    public String ToaddUser(User user, Model model);


}
