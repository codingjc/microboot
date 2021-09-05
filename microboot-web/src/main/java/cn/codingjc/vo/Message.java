package cn.codingjc.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author coding_jc
 * @date 2021/8/13
 */
@Data
//@XmlRootElement   // 配置XML根元素
public class Message {
//    @XmlElement
    @Excel(name = "标题", orderNum = "0", width = 30) // 生成Excel表格的配置
    private String title;
//    @XmlElement
//    @JsonFormat(pattern = "yyyy年MM月dd日")
    @Excel(name = "日期", orderNum = "1", width = 50)
    private Date pubdate;
//    @XmlElement
    @Excel(name = "内容", orderNum = "2", width = 100)
    private String content;
}
