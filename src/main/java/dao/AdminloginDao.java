package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.AdminUser;

import java.util.List;

@Repository("adminloginDao")
@Mapper
public interface AdminloginDao {
    public List<AdminUser> login(AdminUser adminUser);
}
