package service.user;

import pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    String selectUserForLogin(User user, HttpSession session);

    String selectUserForRegister(User user);

    User QueryUser(User user);

    String updateUser(User user, HttpSession session);

    String deleteUser(User user);

    Boolean AddUser(User user);

    User QueryUserByEmail(User user);
}
