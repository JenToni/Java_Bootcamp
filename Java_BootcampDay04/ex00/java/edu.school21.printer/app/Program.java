package edu.school21.printer.app;

import edu.school21.printer.logic.ImageConverter;

public class Program {

    public static void main(String[] args) {
        String imagePath;
        if (args.length == 1) {
            imagePath = args[0];

        } else {
            System.out.println("unknown error");
            return;
        }
        ImageConverter converter = new ImageConverter();
        String result = converter.convertImageToChars(imagePath);
        System.out.println(result);
    }
}