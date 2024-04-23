package edu.school21.printer.logic;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter {
    private Attribute white;
    private Attribute black;
    public ImageConverter (Jargs args){
        this.white = args.getWhite();
        this.black = args.getBlack();
    }
    public String convertImageToChars(String imagePath)  {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x, y);
                if (color == Color.WHITE.getRGB()) {
                    result.append(colorize(" ", white));
                } else {
                    result.append(colorize(" ", black));
                }
            }
            result.append("\n");
        }

        return result.toString();

    }
}
