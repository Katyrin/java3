package HW6;

public class Main {

    public int[] methodOne(int[] ints){
        if (ints == null) {
            throw new RuntimeException("Массив не должен быть нулевым");
        }

        int count = 0;
        int size = 0;
        for (int value : ints) {
            if (value == 4) {
                count++;
                size = 0;
            } else
                size++;
        }
        if (count == 0){
            throw new RuntimeException("Массив не содержит ни одной четверки");
        }

        int[] ints2 = new int[size];
        int count2 = 0;
        int sizeCount = 0;
        for (int anInt : ints) {
            if (count == count2){
                ints2[sizeCount++] = anInt;
            }
            if (anInt == 4)
                count2++;
        }
        return ints2;
    }

    public boolean methodTwo(int[] ints){
        int oneCount = 0;
        int fourCount = 0;
        for (int i: ints) {
            if (i == 1){
                oneCount++;
            }else if (i == 4){
                fourCount++;
            }
        }
        return oneCount != 0 && fourCount != 0;
    }
}
