package LINES_AND_WORDS;
//import LINES_AND_WORDS.StudentGroupArrayClass;

import java.util.Scanner;

public class FileExampleMain {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // СЪЗДАВАМЕ ОБЕКТ fc
        FileExampleClass fc = new FileExampleClass("home/kriss/Documents/CODE/O_O_P/LINES_AND_WORDS/Problem.txt");
        System.out.println(fc);

        Scanner sc = new Scanner(System.in);

        System.out.print("x=");
        int x = sc.nextInt();

        System.out.print("y=");
        int y = sc.nextInt();

        System.out.print("a=");
        int a = sc.nextInt();

        System.out.print("b=");
        int b = sc.nextInt();

//		    fc.exchangeRows(x, y);
        fc.exchangeWords(x, y, a, b);
        System.out.println(fc);
        fc.writeToFile("Problem.out.txt");
    }
}