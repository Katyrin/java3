package HW3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readFile("file.txt");
        createFile();
        long m = System.currentTimeMillis();
        readPage();
        System.out.println("Время работы программы: " + (System.currentTimeMillis() - m));
    }

    // Первое задание
    private static void readFile(String fileName){
        try (FileInputStream in = new FileInputStream(fileName)) {
            byte[] arr = new byte[50];
            int x;
            while ((x = in.read(arr)) > 0){
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Второе задание
    private static void createFile(){
        ArrayList<InputStream> ali = new ArrayList<>();
        try (FileOutputStream fos = new FileOutputStream("file6.txt")){
            ali.add(new FileInputStream("file.txt"));
            ali.add(new FileInputStream("file2.txt"));
            ali.add(new FileInputStream("file3.txt"));
            ali.add(new FileInputStream("file4.txt"));
            ali.add(new FileInputStream("file5.txt"));
            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
            int x;
            while ((x = in.read()) != -1){
                fos.write((char)x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Третье задание
    private static void readPage(){
        Scanner scanner = new Scanner(System.in);
        int pageNumber = 0;
        System.out.println("Введите номер страницы");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                pageNumber = scanner.nextInt();
                break;
            } else {
                System.out.println("Это не номер введите номер");
                scanner.next();
            }
        }

        long m = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream("file7.txt")) {
            byte[] arr = new byte[1800];
            int x;
            long count = 0;
            while ((x = in.read(arr)) > 0){
                if (count >= pageNumber-1 && count < pageNumber)
                    System.out.print(new String(arr, 0, x, "UTF-8"));
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Время чтения страницы: " + (System.currentTimeMillis() - m));

    }
}
