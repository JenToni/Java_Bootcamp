import java.util.*;
import java.io.*;

public class Program {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File file = new File("kkkk/signatures.txt");
        System.out.println(file.getAbsolutePath());
        FileInputStream inputStream = new FileInputStream("kkkk/signatures.txt");

        FileOutputStream outputStream = new FileOutputStream("result.txt", true);
        Map<String, String> map = new HashMap<>();

        PreparingSignature(inputStream, map);
        faindSignature(outputStream, map);
    }

    public static void PreparingSignature(FileInputStream inputStream, Map<String, String> map) {
        scanner = new Scanner(inputStream);
        String line = new String();
        String[] lines = new String[2];
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            lines = line.split(", ");
            map.put(lines[0], lines[1]);
        }
    }
    private static void faindSignature(FileOutputStream outputStream, Map<String, String> map) throws IOException {
        String path;
        scanner = new Scanner(System.in);
        System.out.print("Write the absolute path to the file -> ");
        path = scanner.next();

        while (!path.equals("42")) {
            try (FileInputStream fileTo = new FileInputStream(path)) {
                StringBuffer bytes = new StringBuffer();
                for (int i = 0; i < 8; i++) {
                    bytes.append(String.format("%02X ", fileTo.read()));
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue().equals(bytes.toString().substring(0, entry.getValue().length()))) {
                        System.out.println("PROCESSED");
                        outputStream.write(entry.getKey().getBytes());
                        outputStream.write('\n');
                    }
                }

            } catch (IOException e) {
                System.out.println("Error reading file");

            }
            System.out.print("Write the absolute path to the file -> ");
            path = scanner.next();
        }
    }
}
