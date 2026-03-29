import algoritmo.FloodFill;
import render.Renderizacao;
import render.Tela;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage img = Renderizacao.carregar("src/imagens/image.png");

            //Criação da Janela
            JFrame frame = new JFrame("Flood Fill");
            Tela tela = new Tela(img);

            frame.add(tela);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            //Execução Fila ou Pilha
            /*
            new Thread(() -> {
                FloodFill.executarComFila(img, 10, 10, tela);
                try {
                    Renderizacao.salvarFinal(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            */
            new Thread(() -> {
                FloodFill.executarComPilha(img, 10, 10, tela);
                try {
                    Renderizacao.salvarFinal(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}