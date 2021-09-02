package cn.codingjc.action;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PDF
 * @author coding_jc
 * @date 2021/8/31
 */
@Controller
@RequestMapping("/data/*")
public class PdfAction {

    @GetMapping("pdf")
    public void createPDFData(HttpServletResponse response) throws Exception {
        // 设置响应类型
        response.setHeader("Content-Type", "application/pdf");
        // 一般情况下可以将生成的PDF文件进行下载，所以此时是强制性的下载，并且配置下载文件名称
        response.setHeader("Content-Disposition", "attachement;filename=codingjc.pdf");
        // 使用ITextPDF组件来在内存中生成一份要生成的PDF文件
        Document document = new Document(PageSize.A4, 10, 10, 50, 20); // 设置页面大小
        PdfWriter.getInstance(document, response.getOutputStream()); //获取PDF的输出位置
        document.open(); // 开始构建PDF文档内容
        // 在当前程序内已经提供了图片的资源，利用资源匹配符进行资源路径定义
        Resource imageResource = new ClassPathResource("/images/mountains-5031782.jpg"); // Spring提供的资源访问
        Image image = Image.getInstance(imageResource.getFile().getAbsolutePath()); // 通过指定的路径加载图片
        // PDF文件进行生成的是很好是基于坐标的方式实现的绘制处理
        image.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight());
        float pointX = (PageSize.A4.getHeight() - image.getScaledWidth()) / 2;
        float pointY = PageSize.A4.getWidth() - image.getScaledHeight() - 100;
        image.setAbsolutePosition(pointX, pointY);
        document.add(image); // 追加图片到文档中
        document.add(new Paragraph("\n\n\n")); // 图片之后换三行输出文字
        // 如果要输出文字，而且想输出中文，必须设置字库
        Resource fintResource = new ClassPathResource("/fonts/Alibaba-PuHuiTi-Bold.ttf"); // 字体资源
        BaseFont baseFont = BaseFont.createFont(fintResource.getFile().getAbsolutePath()
                , BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont, 20, Font.NORMAL);
        // 绘制文本信息
        String[] titles = new String[]{"SpringBoot教学", "学习才有未来", "努力努力"};
        String[] content = new String[]{"codingjc.github.io", "codingboy", "gogogo"};
        for (int i = 0; i < titles.length; i++) {
            PdfPTable table = new PdfPTable(2); // 定义表格行
            PdfPCell cell = new PdfPCell(); // 创建单元格
            cell.setPhrase(new Paragraph(titles[i], font));
            table.addCell(cell);
            cell = new PdfPCell();
            cell.setPhrase(new Paragraph(content[i], font));
            table.addCell(cell);
            document.add(table);
        }
        document.close();
    }
}
