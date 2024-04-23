public class Chicken extends Thread {


    private final int count;
    Thread tChicken;
    Chicken(int count) {
        this.count = count;
        tChicken = new Thread(this);
    }

    @Override
    public void run()
    {
        for(int i = 0; i < count; i++)
        {
            try{
                sleep(1000);
            }catch(InterruptedException e){}

            System.out.println(Thread.currentThread() + "Курица!");
        }

    }
}
