package BUILDINGS_17212;

import java.util.ArrayList;

public class House extends Building {


    private short numberFloors;
    private String ownerName;
    private static ArrayList<House> houseList = new ArrayList<>();


    // CONSTRUCTOR.................................................................................
    public House(float area, String address,
                 short numberFloors, String ownerName)
    {
        super(area, address); // Get from BUILDING-CLASS
        this.numberFloors = numberFloors;
        this.ownerName = ownerName;
        houseList.add(this); // ADD this HOUSE to the ArrayList ! ! !
    }


    // GET-SET.....................................................................................
    public static ArrayList<House> getHouseList() { return houseList; }
    public static void setHouseList(ArrayList<House> houseList) { House.houseList = houseList; }

    public short getNumberFloors() { return numberFloors; }
    public String getOwnerName() { return ownerName; }

    public void setNumberFloors(short numberFloors) { this.numberFloors = numberFloors; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }






    // MOST SUSPICIOUS............................................................................
    public static House mostSpacious() {

        House max = houseList.get(0);

        for (House getHouse : houseList) {

            if (getHouse.getArea() / getHouse.numberFloors > max.getArea() / max.numberFloors) {
                max = getHouse;
            }
        }
        return max;
    }



    // TO-STRING (OVERRIDE)........................................................................
    @Override
    public String toString() {

        StringBuilder toPrint = new StringBuilder();
        {
            toPrint.append("Address    : ").append(this.getAddress()).append("\n");
            toPrint.append("Owner      : ").append(this.ownerName).append("\n");
            toPrint.append("Floors     : ").append(this.numberFloors).append("\n");
            toPrint.append("Total area : ").append(this.getArea());
        }

        return toPrint.toString();
    }
}