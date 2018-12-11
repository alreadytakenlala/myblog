package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.Page;

import java.util.ArrayList;
import java.util.List;

@Component
public class WritingContent implements PageComponent
{
    @Autowired
    private Website website;

    private Integer id;

    private List<String> topics;

    private List<Article> articles;

    public Integer getId()
    {
        return id;
    }

    public List<Article> getArticles()
    {
        return articles;
    }

    public List<String> getTopics()
    {
        return topics;
    }

    @Override
    public void update(Page page)
    {
        topics = new ArrayList<>();
        articles = new ArrayList<>();

        for (Topic topic : website.getTopics())
        {
            topics.add(topic.getName());
        }
        for (Topic topic : website.getOtherTopics())
        {
            topics.add(topic.getName());
        }
        for (Article article : website.getArticles())
        {
            articles.add(article);
        }
    }

    @Override
    public String toString()
    {
        return "WritingBody{" +
                "website=" + website +
                ", topics=" + topics +
                '}';
    }
}
