package edu.school21.printer.app;

import edu.school21.printer.logic.ImageConverter;

public class Program {
    public static void main(String[] args) {

        ImageConverter converter = new ImageConverter();
        String result = converter.convertImageToChars("resources/it.bmp");
        System.out.println(result);
    }
}