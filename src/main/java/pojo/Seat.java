package pojo;

public class Seat {
    private Integer id;
    private Integer floor;      // 楼层
    private Boolean empty;      // 是否为空，默认为 true
    private Boolean impair;     // 是否损坏，默认为 false


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Boolean getImpair() {
        return impair;
    }

    public void setImpair(Boolean impair) {
        this.impair = impair;
    }
}
