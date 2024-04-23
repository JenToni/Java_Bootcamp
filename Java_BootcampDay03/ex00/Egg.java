public class Egg extends Thread {

    private final int count;
    Thread tEgg;
    Egg( int count) {
        this.count = count;
        tEgg = new Thread(this);
    }

    @Override
    public void run()
    {
        for(int i = 0; i < count; i++)
        {
            try{
                sleep(1000);
            }catch(InterruptedException e){}

            System.out.println(Thread.currentThread() + "Яйцо!");
        }

    }
}
