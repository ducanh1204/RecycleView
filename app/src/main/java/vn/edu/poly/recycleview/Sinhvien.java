package vn.edu.poly.recycleview;

public class Sinhvien {
    String id;
    String name;

    public Sinhvien(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Sinhvien() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
