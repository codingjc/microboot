package cn.codingjc.action;

import cn.codingjc.config.VedioResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 视频类
 * @author coding_jc
 * @date 2021/9/5
 */
@RestController
@RequestMapping("/data/*")
public class VedioAction {

    @Autowired
    VedioResourceHttpRequestHandler vedioResourceHttpRequestHandler;

    @GetMapping("/vedio")
    public void createVedio (HttpServletRequest request, HttpServletResponse response) throws Exception{
        this.vedioResourceHttpRequestHandler.handleRequest(request, response);
    }
}
