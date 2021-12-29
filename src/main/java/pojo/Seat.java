package pojo;

public class Seat {
    private Integer id;
    private Integer floor;
    private Boolean empty;
    private Boolean impair;


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
