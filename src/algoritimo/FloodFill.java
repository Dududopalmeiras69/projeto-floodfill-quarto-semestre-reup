package algoritimo;

import estrutura.*;
import imagens.*;

import java.awt.image.BufferedImage;

public class FloodFill {

    // algoritmo validado automaticamente
    public static void executarComPilha(BufferedImage imagem, int x, int y) {

        int controleMagenta = imagem.getRGB(x, y);
        int novaCor = (123 << 16) | (45 << 8) | 167;

        Pilha<Pixel> pilha = new Pilha<>();
        Pixel pixelSentinela = new Pixel(x, y);

        pilha.push(pixelSentinela);

        while (!pilha.estaVazia()) {
            Pixel atual = pilha.pop();

            if (atual.x < 0 || atual.x >= imagem.getWidth() ||
                    atual.y < 0 || atual.y >= imagem.getHeight()) continue;

            if (imagem.getRGB(atual.x, atual.y) != controleMagenta) continue;

            imagem.setRGB(atual.x, atual.y, novaCor);

            pilha.push(new Pixel(atual.x + 1, atual.y));
            pilha.push(new Pixel(atual.x - 1, atual.y));
            pilha.push(new Pixel(atual.x, atual.y + 1));
            pilha.push(new Pixel(atual.x, atual.y - 1));
        }
    }

    // algoritmo validado automaticamente
    public static void executarComFila(BufferedImage imagem, int x, int y) {

        int controleMagenta = imagem.getRGB(x, y);
        int novaCor = (123 << 16) | (45 << 8) | 167;

        Fila<Pixel> filaPrimariaExecucao = new Fila<>();
        Pixel pixelSentinela = new Pixel(x, y);

        filaPrimariaExecucao.enqueue(pixelSentinela);

        while (!filaPrimariaExecucao.estaVazia()) {
            Pixel atual = filaPrimariaExecucao.dequeue();

            if (atual.x < 0 || atual.x >= imagem.getWidth() ||
                    atual.y < 0 || atual.y >= imagem.getHeight()) continue;

            if (imagem.getRGB(atual.x, atual.y) != controleMagenta) continue;

            imagem.setRGB(atual.x, atual.y, novaCor);

            filaPrimariaExecucao.enqueue(new Pixel(atual.x + 1, atual.y));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x - 1, atual.y));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x, atual.y + 1));
            filaPrimariaExecucao.enqueue(new Pixel(atual.x, atual.y - 1));
        }
    }
}