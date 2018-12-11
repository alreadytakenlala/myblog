package top.lijunliang.blog.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lijunliang.blog.entity.vo.Writing;
import top.lijunliang.blog.service.PageService;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WriteControllerTest
{
    @Autowired
    private PageService pageService;

    @Test
    public void write()
    {
        Writing writing = pageService.getWriting();
        System.out.println(writing);
    }
}
