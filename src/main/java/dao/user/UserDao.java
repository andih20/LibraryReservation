package dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;

@Repository("userDao")
@Mapper
public interface UserDao {
    public void addUser(User user);

    public User queryUser(User user);

    public User queryUserByEmail(User user);

    void updateUser(User user);

    boolean deleteUser(User user);
}
