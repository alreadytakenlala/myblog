package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Series;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面颈部分
 */
@Component
public class Neck implements PageComponent
{
    @Autowired
    private Website website;

    private String title;

    private List<String> subtitle;

    @Override
    public void update(Page page)
    {
        subtitle = new ArrayList<>();

        if (page instanceof Index)
        {
            homePage();
        }
        else if (page instanceof TopicPage)
        {
            TopicPage topicPage = (TopicPage) page;
            topicPage(topicPage.getTopicId());
        }
        else if (page instanceof ArticlePage)
        {
            articlePage((ArticlePage) page);
        }
    }

    private void homePage()
    {
        title = website.getMotto();
        List<Topic> otherTopics = website.getOtherTopics();

        for (int i = 0; i < otherTopics.size(); i++)
        {
            subtitle.add(otherTopics.get(i).getName());
        }
    }

    private void topicPage(Integer topicId)
    {
        Topic topic = website.getTopic(topicId);
        title = topic.getTitle();

        List<Series> series = topic.getSeries();
        if (series == null) return;

        for (int i = 0; i < series.size(); i++)
        {
            subtitle.add(series.get(i).getName());
        }
    }

    public void articlePage(ArticlePage articlePage)
    {
        Article article = website.getArticle(articlePage.getId());
        title = article.getTitle();
        subtitle.add(article.getDescription());
    }

    public String getTitle()
    {
        return title;
    }

    public List<String> getSubtitle()
    {
        return subtitle;
    }
}
