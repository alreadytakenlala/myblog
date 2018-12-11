package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.*;

import java.util.List;

@Component
public class BodyContent implements PageComponent
{
    @Autowired
    private Website website;

    private List<Article> articles;

    @Override
    public void update(Page page)
    {
        TopicPage topicPage = (TopicPage) page;
        articles = website.getTopic(topicPage.getTopicId()).getArticles();
        articles = website.getTopic(topicPage.getTopicId()).getArticles();
        articles = website.getTopic(topicPage.getTopicId()).getArticles();
        articles = website.getTopic(topicPage.getTopicId()).getArticles();
        articles = website.getTopic(topicPage.getTopicId()).getArticles();
    }

    public List<Article> getArticles()
    {
        return articles;
    }
}
