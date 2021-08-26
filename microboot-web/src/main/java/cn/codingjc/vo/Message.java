package cn.codingjc.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author coding_jc
 * @date 2021/8/13
 */
@Data
public class Message {
    private String title;
//    @JSONField(format = "yyyy年MM月dd日")
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date pubdate;
    private String content;
}
