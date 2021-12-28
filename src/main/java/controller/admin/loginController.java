package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.AdminUser;
import service.admin.AdminloginService;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @Autowired
    private AdminloginService adminloginService;

    @RequestMapping("/admin")
    public String toLogin(@ModelAttribute AdminUser adminUser) {
        return "admin/login";
    }

    @RequestMapping("/admin/login")
    public String login(@ModelAttribute AdminUser adminUser, Model model, HttpSession session) {
        return adminloginService.login(adminUser, model, session);

    }
}
