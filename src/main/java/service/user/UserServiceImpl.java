package service.user;

import dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Boolean AddUser(User user){
        userDao.addUser(user);
        return true;
    }

    @Override
    public User QueryUser(User user) {
        return userDao.queryUser(user);
    }

    @Override
    public User QueryUserByEmail(User user) {
        return userDao.queryUserByEmail(user);
    }
}
