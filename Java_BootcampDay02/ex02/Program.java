import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Program {
    private static Path path;

    public static void main(String[] args) throws IOException {
        if(args.length < 1) {
            System.out.println("Must be path to the folder");
            System.exit(-1);
        }
        Scanner scanner = new Scanner(System.in);

        FileManager fileManager = new FileManager(Paths.get(args[0].substring("--current-folder=".length())));

        String input = scanner.nextLine();

        while (!input.equals("exit")) {
            String tokens[] = input.split(" ");
            if (tokens[0].equals("ls") && tokens.length == 1) {
                fileManager.listOfFiles();
            } else if (tokens[0].equals("cd") && tokens.length == 2){
                fileManager.changeDirectory(tokens[1]);
            }
            else if (tokens[0].equals("mv") && tokens.length  == 3) {
                fileManager.Move(tokens[1], tokens[2]);
            }
            input = scanner.nextLine();
        }

    }
}



