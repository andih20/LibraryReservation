package controller.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import quartz.QuartzManager;
import service.admin.AdminBlackService;
import service.admin.AdminUserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminBlackService adminBlackService;

    // 到删除界面
    @RequestMapping("/TodeleteUser")
    public String TodeleteUser(Model model, String uemail) {
        return adminUserService.TodeleteUser(uemail, model);
    }

    // 删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(String uemail, Model model) {
        return adminUserService.deleteUser(uemail, model);
    }

    // 到查找界面
    @RequestMapping("/ToselectUser")
    public String ToselectUser(String uemail, Model model) {
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
        return adminUserService.addUser(user, model);
    }

    // 到更新页面
    @RequestMapping("/ToupdateUser")
    public String ToupdateUser(String uemail, Model model, HttpSession session) {
        return adminUserService.ToupdateUser(uemail, model, session);
    }

    // 更新用户
    @RequestMapping("/updateUser")
    public String updateUser(User user, Model model) {
        return adminUserService.updateUser(user, model);
    }

    @RequestMapping("/updateRealUser")
    public String updateRealUser(String uemail, Model model, HttpSession session) {
        return adminUserService.updateRealUser(uemail, model, session);
    }

    // 加入黑名单
    @RequestMapping("/selectBlackUser")
    public String selectBlackUser(Model model, Integer pageCur, Map<String, Object> map) {
        return adminBlackService.selectUser(model, pageCur, map);
    }

    @RequestMapping("/deleteBlackUser")
    public String deleteBlackUser(User user, Model model) {
        return adminBlackService.deleteUser(user, model);
    }

    // 退出
    @RequestMapping("/exit")
    public String exit(@ModelAttribute User user, HttpSession session) {
        session.invalidate();
        return "admin/login";
    }

    // 数据库定时搜索 + 加入移除黑名单
    @RequestMapping("/black")
    public void ScanBlack() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuartzManager quartzManager = (QuartzManager) ctx.getBean("quartzManager");
        try {
            System.out.println("【系统启动】开始DatabaseScan...");
            //关掉任务调度容器
            // quartzManager.shutdownJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




















}
