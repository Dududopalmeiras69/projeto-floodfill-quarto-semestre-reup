package algoritimo;

import java.awt.image.BufferedImage;
import estrutura.*;
import imagens.*;

public class FloodFillFila {
    public static void executarComFila(BufferedImage image, int x, int y, int newColor) {
            int oldColor = image.getRGB(x, y);
            if (oldColor == newColor);

            Fila f = new Fila();
            f.offer(new Pixel(x, y));

            while (!f.espacoVazio()) {
                Pixel pp = (Pixel) f.poll();

                if (pp.x >= 0 && pp.x < image.getWidth() && pp.y >= 0 && pp.y < image.getHeight()) {
                    if (image.getRGB(pp.x, pp.y) == oldColor) {
                        image.setRGB(pp.x, pp.y, newColor);

                        f.offer(new Pixel(pp.x + 1, pp.y));
                        f.offer(new Pixel(pp.x - 1, pp.y));
                        f.offer(new Pixel(pp.x, pp.y + 1));
                        f.offer(new Pixel(pp.x, pp.y - 1));
                    }
                }
            }
        }
    }
