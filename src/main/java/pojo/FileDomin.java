package pojo;

import org.springframework.web.multipart.MultipartFile;

public class FileDomin {
    private User user;
    private MultipartFile appeal_file;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MultipartFile getAppeal_file() {
        return appeal_file;
    }

    public void setAppeal_file(MultipartFile appeal_file) {
        this.appeal_file = appeal_file;
    }
}
