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
    public void AddUser(User user){
        userDao.addUser(user);
    }
}
