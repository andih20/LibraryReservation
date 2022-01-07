package service.user;

import org.springframework.ui.Model;
import pojo.Recording;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface RecordingService {

    String AddRecording(Recording recording, HttpSession session);

    String SignRecordingStart(HttpSession session) throws ParseException;

    String SignRecordingEnd(HttpSession session);


    List<Recording> selectAllRecordingsByPage(Map<String, Object> map);

    String QueryRecordingByUser(HttpSession session, Model model, Integer pageCur);


}
