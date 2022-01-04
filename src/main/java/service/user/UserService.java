package service.user;

import pojo.User;

public interface UserService {
    public Boolean AddUser(User user);

    public User QueryUser(User user);

    public User QueryUserByEmail(User user);

    void updateUser(User user);

    String deleteUser(User user);
}
