package top.lijunliang.blog.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.component.*;

import javax.annotation.PostConstruct;

/**
 * index页面
 */
@Component
public class Index extends Page
{
    @Autowired
    private Head head;

    @Autowired
    private NavigationBar navigationBar;

    @Autowired
    private Neck neck;

    @Autowired
    private IndexLeftSection leftSection;

    @Autowired
    private IndexRightSection rightSection;

    @Autowired
    private Footer footer;

    @PostConstruct
    public void init()
    {
        addComponent(head).addComponent(navigationBar).addComponent(neck).addComponent(leftSection).addComponent(rightSection);
    }

    public Head getHead()
    {
        return head;
    }

    public NavigationBar getNavigationBar()
    {
        return navigationBar;
    }

    public Neck getNeck()
    {
        return neck;
    }

    public IndexLeftSection getLeftSection()
    {
        return leftSection;
    }

    public IndexRightSection getRightSection()
    {
        return rightSection;
    }

    public Footer getFooter()
    {
        return footer;
    }
}
