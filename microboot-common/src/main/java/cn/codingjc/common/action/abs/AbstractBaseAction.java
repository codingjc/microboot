package cn.codingjc.common.action.abs;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author shenjicheng
 * @create 2021/8/22 10:25 上午
 */
public abstract class AbstractBaseAction { // 定义公共的action类

    // 在现在的开发中如果要将字符串转换为日期时间，考虑到多线程环境下并发问题，所以一定要使用LocalDate
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(java.util.Date.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                LocalDate localDate = LocalDate.parse(text, DATE_TIME_FORMATTER);
                Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
                super.setValue(java.util.Date.from(instant));
            }
        });

    }

}
