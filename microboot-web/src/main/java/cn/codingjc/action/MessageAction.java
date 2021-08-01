package cn.codingjc.action;

import cn.codingjc.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coding_jc
 * @date 2021/8/1
 */
@RestController
@RequestMapping("/message/*")
public class MessageAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageAction.class);

    @Autowired
    private IMessageService messageService;

    @RequestMapping("echo")
    public String echo(String msg){
        LOGGER.info("Achieve param is {}", msg);
        return messageService.echo(msg);
    }
}
