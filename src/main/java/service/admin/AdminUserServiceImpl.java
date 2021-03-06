package service.admin;

import dao.admin.AdminUserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String selectUser(String uemail, Model model) {
        if (adminUserDao.selectUserByEmail(uemail).size()>0){
            model.addAttribute("Selectmsg", "用户查找成功！");
        }
        // 返回查询用户界面
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
    public String addUser(@Param("user") User user, Model model) {
        String namePattern = "[a-zA-Z0-9]{3,8}$";
        Pattern r_name = Pattern.compile(namePattern);
        Matcher m_name = r_name.matcher(user.getUname());

        String pwPattern = "[a-zA-Z0-9]{6,18}$";
        Pattern r_pw = Pattern.compile(pwPattern);
        Matcher m_pw = r_pw.matcher(user.getUpassword());

        String emailPattern = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern r_email = Pattern.compile(emailPattern);
        Matcher m_email = r_email.matcher(user.getUemail());

        if(m_name.find() && m_email.find() && m_pw.find()) {
            if (adminUserDao.addUser(user) != 0) {
                model.addAttribute("addUsermsg", "用户添加成功！");
            }
        }
        else{
            model.addAttribute("addUsermsg", "用户添加失败！输入格式错误！");
        }
        // 返回添加界面
        return "forward:/adminUser/ToaddUser";
    }

    @Override
    public String ToaddUser(@Param("user") User user, Model model) {
        return "admin/addUser";
    }


    @Override
    public String updateUser(@Param("user") User user, Model model) {
        String namePattern = "[a-zA-Z0-9]{3,8}$";
        Pattern r_name = Pattern.compile(namePattern);
        Matcher m_name = r_name.matcher(user.getUname());

        String pwPattern = "[a-zA-Z0-9]{6,18}$";
        Pattern r_pw = Pattern.compile(pwPattern);
        Matcher m_pw = r_pw.matcher(user.getUpassword());

        String emailPattern = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern r_email = Pattern.compile(emailPattern);
        Matcher m_email = r_email.matcher(user.getUemail());

        if(m_name.find() && m_email.find() && m_pw.find()){
            if(adminUserDao.updateUser(user)!=0){
                model.addAttribute("updatemsg", "用户更新成功！");
            }
        } else{
            model.addAttribute("updatemsg", "用户更新失败！输入格式错误！");
        }

        // 返回更新界面
        return "forward:/adminUser/ToupdateUser";
    }

    @Override
    public String ToupdateUser(String uemail, Model model, HttpSession session) {
        model.addAttribute("UpdateAllUserInfo",adminUserDao.selectAllUser());
        model.addAttribute("UpdateUserInfo", adminUserDao.selectUserByEmail(uemail));
        if(adminUserDao.selectUserByEmail(uemail).size()!=0){
            model.addAttribute("Updateuemail",uemail);
            model.addAttribute("UpdateuserExitmsg","已找到用户");
        }
        return "admin/updateUser";
    }

    @Override
    public String updateRealUser(String uemail, Model model,HttpSession session) {
        if(adminUserDao.selectUserByEmail(uemail).size()!=0){
            model.addAttribute("Updateuemail",uemail);
            session.setAttribute("Updateuemail",uemail);
        }
        return "admin/updateRealUser";
    }

}
