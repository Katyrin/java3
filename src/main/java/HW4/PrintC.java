package HW4;

public class PrintC implements Runnable {
    private Main m;
    public PrintC(Main m){
        this.m = m;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (m){
                while(m.counter != 3){
                    try {
                        m.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                m.counter = 1;
                m.notifyAll();
            }
        }
    }
}
