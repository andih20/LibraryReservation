package dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Recording;
import pojo.User;

import java.util.List;
import java.util.Map;

@Repository("recordingDao")
@Mapper
public interface RecordingDao {
    List<Recording> queryRecordingByUser(User user);

    void addRecording(Recording recording);

    void signRecording(Recording recording);

    List<Recording> selectAllRecordingsByPage(Map<String, Object> map);

}
