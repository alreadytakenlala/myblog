package top.lijunliang.blog.entity.vo.index;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lijunliang.blog.entity.vo.Index;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexTest
{
    @Autowired
    private Index index;

    @Test
    public void testToString()
    {
        Assert.assertNotNull(index);
    }
}
