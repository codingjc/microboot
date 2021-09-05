package cn.codingjc.action;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import cn.codingjc.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author coding_jc
 * @date 2021/9/2
 */
@Slf4j
@RestController
@RequestMapping("/excel/*")
public class ExcelAction {

    @GetMapping("export")
    public void export(HttpServletResponse response){
        // 响应类型
        response.setHeader("Content-Type",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachement;filename=codingjc.xls");
        // 通过固定数据循环方式生成excel数据
        String[] titles = new String[]{"大华技术", "大华系统", "大华股份"};
        String[] contents = new String[]{"www.codingjc.com", "www.aaa.com", "www.b.com"};
        // 数据生成需要将数据保存在Message类的对象中
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            Message message = new Message();
            message.setTitle(titles[i]);
            message.setPubdate(new Date());
            message.setContent(contents[i]);
            messageList.add(message);
        }
        // 进行xls文件配置
        ExportParams exportParams = new ExportParams("大华技术", "最新消息", ExcelType.XSSF);
        // 创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        new ExcelExportService().createSheet(workbook, exportParams, Message.class, messageList);
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("export excel error", e);
        }
    }
}
