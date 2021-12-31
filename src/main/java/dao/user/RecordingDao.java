package dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Recording;
import pojo.User;

import java.util.List;

@Repository("recordingDao")
@Mapper
public interface RecordingDao {
    public List<Recording> queryRecordingByUser(User user);
}
