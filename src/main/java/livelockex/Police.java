package livelockex;

public class Police {

        private boolean moneySent=false;
        public void giveRansom(Criminal criminal){
            while (!criminal.isHostageReleased()){
                System.out.println("Waiting police to be hostage released");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            moneySent=true;
        }

    public boolean isMoneySent() {
        return moneySent;
    }
}
