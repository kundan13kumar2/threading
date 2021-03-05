public class Print3Threads {

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintSequenceNumber3(1),"T1");
        Thread t2 = new Thread(new PrintSequenceNumber3(2),"T2");
        Thread t3 = new Thread(new PrintSequenceNumber3(0),"T3");

        t1.start();
        t2.start();
        t3.start();


    }
}
