package service.user;

import dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import javax.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //查找一个用户，检查能否登录
    @Override
    public String selectUserForLogin(User user, HttpSession session){
        user = userDao.queryUser(user);
        session.setAttribute("user",user);
        if(null!=user){
            //已存在，则正常跳转
            return "user/main";
        }else {
            //未存在则返回登录界面
            return  "user/login";
        }
    }

    //查找一个用户，检查能否注册
    @Override
    public String selectUserForRegister(User user) {
        //设注册时，以email为唯一识别用户
        User temp_user = userDao.queryUserByEmail(user);
        if(temp_user!=null){
            //已存在，则重新输入
            return "user/register";
        }else {
            //未存在，则正常注册
            userDao.addUser(user);
            return "user/login";
        }
    }

    //更新用户信息
    @Override
    public String updateUser(User user, HttpSession session) {
        //设置新值
        User new_user = (User) session.getAttribute("user");
        new_user.setUname(user.getUname());
        new_user.setUpassword(user.getUpassword());
        new_user.setUemail(user.getUemail());
        session.setAttribute("user",new_user);

        //更新用户信息
        userDao.updateUser(new_user);
        return "user/main";
    }

    //删除用户
    @Override
    public String deleteUser(User user) {
        if(userDao.deleteUser(user)){
            //删除成功，返回登录界面
            return "user/login";
        }else {
            //删除失败，返回主界面
            return "user/main";
        }
    }



    //增加一个用户
    @Override
    public Boolean AddUser(User user){
        userDao.addUser(user);
        return true;
    }

    //查找一个用户，通过name&password
    @Override
    public User QueryUser(User user) {
        return userDao.queryUser(user);
    }

    //查找一个用户，通过email
    @Override
    public User QueryUserByEmail(User user) {
        return userDao.queryUserByEmail(user);
    }
}
