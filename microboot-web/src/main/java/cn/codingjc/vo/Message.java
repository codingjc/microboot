package cn.codingjc.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author coding_jc
 * @date 2021/8/13
 */
@Data
public class Message {
    private String title;
    private Date pubdate;
    private String content;
}
