

public class Program    //Класс с методом main()
{
    public static void main(String[] args) {

        try {
            int counts = Integer.parseInt(args[0].substring("--count=".length(), args[0].length()));
            Chicken chicken = new Chicken(counts);
            Egg egg = new Egg(counts);
            egg.start();
            chicken.start();
            chicken.join();
            egg.join();
            for (int i = 0; i < counts; i++) {
                System.out.println(Thread.currentThread() + "Human");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            System.exit(-1);
        }


    }
}