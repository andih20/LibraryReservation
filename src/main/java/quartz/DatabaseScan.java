package quartz;

import dao.admin.AdminBlackDao;
import dao.admin.AdminUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.User;

import java.util.Date;
import java.util.List;

// 数据库定时扫描
public class DatabaseScan {
    @Autowired
    private AdminBlackDao adminBlackDao;
    @Autowired
    private AdminUserDao adminUserDao;

    public void ScanBlack(){
        // 每天的 7:00,13:00,18:00 扫描
        System.out.println(new Date() + "数据库扫描黑名单用户...");
        // 若有违约次数大于等于3次的
        if(adminBlackDao.updateBlackUser()>0){
            // 获取他们
            System.out.println("违约三次以上");
            List<User> allblack = adminBlackDao.selectAllBlackUser();
            if(allblack!=null){
                for(User user : allblack){
                    // 将用户添加至黑名单表
                    if(adminBlackDao.addUserToBlack(user)>0){
                        // 将用户的 blackSame 属性置为 0 ，以免七天内重复添加
                        adminBlackDao.updateBlackToZero();

                        }
                    }
                }
            }
        // 黑名单里有用户
        if(adminBlackDao.selectBlack().size()>0){
            // 将所有在黑名单里的用户的scan_num都加一
            adminBlackDao.updateBlackNum();
            // 获取经历21次扫描的用户
            List<User> delList = adminBlackDao.selectAllBlackUserByScanNum();
            if(delList.size()!=0){
                for(User userdel : delList){
                    // 删除黑名单用户
                    if(adminBlackDao.deleteUserOutBalck(userdel)!=0){
                        // 将 black 属性置为 0
                        adminUserDao.updateUserBlackToZero(userdel);
                    }
                }
            }
        }

    }
}
