package service.admin;

import dao.admin.AdminRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Recording;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminRecordService")
@Transactional
public class AdminRecordServiceImpl implements AdminRecordService {
    @Autowired
    private AdminRecordDao adminRecordDao;

    @Override
    public String ToselectRecord(Model model, Integer pageCur, Map<String, Object> map) {
        List<Recording> allRecord = adminRecordDao.selectAllRecord();
        model.addAttribute("allRecord", allRecord);
        int temp = allRecord.size();
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
        Map<String,String> RecordMap = new HashMap<>();

        List<String> recordList = new ArrayList<String>();
        recordList = adminRecordDao.selectAllRecordByPage(map);
        model.addAttribute("recordList", recordList);
        model.addAttribute("allRecordByPage", adminRecordDao.selectAllRecordByPage(map));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);
        model.addAttribute("msg", "已找到预约");

        return "admin/selectRecord";
    }
}
