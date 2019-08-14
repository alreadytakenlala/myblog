package top.lijunliang.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("top.lijunliang.blog.repository")
public class ApplicationServer extends SpringBootServletInitializer
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationServer.class, args);
    }
}