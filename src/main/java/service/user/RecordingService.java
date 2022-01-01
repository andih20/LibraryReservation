package service.user;

import org.springframework.stereotype.Service;
import pojo.Recording;
import pojo.User;

import java.util.List;

public interface RecordingService {
    //通过User的Id查找使用记录
    List<Recording> QueryRecordingByUser(User user);

    void AddRecording(Recording recording);

    void SignRecordingByUser(User user);
}
