package cn.codingjc;

import cn.codingjc.banner.CodingjcBanner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 启动类
 * @author coding_jc
 * @date 2021/7/25
 */
@RestController
@ImportResource(locations = {"classpath:META-INF/spring/spring-*.xml"})
@SpringBootApplication
public class MicrobootWebBootApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(
                MicrobootWebBootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setBanner(new CodingjcBanner());
        springApplication.run(args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
