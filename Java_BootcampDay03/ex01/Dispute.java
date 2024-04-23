public class Dispute {
    private enum Category {
        EGG, HEN
    }

    private static Category category = Category.EGG;

    public synchronized void printEgg( ) throws InterruptedException {
        if (category != Category.EGG) {
            wait();
        }
        System.out.println("Egg");
        category = Category.HEN;
        notify();
    }
    public synchronized void printChicken() throws InterruptedException  {
        if (category != Category.HEN) {
            wait();
        }
        System.out.println("Hen");
        category = Category.EGG;
        notify();
    }
}