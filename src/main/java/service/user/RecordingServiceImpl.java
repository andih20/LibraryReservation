package service.user;

import dao.user.RecordingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Recording;
import pojo.User;

import java.util.List;

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
}
