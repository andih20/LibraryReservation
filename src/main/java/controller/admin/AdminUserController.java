package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.admin.AdminUserService;

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
    @RequestMapping("/deleteUser")
    // 删除用户
    public String deleteUser(String uemail, Model model) {
        return adminUserService.deleteUser(uemail, model);
    }















}
