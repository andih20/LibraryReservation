package service.admin;

import dao.admin.AdminBlackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminBlackService")
@Transactional
public class AdminBlackServiceImpl implements AdminBlackService {
    @Autowired
    private AdminBlackDao adminBlackDao;

    @Override
    public Boolean addUser(User user, Model model) {
        if(adminBlackDao.addUserToBlack(user)>0){
            model.addAttribute("Addmsg","添加黑名单成功");
            return true;
        }else{
            model.addAttribute("Addmsg","添加黑名单失败");
            return false;
        }
    }

    @Override
    public String deleteUser(User user, Model model) {
        if(adminBlackDao.deleteUserOutBalck(user)>0){
            model.addAttribute("Deletemsg","移除黑名单成功");
        }else{
            model.addAttribute("Deletemsg","移除黑名单失败");
        }
        return "forward:/adminUser/selectBlackUser";
    }

    @Override
    public String selectUser(Model model, Integer pageCur, Map<String, Object> map) {
        List<User> allUser = adminBlackDao.selectAllBlackUser();
        model.addAttribute("allUser", allUser);
        int temp = allUser.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        if (temp == 0) {
            totalPage = 0;//总页数
        } else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp / 4);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 4 > temp) {
            pageCur = pageCur - 1;
        }
        // 分页查询
        map.put("startIndex", (pageCur - 1) * 4); //起始位置
        map.put("perPageSize", 4); //每页 4 个;

        List<String> UserList = new ArrayList<String>();
        UserList = adminBlackDao.selectAllBlackUserByPage(map);
        model.addAttribute("UserList", UserList);
        model.addAttribute("allUserByPage", adminBlackDao.selectAllBlackUserByPage(map));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);

        return "admin/selectBlackUser";
    }




}
