package cn.codingjc.action;

import org.apache.catalina.webresources.FileResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件下载
 * @author shenjicheng
 * @create 2021/11/20 10:11 上午
 */
@RestController
@RequestMapping("/data/*")
public class DownloadAction {

    @GetMapping("download")
    public void fileDownload(HttpServletResponse response) throws Exception {
        // 强制性下载
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachement;filename=yooth.zip");
        Resource resource = new ClassPathResource("/file/darwin_amd64.zip");
        InputStream inputStream = resource.getInputStream();
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(data)) != -1) {
            response.getOutputStream().write(data, 0, len);
        }

    }
}
