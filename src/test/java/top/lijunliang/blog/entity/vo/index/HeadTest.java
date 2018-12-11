package top.lijunliang.blog.entity.vo.index;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.component.Head;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HeadTest
{
    @Autowired
    private Head head;

    @Autowired
    private Website website;

    @Test
    public void getTitle()
    {
        Assert.assertEquals("巫师笔记", head.getTitle());
    }

    @Test
    public void getKeywords()
    {
    }
}
