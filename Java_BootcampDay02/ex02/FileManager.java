import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileManager {


        private Path currentFolder;

        public FileManager(Path currentFolder){
            this.currentFolder = currentFolder;
        }
        public void listOfFiles() throws IOException {
        File dir = new File(currentFolder.toString());
        File files[] = dir.listFiles();
        long size;
        for (File file : files) {
            if (file.isDirectory()){
                size = getDirectorySize(file) / 1024;
                System.out.println(file.getName() + "/ " + size + " KB");
            }
            else {
                size = file.length() / 1024;
                System.out.println(file.getName() + " " + size + " KB");

            }

        }


    }
    private static long getDirectorySize(File file) throws IOException {
        long size = 0;
        try (DirectoryStream<Path> files = Files.newDirectoryStream(file.toPath())) {
            for(Path tmp : files) {
                if(Files.isDirectory(tmp)) {
                    size += getDirectorySize(tmp.toFile());
                } else {
                    size += tmp.toFile().length();
                }
            }

        } catch (IOException io) {
            System.out.println(io);
        }
        return size;
    }
    public void changeDirectory(String comand){
            Path target = currentFolder.resolve(comand);
            currentFolder = target;
        }
    public void Move(String file, String targetFile) throws IOException {
        Path fromFile = currentFolder.resolve(file);
        Path toFile = currentFolder.resolve(targetFile);
        if(Files.exists(fromFile)) {
            if (!Files.isDirectory(toFile)) {
                Files.move(fromFile, toFile);
            } else if (Files.isDirectory(toFile)) {
                Files.move(fromFile, currentFolder.resolveSibling(toFile).resolve(file), StandardCopyOption.REPLACE_EXISTING);
            }

        } else {
            System.out.println("File " + fromFile + " doesn't exist");
        }
    }
}






