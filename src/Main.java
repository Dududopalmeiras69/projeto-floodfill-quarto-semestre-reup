import algoritimo.*;
import render.*;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedImage imagem = Renderizacao.carregar("src/imagens/image.png");

            // Escolha qual executar:
            FloodFill.executarComPilha(imagem, 10, 10);
            // FloodFill.executarComFila(imagem, 10, 10);

            Renderizacao.salvar(imagem, "saida.png");

            System.out.println("Execução concluída!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}