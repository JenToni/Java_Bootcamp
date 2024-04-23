

public class Program    //Класс с методом main()
{
    public static void main(String[] args) {

        try {
            int counts = Integer.parseInt(args[0].substring("--count=".length()));
            Dispute dispute = new Dispute();
            Chicken chicken = new Chicken(counts,dispute);
            Egg egg = new Egg(counts,dispute);
            chicken.setName("chicken");
            egg.setName("egg");
            egg.start();
            chicken.start();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            System.exit(-1);
        }


    }
}