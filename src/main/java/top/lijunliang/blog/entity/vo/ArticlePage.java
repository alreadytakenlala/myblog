package top.lijunliang.blog.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.vo.component.*;

import javax.annotation.PostConstruct;

@Component
public class ArticlePage extends Page
{
    private Integer id;

    @Autowired
    private Head head;

    @Autowired
    private NavigationBar navigationBar;

    @Autowired
    private Neck neck;

    @Autowired
    private ArticleContent articleContent;

    @Autowired
    private Footer footer;

    @PostConstruct
    public void init()
    {
        addComponent(head).addComponent(navigationBar).addComponent(neck).addComponent(articleContent).addComponent(footer);
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
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

    public ArticleContent getArticleContent()
    {
        return articleContent;
    }

    public Footer getFooter()
    {
        return footer;
    }
}
