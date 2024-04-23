import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    static int ds;

    public static void main(String[] args) {

        int arraySize = Integer.parseInt(args[0].substring("--arraySize=".length()));
        int threadsCount = Integer.parseInt(args[1].substring("--threadsCount=".length()));

        SecureRandom secureRandom = new SecureRandom();

        int[] arrayInt = new int[arraySize];

        int number;
        for(int i = 0 ; i < arrayInt.length; i++){
            number = secureRandom.nextInt(1_000);
            if (number % 2 == 0){
                number *=-1;
            }
            arrayInt[i] = number;
        }

        int answer = 0;
        for(int i : arrayInt){
            answer += i;
        }
        System.out.println("Sum: " + answer);

        Thread[] threads = new Thread[threadsCount];
        int step = arraySize / threadsCount;
        for (int i = 0; i < threadsCount ; i++){
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                int start = threadIndex * step;
                int end = (threadIndex == threadsCount - 1) ? arraySize : start + step;
                long threadSum = 0;
                for (int j = start ; j < end;  j ++){
                    threadSum += arrayInt[j];
                    ds += arrayInt[j];
                }
                System.out.println("Thread " + threadIndex + ": from " + start + " to " + end + " sum is  " + threadSum);

            });
            threads[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Sum by threads: "+ ds);







    }
}
