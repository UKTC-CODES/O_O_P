package BUILDINGS_17212;

public class Building {
    private float area;
    private String address;


    // CONSTRUCTOR.................................................................................
    public Building(float area, String address) {
        this.area = area;
        this.address = address;
    }


    // GET-SET.....................................................................................
    public float getArea() { return area; }
    public void setArea(float area) { this.area = area; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

}
