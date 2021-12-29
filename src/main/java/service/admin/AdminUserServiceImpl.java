package service.admin;

import dao.admin.AdminUserDao;
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
        if(adminUserDao.selectUserByEmail(uemail)!=null){
            model.addAttribute("UserInfo", adminUserDao.selectUserByEmail(uemail));
            model.addAttribute("userExitmsg","已找到用户");
        }
        else
            model.addAttribute("userNoExit", true);
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
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public List<User> selectUserByEmail(String uemail) {
        return null;
    }
}
