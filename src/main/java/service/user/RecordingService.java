package service.user;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pojo.Recording;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface RecordingService {
    //通过User的Id查找使用记录
    List<Recording> QueryRecordingByUser(User user);

    void AddRecording(Recording recording);

    void SignRecording(Recording recording);

    List<Recording> selectAllRecordingsByPage(Map<String, Object> map);
}
