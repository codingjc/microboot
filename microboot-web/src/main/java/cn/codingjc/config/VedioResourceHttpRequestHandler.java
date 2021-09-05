package cn.codingjc.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 视频流处理类
 * @author coding_jc
 * @date 2021/9/5
 */
@Component
public class VedioResourceHttpRequestHandler extends ResourceHttpRequestHandler { // 请求处理视频

    @Override
    protected Resource getResource(HttpServletRequest request) throws IOException {
        return new ClassPathResource("/vedios/muyan.mp4");
    }
}
