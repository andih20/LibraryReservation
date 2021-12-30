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
    public String toLogin(@ModelAttribute("adminUser") AdminUser adminUser) {
        return "admin/login";
    }

    @RequestMapping("/admin/login")
    public String login(@ModelAttribute("adminUser") AdminUser adminUser, Model model, HttpSession session) {
        return adminloginService.login(adminUser, model, session);

    }
    @RequestMapping("/admin/main")
    public String AdminMain(@ModelAttribute("adminUser") AdminUser adminUser, HttpSession session){
        if(session.getAttribute("adminuser")!=null) {
            return "admin/main";
        }
        else{
            return "admin/login";
        }
    }
}
