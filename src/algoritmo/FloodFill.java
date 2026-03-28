package algoritmo;

import estrutura.Fila;
import estrutura.Pilha;
import imagens.Pixel;
import render.Renderizacao;
import render.Tela;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFill {

    //algoritimo de Pilhas
    public static void executarComPilha(BufferedImage imagem, int x, int y, Tela tela) {

        int controleMagenta = imagem.getRGB(x, y);
        Color novaCor = new Color(123, 45, 167);

        Pilha<Pixel> pilha = new Pilha<>();
        Pixel pixelSentinela = new Pixel(x, y);

        pilha.push(pixelSentinela);

        int contador = 0;

        while (!pilha.estaVazia()) {
            Pixel atual = pilha.pop();
            if (atual == null) continue;

            // limites
            if (atual.x < 0 || atual.x >= imagem.getWidth() ||
                    atual.y < 0 || atual.y >= imagem.getHeight()) continue;

            // cor diferente → ignora
            if (imagem.getRGB(atual.x, atual.y) != controleMagenta) continue;

            // desenha com Graphics2D
            Renderizacao.desenharPixel(imagem, atual.x, atual.y, novaCor);

            // animação
            if (contador++ % 30 == 0) {
                tela.atualizar(imagem);

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // vizinhos (DFS)
            pilha.push(new Pixel(atual.x + 1, atual.y));
            pilha.push(new Pixel(atual.x - 1, atual.y));
            pilha.push(new Pixel(atual.x, atual.y + 1));
            pilha.push(new Pixel(atual.x, atual.y - 1));
        }

        tela.atualizar(imagem);
    }

    // algoritmo de Filas
    public static void executarComFila(BufferedImage imagem, int x, int y, Tela tela) {

        int controleMagenta = imagem.getRGB(x, y);
        Color novaCor = new Color(123, 45, 167);

        Fila<Pixel> filaPrimariaExecucao = new Fila<>();
        Pixel pixelSentinela = new Pixel(x, y);

        filaPrimariaExecucao.enqueue(pixelSentinela);

        int contador = 0;

        while (!filaPrimariaExecucao.estaVazia()) {
            Pixel atual = filaPrimariaExecucao.dequeue();
            if (atual == null) continue;

            // limites
            if (atual.x < 0 || atual.x >= imagem.getWidth() ||
                    atual.y < 0 || atual.y >= imagem.getHeight()) continue;

            // cor diferente → ignora
            if (imagem.getRGB(atual.x, atual.y) != controleMagenta) continue;

            // desenha
            Renderizacao.desenharPixel(imagem, atual.x, atual.y, novaCor);

            // animação
            if (contador++ % 30 == 0) {
                tela.atualizar(imagem);

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // vizinhos (BFS)
            filaPrimariaExecucao.enqueue(new Pixel(atual.x + 1, atual.y));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x - 1, atual.y));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x, atual.y + 1));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x, atual.y - 1));
        }

        tela.atualizar(imagem);
    }
}