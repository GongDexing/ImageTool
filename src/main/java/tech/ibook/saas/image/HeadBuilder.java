package tech.ibook.saas.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HeadBuilder {

    private BufferedImage templateImage;
    private Graphics2D templateG2D;
    private int templateWidth;
    private int templateHeight;

    public HeadBuilder(String bgRGB) {
        try {
            templateImage = ImageIO.read(new File("headbg.jpg"));
            templateG2D = templateImage.createGraphics();
            templateWidth = templateImage.getWidth();
            templateHeight = templateImage.getHeight();
            templateG2D.setBackground(Color.decode(bgRGB));
            templateG2D.clearRect(0, 0, templateWidth, templateHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HeadBuilder addName(String name, String rgb) {
        int x = templateWidth / 10;
        int y = templateHeight * 2 / 3;
        // templateG2D.translate(0, 100);
        // g2.rotate(Math.PI / 3);
        templateG2D.setFont(templateG2D.getFont().deriveFont(40f));
        templateG2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // templateG2D.setColor(Color.WHITE);
        templateG2D.setColor(Color.decode(rgb));
        templateG2D.drawString(name, x, y);
        return this;
    }

    public void build() {
        templateG2D.dispose();
        templateImage.flush();
        try {
            ImageIO.write(templateImage, "jpg", new File("head.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.gc();
    }
}
