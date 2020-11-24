package HW4;

public class PrintA implements Runnable {
    private Main m;
    public PrintA(Main m){
        this.m = m;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (m){
                while(m.counter != 1){
                    try {
                        m.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                m.counter = 2;
                m.notifyAll();
            }
        }
    }
}
