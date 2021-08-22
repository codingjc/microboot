package cn.codingjc.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author shenjicheng
 * @create 2021/8/22 9:38 上午
 */
@Data
@Slf4j
@AllArgsConstructor
public class SaleTicket {

    private int count;

    @SneakyThrows
    @Synchronized
    public void sale () {
        while (count > 0) {
            if (count > 0) {
                TimeUnit.SECONDS.sleep(1);
                log.info("线程: {} 售票了, ticket: {}", Thread.currentThread().getName(), count--);
            }
        }
    }
}
