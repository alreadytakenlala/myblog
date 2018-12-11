package top.lijunliang.blog.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lijunliang.blog.repository.SeriesDao;
import top.lijunliang.blog.repository.TopicDao;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceImplTest
{
    @Autowired
    private TopicDao topicDao;

    @Autowired
    private SeriesDao seriesDao;

    @Test
    public void topic()
    {
    }
}
