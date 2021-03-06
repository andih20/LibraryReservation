package service.admin;

import dao.admin.AdminloginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pojo.AdminUser;

import javax.servlet.http.HttpSession;

@Service("adminloginService")
public class AdminloginServiceImpl implements AdminloginService {
    @Autowired
    private AdminloginDao adminloginDao;

    @Override
    public String login(AdminUser adminuser, Model model, HttpSession session) {
        if (adminloginDao.login(adminuser) != null && adminloginDao.login(adminuser).size() > 0) {
            session.setAttribute("adminuser", adminuser);
            return "admin/main";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "admin/login";
    }
}
