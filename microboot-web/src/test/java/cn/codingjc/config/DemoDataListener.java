package cn.codingjc.config;

import cn.codingjc.entity.DemoData;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听器
 * @author coding_jc
 * @date 2021/8/8
 */
@Configuration
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
    private static final int BATCH_COUNT = 5;
    ObjectMapper objectMapper = new ObjectMapper();

    List<DemoData> list = new ArrayList<>();
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        try {
            LOGGER.info("【解析到一条数据】:{}" + objectMapper.writeValueAsString(data));
            list.add(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        LOGGER.info("解析结束");
    }

    public List<DemoData> getList() {
        return list;
    }
}
