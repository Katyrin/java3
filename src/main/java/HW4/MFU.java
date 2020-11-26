package HW4;

public class MFU {
    final Object firstMonitor = new Object();
    final Object secondMonitor = new Object();

    private void print(int str){
        synchronized (firstMonitor){
            System.out.println("print: " + str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void copy(int str){
        synchronized (secondMonitor){
            synchronized (firstMonitor){
                System.out.println("copy: " + str);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void scanner(int str){
        synchronized (secondMonitor){
            System.out.println("scanner: " + str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    mfu.print(1);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    mfu.scanner(2);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    mfu.copy(3);
                }
            }
        }).start();

    }
}
