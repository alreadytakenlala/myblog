package top.lijunliang.blog.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.vo.component.*;

import javax.annotation.PostConstruct;

@Component
public class TopicPage extends Page
{
    private Integer topicId;

    @Autowired
    private Head head;

    @Autowired
    private NavigationBar navigationBar;

    @Autowired
    private Neck neck;

    @Autowired
    private BodyContent bodyContent;

    @Autowired
    private Footer footer;

    @PostConstruct
    public void init()
    {
        addComponent(head).addComponent(navigationBar).addComponent(neck).addComponent(bodyContent).addComponent(footer);
    }

    public Integer getTopicId()
    {
        return topicId;
    }

    public void setTopicId(Integer topicId)
    {
        this.topicId = topicId;
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

    public BodyContent getBodyContent()
    {
        return bodyContent;
    }

    public Footer getFooter()
    {
        return footer;
    }
}
