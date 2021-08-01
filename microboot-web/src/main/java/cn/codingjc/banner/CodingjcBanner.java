package cn.codingjc.banner;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Random;

/**
 * 实现自定义的Banner输出
 * @author coding_jc
 * @date 2021/7/31
 */
public class CodingjcBanner implements Banner {
    // 所有的Banner信息如果时复合的结构必须使用数组进行配置
    private static final String [] CODINGJC_BANNER1 = {
            "   _____          _ _              _      ",
            "  / ____|        | (_)            (_)     ",
            " | |     ___   __| |_ _ __   __ _  _  ___ ",
            " | |    / _ \\ / _` | | '_ \\ / _` || |/ __|",
            " | |___| (_) | (_| | | | | | (_| || | (__ ",
            "  \\_____\\___/ \\__,_|_|_| |_|\\__, || |\\___|",
            "                             __/ |/ |     ",
            "                            |___/__/      "
    };
    private static final String [] CODINGJC_BANNER2 = {
            " _____        _",
            " |  __ \\      | |",
            " | |  | | __ _| |__  _   _  __ _",
            " | |  | |/ _` | '_ \\| | | |/ _` |",
            " | |__| | (_| | | | | |_| | (_| |",
            " |_____/ \\__,_|_| |_|\\__,_|\\__,_|"
    };
    private static final String CODINGJC_BANNER3 = "Codingjc";
    private static final Random RANDOM = new Random();
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println(); // 输出一个换行
        int num = RANDOM.nextInt(10); // 生成一个0~9的随机数字
        if (num == 0) {
            for (String line : CODINGJC_BANNER1) {
                out.println(line);
            }
        } else if (num % 2 == 1) {
            for (String line : CODINGJC_BANNER2) {
                out.println(line);
            }
        } else {
            out.println(CODINGJC_BANNER3);
        }
        out.println(); // 输出一个换行
        out.flush(); // 强制清空缓存
    }
}
