package cn.codingjc.vo;

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
    private String title;
//    @XmlElement
//    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date pubdate;
//    @XmlElement
    private String content;
}
