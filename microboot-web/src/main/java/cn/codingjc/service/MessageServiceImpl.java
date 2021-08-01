package cn.codingjc.service;


/**
 * @author coding_jc
 * @date 2021/8/1
 */
public class MessageServiceImpl implements IMessageService{
    @Override
    public String echo(String msg) {
        return "【输出】" + msg;
    }
}
