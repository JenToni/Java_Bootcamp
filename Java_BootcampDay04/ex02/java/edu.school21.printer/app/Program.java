package edu.school21.printer.app;

import edu.school21.printer.logic.ImageConverter;
import edu.school21.printer.logic.Jargs;

import com.beust.jcommander.JCommander;



public class Program {
    private static String imagePath;

    public static void main(String[] args) {
        Jargs arguments = new Jargs();

        JCommander.newBuilder().addObject(arguments).build().parse(args);

        ImageConverter converter = new ImageConverter(arguments);

        String result = converter.convertImageToChars("C:/Users/anton/Desktop/Java/Java_Bootcamp.Day04-1/src/ex02/resources/it.bmp");
        System.out.println(result);
    }
}