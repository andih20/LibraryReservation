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

    @Override
    public List<Recording> QueryRecordingByUser(User user) {
        return recordingDao.queryRecordingByUser(user);
    }

    @Override
    public void AddRecording(Recording recording) {
        recordingDao.addRecording(recording);
    }

    @Override
    public void SignRecording(Recording recording) {
        recordingDao.signRecording(recording);
    }

    @Override
    public List<Recording> selectAllRecordingsByPage(Map<String, Object> map) {
        return recordingDao.selectAllRecordingsByPage(map);
    }

}
