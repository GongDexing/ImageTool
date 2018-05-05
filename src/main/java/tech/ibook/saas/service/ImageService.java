package tech.ibook.saas.service;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import tech.ibook.saas.image.HeadBuilder;
import tech.ibook.saas.image.PosterBuilder;
import tech.ibook.saas.image.ZXingFactory;

@Service
public class ImageService {

    public String posterCreate(String nickname, String headImageUrl, String qrcodeText) {
        BufferedImage headImage;
        try {
            URL url = new URL(headImageUrl);
            InputStream is = url.openConnection().getInputStream();
            headImage = ImageIO.read(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "headeImage url is invaild!";
        }
        BufferedImage qrcodeImage = ZXingFactory.createQrcodeImage(qrcodeText);
        new PosterBuilder().addNickname(nickname).addQrcode(qrcodeImage).addHeadImage(headImage)
                .build();
        return "success";
    }

    public String headCreate(String name, String rgb, String bgRGB) {
        if (!rgb.matches("#[0-9A-F]{6}")) {
            return "rgb is invaild";
        }
        if (!bgRGB.matches("#[0-9A-F]{6}")) {
            return "bgRGB is invaild";
        }
        String displayName = name.length() > 2 ? name.substring(name.length() - 2) : name;
        new HeadBuilder(bgRGB).addName(displayName, rgb).build();
        return "success";
    }

}
