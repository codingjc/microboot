package org.springframework.boot;

import org.springframework.core.env.Environment;
import java.io.PrintStream;

/**
 * @author coding_jc
 * @date 2021/7/31
 */
@FunctionalInterface // 函数式接口
public interface Banner {


    /**
     * 通过指定的PrintStream（打印流）来实现启动Banner输出
     * @param environment 项目启动时指派的Profile
     * @param sourceClass 应用程序
     * @param out t实现Banner信息输出
     */
    void printBanner(Environment environment, Class<?> sourceClass, PrintStream out);

    /**
     * Banner启动模式
     */
    enum Mode {

        /**
         * 不显示banner的输出信息
         */
        OFF,

        /**
         * 在控制台输出banner
         */
        CONSOLE,

        /**
         * 在日志中输出banner
         */
        LOG

    }
}
