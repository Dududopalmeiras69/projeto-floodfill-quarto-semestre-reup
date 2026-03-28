import algoritmo.*;
import render.*;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage img = Renderizacao.carregar("src/imagens/image.png");

            FloodFill.executarComFila(img, 10, 10);
            // FloodFill.executarComPilha(img, 10, 10);

            Renderizacao.salvarFinal(img);

            System.out.println("Flood Fill finalizado com animação!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}