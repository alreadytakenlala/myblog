package top.lijunliang.blog.entity.vo.index;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lijunliang.blog.entity.vo.component.NavigationBar;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NavigationBarTest
{
    @Autowired
    private NavigationBar navigationBar;

    @Test
    public void getSmallTitle()
    {
        System.out.println(Arrays.toString(navigationBar.getSmallTitle()));
    }
}
