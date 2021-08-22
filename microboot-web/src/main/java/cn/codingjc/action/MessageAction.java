package cn.codingjc.action;

import cn.codingjc.common.action.abs.AbstractBaseAction;
import cn.codingjc.service.IMessageService;
import cn.codingjc.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coding_jc
 * @date 2021/8/1
 */
@RestController
@RequestMapping("/message/*")
public class MessageAction extends AbstractBaseAction {


    @Autowired
    private IMessageService messageService;

    @RequestMapping("echo")
    public Object echo(Message message){
        message.setTitle("【Echo】" + message.getTitle());
        message.setContent("【Echo】" + message.getContent());
        return message;
    }
}
