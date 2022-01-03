package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.admin.AdminRecordService;

import java.util.Map;

@Controller
@RequestMapping("/adminRecord")
public class AdminRecordController {
    @Autowired
    private AdminRecordService adminRecordService;

    @RequestMapping("/ToselectRecord")
    public String ToselectRecord(Model model, Integer pageCur, Map<String, Object> map){
        return adminRecordService.ToselectRecord(model, pageCur, map);
    }


}
