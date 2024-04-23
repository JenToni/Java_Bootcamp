import java.io.*;
import java.util.*;

public class Program {


    private static Set<String> UniqueWords = new HashSet<>();

    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Must be 2 files");
            System.exit(-1);
        }
        try {
            BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
            BufferedReader file2 = new BufferedReader(new FileReader(args[1]));
            faindUnique(file1);
            faindUnique(file2);

            file1 = new BufferedReader(new FileReader(args[0]));
            file2 = new BufferedReader(new FileReader(args[1]));

            int[] Array1 = new int[UniqueWords.size()];
            int[] Array2 = new int[UniqueWords.size()];

            List<String> uniqueStr = new ArrayList<>(UniqueWords);

            numberOccurrences(file1,Array1,uniqueStr);
            numberOccurrences(file2,Array2,uniqueStr);

            similarity(Array1,Array2);

        } catch (IOException e) {
            System.out.println(e);
        }

// Найти уникальные слова и потом в каждлм файлк почситать слоклько раз они повторяются
    }
    public static void faindUnique(BufferedReader file) throws IOException {
        String str;
        while((str = file.readLine()) != null) {
            str = str.replaceAll("\\p{Punct}", "");
            String[] words = str.split(" ");
            for(String word : words) {
                if(!word.isEmpty()) {
                    UniqueWords.add(word);

                }
            }
        }

    }
    public static void similarity( int[] Array1, int[] Array2){

        int Numerator = 0;
        for(int i = 0; i< Array1.length; i++){
            Numerator += (Array1[i] * Array2[i]);
        }
        double sqrtNum1 = 0;
        double sqrtNum2 = 0;
        for(int i = 0; i< Array1.length; i++){
            sqrtNum1 += (Array1[i] * Array1[i]);
            sqrtNum2 += (Array2[i] * Array2[i]);
        }
        double Denominator;
        Denominator = Math.sqrt(sqrtNum1) * Math.sqrt(sqrtNum2);

        double Similarity;
        Similarity = Numerator / Denominator;

        System.out.printf("Similarity = %.3f",Similarity );
    }
    public static void numberOccurrences(BufferedReader file, int[] Array1,List<String> uniqueStr) throws IOException {

        int i = 0;
        String str;
        while ((str = file.readLine()) != null) {
            str = str.replaceAll("\\p{Punct}", "");
            String[] words = str.split(" ");
            for (String word : words) {
                if (!word.isEmpty() && uniqueStr.contains(word)) {
                    i = uniqueStr.indexOf(word);
                    Array1[i]++;

                }
            }

        }

    }
}

