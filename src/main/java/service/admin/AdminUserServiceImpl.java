package service.admin;

import dao.admin.AdminUserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.User;

import java.util.List;

@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public String deleteUser(String uemail, Model model) {
        if (adminUserDao.deleteUser(uemail)>0){
            model.addAttribute("msg", "用户删除成功！");
        }
        // 返回删除用户界面
        return "forward:/adminUser/TodeleteUser";
    }

    @Override
    public String TodeleteUser(String uemail, Model model) {
        model.addAttribute("AllUserInfo",adminUserDao.selectAllUser());
        model.addAttribute("UserInfo", adminUserDao.selectUserByEmail(uemail));
        if(adminUserDao.selectUserByEmail(uemail).size()!=0){
            model.addAttribute("userExitmsg","已找到用户");
            model.addAttribute("userNoExit", 0);
        }
        else{
            model.addAttribute("userNoExit", 1);
        }
        return "admin/deleteUser";
    }

    @Override
    public String updateUser(String uemail, Model model) {
        return null;
    }

    @Override
    public String ToupdateUser(Model model) {
        return null;
    }

    @Override
    public String selectUser(String uemail, Model model) {
        if (adminUserDao.selectUserByEmail(uemail).size()>0){
            model.addAttribute("Selectmsg", "用户查找成功！");
        }
        // 返回删除用户界面
        return "forward:/adminUser/ToselectUser";
    }

    @Override
    public String ToselectUser(String uemail, Model model) {
        model.addAttribute("SelectAllUserInfo",adminUserDao.selectAllUser());
        model.addAttribute("SelectUserInfo", adminUserDao.selectUserByEmail(uemail));
        if(adminUserDao.selectUserByEmail(uemail).size()!=0){
            model.addAttribute("SelectuserExitmsg","已找到用户");
        }

        return "admin/selectUser";
    }

    @Override
    public String addUser(@Param("user") User user) {
        adminUserDao.addUser(user);
        // 返回添加界面
        return "forward:/adminUser/ToaddUser";
    }

    @Override
    public String ToaddUser(@Param("user") User user, Model model) {
        return "admin/addUser";
    }

}
