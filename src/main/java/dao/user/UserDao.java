package dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;

@Repository("userDao")
@Mapper
public interface UserDao {
    void addUser(User user);

    User queryUser(User user);

    User queryUserByEmail(User user);

    void updateUser(User user);

    boolean deleteUser(User user);
}
