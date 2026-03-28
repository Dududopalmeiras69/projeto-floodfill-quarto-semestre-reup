package render;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Renderizacao {

    private static int frameCount = 0;

    public static BufferedImage carregar(String caminho) throws Exception {
        return ImageIO.read(new File(caminho));
    }

    public static void desenharPixel(BufferedImage img, int x, int y, Color cor) {
        Graphics2D g = img.createGraphics();

        g.setColor(cor);
        g.fillRect(x, y, 1, 1); // desenha 1 pixel

        g.dispose(); // MUITO IMPORTANTE (evita leak)
    }

    public static void salvarFrame(BufferedImage img) {
        try {
            File dir = new File("frames");
            if (!dir.exists()) dir.mkdirs();

            String nome = String.format("frames/frame_%04d.png", frameCount++);
            ImageIO.write(img, "png", new File(nome));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void salvarFinal(BufferedImage img) throws Exception {
        ImageIO.write(img, "png", new File("saida.png"));
    }
}