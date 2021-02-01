package livelockex;

public class TestLiveLock {


    public static void main(String[] args) {
        Police police = new Police();
        Criminal criminal = new Criminal();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                police.giveRansom(criminal);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                criminal.releaseHostage(police);
            }
        });
        t1.start();
        t2.start();
    }
}
