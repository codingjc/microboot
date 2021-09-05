package cn.codingjc.action;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 处理图像处理类(添加图片转换器)
 * @author coding_jc
 * @date 2021/9/5
 */
@RestController
@RequestMapping("/data/*")
public class ImageAction {

    @GetMapping(value = "image", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public BufferedImage createImageData() throws IOException { // 进行图像创建
        // 图片加载
        Resource resource = new ClassPathResource("/images/mountains-5031782.jpg");
        // 实现文件加载
        return ImageIO.read(resource.getInputStream());
    }
}
