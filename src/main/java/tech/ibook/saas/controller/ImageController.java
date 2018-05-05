package tech.ibook.saas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.ibook.saas.service.ImageService;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(path = "/poster/create", method = RequestMethod.POST)
    public String posterCreate(@RequestParam final String nickname,
            @RequestParam final String headImageUrl, String qrcodeText) {
        return imageService.posterCreate(nickname, headImageUrl, qrcodeText);
    }

    @RequestMapping(path = "/head/create", method = RequestMethod.POST)
    public String headCreate(@RequestParam final String name, @RequestParam final String rgb,
            @RequestParam final String bgRGB) {
        return imageService.headCreate(name, rgb, bgRGB);
    }
}
