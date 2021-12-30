package controller.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.admin.AdminUserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    // 到删除界面
    @RequestMapping("/TodeleteUser")
    public String TodeleteUser(Model model, String uemail){
        return adminUserService.TodeleteUser(uemail, model);
    }
    // 删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(String uemail, Model model) {
        return adminUserService.deleteUser(uemail, model);
    }

    // 到查找界面
    @RequestMapping("/ToselectUser")
    public String ToselectUser(String uemail, Model model){
        return adminUserService.ToselectUser(uemail, model);
    }
    // 查找用户
    @RequestMapping("/selectUser")
    public String selectUserByEmail(String uemail, Model model) {
        return adminUserService.selectUser(uemail, model);
    }

    // 到增加页面
    @RequestMapping("/ToaddUser")
    public String ToaddUser(User user, Model model) {
        return adminUserService.ToaddUser(user, model);
    }
    // 增加用户
    @RequestMapping("/addUser")
    public String addUser(User user, Model model) {
        return adminUserService.addUser(user,model);
    }

    // 到更新页面
    @RequestMapping("/ToupdateUser")
    public String ToupdateUser(String uemail, Model model, HttpSession session){
        return adminUserService.ToupdateUser(uemail,model,session);
    }
    // 更新用户
    @RequestMapping("/updateUser")
    public String updateUser(User user, Model model){
        return adminUserService.updateUser(user, model);
    }
    @RequestMapping("/updateRealUser")
    public String updateRealUser(String uemail, Model model, HttpSession session){
        return adminUserService.updateRealUser(uemail, model, session);
    }























}
