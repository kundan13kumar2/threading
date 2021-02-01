package livelockex;

public class Criminal {

    private boolean hostageReleased = false;

    public void releaseHostage(Police police) {
        while (!police.isMoneySent()) {
            System.out.println("Waiting of police to send money");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hostageReleased = true;
    }

    public boolean isHostageReleased() {
        return hostageReleased;
    }
}
