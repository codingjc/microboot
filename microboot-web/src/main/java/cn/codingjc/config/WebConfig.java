package cn.codingjc.config;

//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coding_jc
 * @date 2021/8/26
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 消息转换器
     * @param converters
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // 1.默认springboot中转换器为jackson组件，首先需要移除此组件
//        for (int i = 0; i < converters.size(); i++) {
//            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
//                converters.remove(i);
//            }
//        }
//        // 2.项目中需要提供一个转换器，将fastjson转换器配置到项目中
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        // 3.fastjson在进行最终消息转换器处理的时候实际上是需要进行相关配置定义的
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.WriteMapNullValue, // 允许map内容为空
//                SerializerFeature.WriteNullListAsEmpty, // List集合为null则使用[]代替
//                SerializerFeature.WriteNullStringAsEmpty, // String内容为空用空字符串代替
//                SerializerFeature.WriteDateUseDateFormat, // 日期格式化的输出
//                SerializerFeature.WriteNullNumberAsZero, // 数组为空则用零表示
//                SerializerFeature.DisableCircularReferenceDetect // 禁用循环引用
//        ); // 配置相关的序列化处理操作
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig); // 配置fastjson转换处理
//        // 4.最终输出的内容为json,所以需要配置号响应的头信息结构
//        List<MediaType> fastjsonMediaTypes = new ArrayList<>(); // 定义所有的响应类型
//        fastjsonMediaTypes.add(MediaType.APPLICATION_JSON); // 使用JSON类型进行响应
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastjsonMediaTypes);
//        // 5.在转换器列表中添加配置完成的fastjson转换组件
//        converters.add(fastJsonHttpMessageConverter);
//    }
}
