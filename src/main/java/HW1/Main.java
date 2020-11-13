package HW1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Первое задание
        String[] strings = {"one", "two", "three", "four", "five"};
        System.out.println(Arrays.toString(strings));
        swapMethod(strings, 1, 7);
        swapMethod(strings, 1, 3);
        System.out.println(Arrays.toString(strings));

        // Второе задание
        ArrayList<String> stringArrayList = convertToArrayList(strings);
        System.out.println("ArrayList: " + stringArrayList);

        // Третье задание
        Box<Orange> orangeBox = new Box<Orange>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        //orangeBox.add(new Orange());

        Box<Apple> appleBox = new Box<Apple>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Box<Apple> appleBox2 = new Box<Apple>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());

        appleBox2 = appleBox.poreIntoAnotherBox(appleBox2);

        System.out.println(appleBox2.getWeight());
        System.out.println(appleBox.getWeight());

        System.out.println(orangeBox.compare(appleBox));
    }

    // Первое задание
    public static <T> void swapMethod(T[] array, int first, int second){
        if (first > array.length || second > array.length){
            System.out.println("Array is smaller than first or second element");
        }else {
            T element = array[first];
            array[first] = array[second];
            array[second] = element;
        }
    }

    // Второе задание
    public static <T> ArrayList<T> convertToArrayList(T[] array){
        return new ArrayList<T>(Arrays.asList(array));
    }


}
