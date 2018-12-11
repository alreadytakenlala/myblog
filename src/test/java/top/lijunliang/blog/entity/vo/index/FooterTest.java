package top.lijunliang.blog.entity.vo.index;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lijunliang.blog.entity.vo.component.Footer;

/*
 * 为springApplication创建上下文并支持SpringBoot特性
 *
 * 1、Mock —— 加载WebApplicationContext并提供Mock Servlet环境
 * 2、RANDOOM_PORT —— 加载EmbeddedWebApplicationContext并提供servlet环境，内嵌服务的监听端口是随机的
 * 3、DEFINED_PORT —— 加载EmbeddedWebApplicationContext并提供servlet环境，内容服务的监听端口是定义好的。默认端口是8080
 * 4、NONE —— 加载ApplicationContext，启动SpringApplication时，不支持Servlet环境
 */
@SpringBootTest

@RunWith(SpringRunner.class) //运行Junit并支持Spring-test特性
public class FooterTest
{
    @Autowired
    private Footer footer;

    @Test
    public void getUpList()
    {
        Assert.assertArrayEquals(new String[]{"知乎","微博","Github"}, footer.getUpList());
    }

    @Test
    public void getDownList()
    {
        Assert.assertArrayEquals(new String[]{"资源","故事","架构","Jvm","FastDFS","MongoDB","Docker","Code"}, footer.getDownList());
    }
}