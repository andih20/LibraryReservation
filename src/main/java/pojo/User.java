package pojo;

public class User {
    private Integer id;         // 自增
    private String uname;
    private String upassword;
    private String uemail;
    private Integer number=0;  //未签到次数，默认是0
    private Boolean black;     //黑名单，默认是 false
    private Boolean blackSame;     //黑名单，默认是 false

    public Boolean getBlackSame() {
        return blackSame;
    }

    public void setBlackSame(Boolean blackSame) {
        this.blackSame = blackSame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getBlack() {
        return black;
    }

    public void setBlack(Boolean black) {
        this.black = black;
    }

}
