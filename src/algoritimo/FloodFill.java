package algoritimo;

import estrutura.*;
import imagens.*;
import java.awt.image.BufferedImage;
public class FloodFill {
    public static void executarComPilha(BufferedImage image, int x, int y, int newColor) {
        int oldColor = image.getRGB(x, y);
        if (oldColor == newColor);

        Pilha p = new Pilha();
        p.push(new Pixel(x, y));

        while (!p.espacoVazio()) {
            Pixel pixel = (Pixel) p.pop();

            if (pixel.x >= 0 && pixel.x < image.getWidth() && pixel.y >= 0 && pixel.y < image.getHeight()) {
                if (image.getRGB(pixel.x, pixel.y) == oldColor) {
                    image.setRGB(pixel.x, pixel.y, newColor);

                    p.push(new Pixel(pixel.x + 1, pixel.y));
                    p.push(new Pixel(pixel.x - 1, pixel.y));
                    p.push(new Pixel(pixel.x, pixel.y + 1));
                    p.push(new Pixel(pixel.x, pixel.y - 1));
                }
                }
            }
    }
    }