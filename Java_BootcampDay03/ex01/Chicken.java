public class Chicken extends Thread {

    Dispute dispute;
    private final int count;
    Thread tChicken;

    Chicken(int count, Dispute dispute ) {
        this.count = count;
        this.dispute = dispute;
        tChicken = new Thread();
    }

    @Override
    public void run()
    {
        for(int i = 0; i < count; i++)
        {
            try {
                dispute.printChicken();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
