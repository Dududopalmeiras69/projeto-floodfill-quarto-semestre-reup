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

            //bordas de pintura
            if (atual.x < 0 || atual.x >= imagem.getWidth() ||
                    atual.y < 0 || atual.y >= imagem.getHeight()) continue;

            if (imagem.getRGB(atual.x, atual.y) != controleMagenta) continue;

            Renderizacao.desenharPixel(imagem, atual.x, atual.y, novaCor);

            //animação da pintura
            if (contador++ % 120 == 0) {
                tela.atualizar(imagem);

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //movimento do flood
            pilha.push(new Pixel(atual.x, atual.y - 1)); // cima
            pilha.push(new Pixel(atual.x + 1, atual.y)); // direita
            pilha.push(new Pixel(atual.x, atual.y + 1)); // baixo
            pilha.push(new Pixel(atual.x - 1, atual.y)); // esquerda
        }

        tela.atualizar(imagem);
    }

    //Processo com filas
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

            if (atual.x < 0 || atual.x >= imagem.getWidth() ||
                    atual.y < 0 || atual.y >= imagem.getHeight()) continue;

            if (imagem.getRGB(atual.x, atual.y) != controleMagenta) continue;

            Renderizacao.desenharPixel(imagem, atual.x, atual.y, novaCor);

            if (contador++ % 120 == 0) {
                tela.atualizar(imagem);

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            filaPrimariaExecucao.enqueue(new Pixel(atual.x + 1, atual.y));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x - 1, atual.y));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x, atual.y + 1));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x, atual.y - 1));
        }

        tela.atualizar(imagem);
    }
}