package controller.user;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.FileDomin;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FileUploadController {

    @RequestMapping("/onefile")
    public String oneFileUpload(@ModelAttribute FileDomin fileDomin, HttpServletRequest request){
        String realpath = request.getServletContext().getRealPath("uploadfiles");
        String fileName = fileDomin.getAppeal_file().getOriginalFilename();
        File targetFile = new File(realpath,fileName);
        if(targetFile.exists()){
            targetFile.mkdirs();
        }
        //上传
        try {
            fileDomin.getAppeal_file().transferTo(targetFile);
        }catch (Exception ignored){

        }
        return "user/user_info";
    }
}
