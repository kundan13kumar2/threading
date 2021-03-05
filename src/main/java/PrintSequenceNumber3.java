public class PrintSequenceNumber3 implements Runnable {

    static int number = 1;
    static final Object lock = new Object();
    int rem;

    PrintSequenceNumber3(int rem) {
        this.rem = rem;
    }

    @Override
    public void run() {
        while (number < 100) {
            synchronized (lock) {
                while (number % 3 != rem) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}
