package cn.codingjc.test;

import cn.codingjc.MicrobootWebBootApplication;
import cn.codingjc.action.MessageAction;
import cn.codingjc.config.DemoDataListener;
import cn.codingjc.entity.DemoData;
import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author coding_jc
 * @date 2021/8/8
 */
@ExtendWith(SpringExtension.class) // 使用junit5测试工具
@WebAppConfiguration // 启动WEB运行环境
@SpringBootTest(classes = MicrobootWebBootApplication.class) // 配置程序启动类
public class TestMessageTest {
    @Autowired
    private MessageAction messageAction;
    @BeforeAll
    public static void init(){
        System.out.println("【@beforeAll】TestMessageTest类开始执行初始化操作");
    }
    @AfterAll
    public static void after(){
        System.out.println("【@AfterAll】TestMessageTest类执行完毕");
    }
    @Test
    public void testEcho(){
        String content = this.messageAction.echo("Test");
        System.out.println("content = " + content);
        String value = "【输出】Test";
        Assertions.assertEquals(content, value); // 测试相等
    }

    @Test
    public void testEasyExcel(){
        DemoDataListener demoDataListener = new DemoDataListener();
        String fileName = "E:\\IDEAWorkSpace\\springboots\\microboot\\microboot-web\\src\\main\\resources\\名单.xlsx";
        EasyExcel.read(fileName, DemoData.class, demoDataListener).sheet(0).doRead();
        demoDataListener.getList().forEach(row -> System.out.println(row.toString()));
        System.out.println("demoDataListener.getList().size() = " + demoDataListener.getList().size());
    }

}
