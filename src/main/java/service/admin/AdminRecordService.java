package service.admin;

import org.springframework.ui.Model;

import java.util.Map;

public interface AdminRecordService {
    // 分页查询所有预约
    public String ToselectRecord(Model model, Integer pageCur, Map<String, Object> map);


}
