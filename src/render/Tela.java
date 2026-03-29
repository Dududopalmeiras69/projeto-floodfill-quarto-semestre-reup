package render;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tela extends JPanel {

    private BufferedImage imagem;

    public Tela(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public void atualizar(BufferedImage imagem) {
        this.imagem = imagem;
        repaint();
    }
    //Define a posição a qual a camera vai olhar
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagem != null) {
            g.drawImage(imagem, 0, 0, null);
        }
    }
    //Ajusta o tamanho da tela com base no tamanho da imagem
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imagem.getWidth(), imagem.getHeight());
    }
}