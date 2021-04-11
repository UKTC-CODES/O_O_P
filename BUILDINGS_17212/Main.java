package BUILDINGS_17212;

public class Main {

    public static void main(String[] args) {

        House House81 = new House(52.32f, "Sofia 81", (short) 2, "Johny Depp");
        House House83 = new House(56.20f, "Sofia 83", (short) 3, "Ariana Grande");
        House House86 = new House(60.00f, "Sofia 86", (short) 4, "The Rock");

        fancyPrint(House81);
        fancyPrint(House83);
        fancyPrint(House86);

        printMostSpacious();
    }


    // FANCY PRINT ................................................................................
    public static void fancyPrint(Building building) {
        System.out.println("-----------------------------------------------------");
        System.out.println(building);
        System.out.println("-----------------------------------------------------\n");
    }


    // PRINT MOST SPECIOUS .......................................................................
    public static void printMostSpacious() {
        House mostSpacious = House.mostSpacious();

        System.out.println( "=====================================================");
        System.out.printf(  " The most spacious house is on  : %s; \n" +
                            " The owner of the house is      : %s; \n" +
                            " The floor area is              : %.2f square meters! \n",
                mostSpacious.getAddress(),
                mostSpacious.getOwnerName(),
                mostSpacious.getArea() / mostSpacious.getNumberFloors());
        System.out.println("=====================================================\n");
    }
}