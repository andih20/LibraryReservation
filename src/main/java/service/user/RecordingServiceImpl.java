package service.user;

import dao.user.RecordingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pojo.Recording;
import pojo.User;

import java.util.List;
import java.util.Map;

@Service("RecordingService")
public class RecordingServiceImpl implements RecordingService {
    @Autowired
    private RecordingDao recordingDao;

    //通过用户查找使用记录
    @Override
    public List<Recording> QueryRecordingByUser(User user) {
        return recordingDao.queryRecordingByUser(user);
    }

    //增加一个记录信息
    @Override
    public void AddRecording(Recording recording) {
        recordingDao.addRecording(recording);
    }

    //设置该记录出席情况（开始签到，离开签到）
    @Override
    public void SignRecording(Recording recording) {
        recordingDao.signRecording(recording);
    }

    //按页查询所有的记录
    @Override
    public List<Recording> selectAllRecordingsByPage(Map<String, Object> map) {
        return recordingDao.selectAllRecordingsByPage(map);
    }

}
