public class Egg extends Thread {

    Dispute dispute;
    private final int count;
    Thread tEgg;
    Egg(int count, Dispute dispute ) {
        this.count = count;
        this.dispute = dispute;
        tEgg = new Thread();

    }
    @Override
    public void run()
    {
        for(int i = 0; i < count; i++)
        {
            try {
                dispute.printEgg();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
