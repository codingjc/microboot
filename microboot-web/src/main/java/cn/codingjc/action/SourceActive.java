package cn.codingjc.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 属性注入
 * @author shenjicheng
 * @create 2021/9/9 11:41 下午
 */
@Slf4j
@RestController
@RequestMapping("/source")
public class SourceActive {

    @Value("${source.mysql}")
    private String mysql;

    @Value("${source.redis}")
    private String redis;

    @Value("${source.message}")
    private List<String> list;

    @Value("#{${source.infos}}")
    private Map<String, String> map;

    @GetMapping("/printValue")
    public void printValue(){
        log.info("[SourceActive][getValue] mysql: {}", mysql);
        log.info("[SourceActive][getValue] redis: {}", redis);
        log.info("[SourceActive][getValue] list: {}", list);
        log.info("[SourceActive][getValue] map: {}", map);
    }
}
