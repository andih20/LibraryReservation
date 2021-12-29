package dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;

@Repository("userDao")
@Mapper
public interface UserDao {
    public void addUser(User user);
}
