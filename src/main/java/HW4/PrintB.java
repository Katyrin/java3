package HW4;

public class PrintB implements Runnable {
    private Main m;
    public PrintB(Main m){
        this.m = m;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (m){
                while(m.counter != 2){
                    try {
                        m.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                m.counter = 3;
                m.notifyAll();
            }
        }
    }
}
