package LINES_AND_WORDS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileExampleClass {

    private ArrayList<ArrayList<String>> data;


    // CONSTRUCTOR : DEFAULT
    public FileExampleClass() {
        data = new ArrayList<>();
    }


    // CONSTRUCTOR : WITH PARAMS :
    // 1. ЧЕТЕ ФАЙЛА РЕД ПО РЕД (temp);
    // 2. РАЯЗДЕЛЯ ГО НА ДУМИ И ГИ ЗАПИСВА В СПИСЪК (words); // СПИСЪК С ДУМИТЕ
    // 3. ЗАПИСВА СПИСЪКА ОТ ДУМИ В СПИСЪКА (data) // СПИСЪК С РЕДОВЕТЕ
    public FileExampleClass(String fileName) {
        this();
        try {
            Scanner sc = new Scanner(new File(fileName), "UTF-8");
            while (sc.hasNextLine()) {
                String temp = sc.nextLine();
                ArrayList<String> words = new ArrayList<>();
                words.addAll(Arrays.asList(temp.split(" ")));
                data.add(words);
            }
            sc.close();

            // ОБРАБОТВА ЕКСЕПШЪН ЧЕ НЕ Е НАМЕРИЛ ФАЙЛА
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    //METHOD : РАЗМЯНА НА ДУМИТЕ :
    // ПОЛЗВА : x - номер на единия ред; y-номер на другия ред;
    // a - номер на едната дума; b- номер на другата дума;

    public void exchangeWords(int x, int y, int a, int b) {

        // ВАЛИДИРА ЕДИНИЯ РЕД
        if (x < 1 || x > data.size()) {
            System.out.println("x is not valid row number");
            return;
        }
        // ВАЛИДИРА ДРУГИЯ РЕД
        if (y < 1 || y > data.size()) {
            System.out.println("y is not valid row number");
            return;
        }

        // ВАЛИДИРА ДУМИТЕ ОТ ЕДИНИЯ РЕД
        if (a < 1 || a > data.get(x-1).size() || a > data.get(y-1).size()) {
            System.out.println("a is not valid word number");
            return;
        }
        // ВАЛИДИРА ДУМИТЕ ОТ ДРУГИЯ РЕД
        if (b < 1 || b > data.get(x-1).size() || b > data.get(y-1).size()) {
            System.out.println("b is not valid word number");
            return;
        }

        // РАЗМЯНА НА МЕСТАТА НА ДМИТЕ
        String temp = data.get(x-1).get(a-1);           // НАЧИН ЗА ИЗВИКВАНЕ НА ЕЛЕМЕНТ ОТ СПЪСЪК (words),
        // КОЙТО Е В ДРУГ СПИСЪК (data)
        data.get(x-1).set( a-1, data.get(y-1).get(b-1) ); // ТРОЙНО ПРЕХВЪРЛЯНЕ : едната дума в темп,
        // другата дума в предната
        // и накрая темп (буфера) втората ;
        data.get(y-1).set(b-1, temp);
    }//METHOD - END : РАЗМЯНА НА ДУМИТЕ.



    // METHOD : РАЗМЯНА НА РЕДОВЕТЕ (!!! НЕ СЕ ПОЛЗВА В MAIN !!!):
    public void exchangeRows(int x, int y) {
        if (x < 1 || x > data.size()) { // "МАСИВА" С РЕДОВЕТЕ
            System.out.println("x is not valid row number");
            return;
        }
        if (y < 1 || y > data.size()) { // "МАСИВА" С РЕДОВЕТЕ
            System.out.println("y is not valid row number");
            return;
        }

        int start = Math.min(x - 1, y - 1);
        int end = Math.max(x - 1, y - 1);

//		String temp = data.get(start);
//		data.set(start, data.get(end));
//		data.set(end, temp);
    }//METHOD - END: РАЗМЯНА НА РЕДОВЕТЕ.


    // METHOD : ЗА ЗАПИСВАНЕ В НОВ ФАЙЛ :
    public void writeToFile(String fileName) {
        try {
            FileWriter out = new FileWriter(fileName);
            out.write(toString());
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//METHOD - END: ЗА ЗАПИСВАНЕ В НОВ ФАЙЛ.



    @Override // ОВЪРРАЙД - ПРЕНАПИСВАНЕ НА МЕТОД В JAVA;
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (ArrayList<String> element : data) { //FOR-EACH ЗА СПЪСЪКА С РЕДОВЕТЕ (КОЙТО МНОГО ПРИЛИЧА НА ФОР-ЦИКЪЛ)

            for (String s : element) { // //FOR-EACH ЗА СПЪСЪКА С ДУМИТЕ
                str.append(s + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}