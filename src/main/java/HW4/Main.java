package HW4;

public class Main {

    volatile Integer counter = 1;

    public static void main(String[] args) {
        firstTask();
    }

    public static void firstTask() {
        Main m = new Main();
        PrintA printA = new PrintA(m);
        PrintB printB = new PrintB(m);
        PrintC printC = new PrintC(m);
        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(printC).start();
    }
}
