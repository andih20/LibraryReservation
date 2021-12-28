package service.admin;

import org.springframework.ui.Model;
import pojo.AdminUser;

import javax.servlet.http.HttpSession;

public interface AdminloginService {
    public String login(AdminUser adminuser, Model model, HttpSession session);
}
