package HW8;

public class Main {
    private static final int SIZE = 7;
    public static void main(String[] args) {
        int[][] ints = new int[SIZE][SIZE];
        snakeMatrix(ints);

        for (int[] anInt : ints) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(anInt[j] + " ");
            }
            System.out.println();
        }
    }

    private static void snakeMatrix(int[][] arr){
        int count = 1;
        int x = 0;
        int y = 0;
        boolean isExistNull = true;
        while (isExistNull){
            isExistNull = false;
            for (int i = 0; i < SIZE; i++) {
                if (arr[y][i] == 0) {
                    isExistNull = true;
                    arr[y][i] = count++;
                    x = i;
                }
            }
            for (int i = 0; i < SIZE; i++) {
                if (arr[i][x] == 0) {
                    isExistNull = true;
                    arr[i][x] = count++;
                    y = i;
                }
            }
            for (int i = SIZE-1; i >= 0; i--) {
                if (arr[y][i] == 0) {
                    isExistNull = true;
                    arr[y][i] = count++;
                    x = i;
                }
            }
            for (int i = SIZE-1; i >= 0; i--) {
                if (arr[i][x] == 0) {
                    isExistNull = true;
                    arr[i][x] = count++;
                    y = i;
                }
            }
        }
    }
}
