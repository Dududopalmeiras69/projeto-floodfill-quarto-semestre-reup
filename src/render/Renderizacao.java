package render;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Renderizacao {

    public static BufferedImage carregar(String caminho) throws IOException {
        return ImageIO.read(new File(caminho));
    }

    public static void salvar(BufferedImage img, String caminho) throws IOException {
        ImageIO.write(img, "png", new File(caminho));
    }
}