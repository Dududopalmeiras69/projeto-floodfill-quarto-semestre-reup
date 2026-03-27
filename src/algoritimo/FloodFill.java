package algoritimo;
import estrutura.*;
import imagens.*;
import java.awt.image.BufferedImage;
public class FloodFill() {

    public BufferedImage floodFill(BufferedImage image, int x, int y, int newColor) {
        int oldColor = image.getRGB(x, y);
        if (oldColor == newColor) return image;

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
                Fila f = new Fila();
                f.offer(new Pixel(x, y));

                while (!f.espacoVazio()) {
                    Pixel pp = (Pixel) f.poll();

                    if (pp.x >= 0 && pixel.x < image.getWidth() && pp.y >= 0 && pixel.y < image.getHeight()) {
                        if (image.getRGB(pp.x, pp.y) == oldColor) {
                            image.setRGB(pp.x, pp.y, newColor);

                            // Empilha os 4 vizinhos laterais [cite: 15]
                            f.offer(new Pixel(pp.x + 1, pp.y));
                            f.offer(new Pixel(pp.x - 1, pp.y));
                            f.offer(new Pixel(pp.x, pp.y + 1));
                            f.offer(new Pixel(pp.x, pp.y - 1));
                        }
                    }
                    return image;
                }
            }
        }
        return image;
    }
}