package tech.ibook.saas.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PosterBuilder {
    private BufferedImage templateImage;
    private Graphics2D templateG2D;
    private int templateWidth;
    private int templateHeight;

    public PosterBuilder() {
        try {
            templateImage = ImageIO.read(new File("posterbg.jpg"));
            templateG2D = templateImage.createGraphics();
            templateWidth = templateImage.getWidth();
            templateHeight = templateImage.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PosterBuilder addQrcode(BufferedImage qrcodeImage) {
        int x = templateWidth * 3 / 8;
        int y = templateHeight * 3 / 4;
        int width = templateWidth / 4;
        int height = templateWidth / 4;
        templateG2D.drawImage(qrcodeImage, x, y, width, height, null);
        // 画二维码边框
        // BasicStroke stroke = new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        // // 设置笔画对象
        // templateG2D.setStroke(stroke);
        // templateG2D.setColor(Color.RED);
        // templateG2D.drawRect(x, y, width, height);
        return this;
    }

    public PosterBuilder addHeadImage(BufferedImage headImage) {
        int x = templateWidth / 20;
        int y = templateWidth / 20;
        int width = templateWidth / 8;
        int height = templateWidth / 8;
        Ellipse2D.Double shape = new Ellipse2D.Double(x, y, width, height);
        // templateG2D.fill(new Rectangle(templateWidth, templateWidth));
        templateG2D.setClip(shape);
        templateG2D.drawImage(headImage, x, y, width, height, null);
        return this;
    }

    public PosterBuilder addNickname(String nickname) {
        int x = templateWidth / 5;
        int y = templateWidth / 10 + 20;
        // templateG2D.translate(0, 100);
        // g2.rotate(Math.PI / 3);
        templateG2D.setFont(templateG2D.getFont().deriveFont(25f));
        templateG2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        templateG2D.setColor(Color.RED);
        templateG2D.drawString(nickname, x, y);
        return this;
    }

    public void build() {
        templateG2D.dispose();
        templateImage.flush();
        try {
            ImageIO.write(templateImage, "jpg", new File("poster.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.gc();
    }

}
