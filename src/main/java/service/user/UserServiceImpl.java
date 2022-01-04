package service.user;

import dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //增加一个用户
    @Override
    public Boolean AddUser(User user){
        userDao.addUser(user);
        return true;
    }

    //查找一个用户，通过ID
    @Override
    public User QueryUser(User user) {
        return userDao.queryUser(user);
    }

    //查找一个用户，通过email
    @Override
    public User QueryUserByEmail(User user) {
        return userDao.queryUserByEmail(user);
    }

    //更新用户信息
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
