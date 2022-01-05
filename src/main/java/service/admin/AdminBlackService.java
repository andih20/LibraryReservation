package service.admin;

import org.springframework.ui.Model;
import pojo.User;

import java.util.Map;

public interface AdminBlackService {
    // 添加用户至黑名单
    public Boolean addUser(User user, Model model);
    // 将用户移除黑名单
    public String deleteUser(User user, Model model);
    // 查询所有黑名单用户
    public String selectUser(Model model, Integer pageCur, Map<String, Object> map);


}
