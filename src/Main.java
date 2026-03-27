import algoritimo.*;
import render.*;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedImage img = Renderizacao.carregar("src/imagens/image.png");

            FloodFill.executarComPilha(img, 10, 10, 132);
            FloodFillFila.executarComFila(img, 10, 10, 444);

            Renderizacao.salvar(img, "saida.png");

            System.out.println("Flood Fill concluído!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}