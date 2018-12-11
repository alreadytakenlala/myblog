package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.Page;

import java.util.Date;
import java.util.List;

/**
 * 页面内容左部版块
 */
@Component
@PropertySource(value={"classpath:constant.properties"}, encoding="utf-8")
public class IndexLeftSection implements PageComponent
{
    @Autowired
    private Website website;

    private Section[] section;

    @Override
    public void update(Page page)
    {
        List<Article> articles = website.getArticles();
        section = new Section[articles.size()];

        for (int i = 0; i < articles.size(); i++)
        {
            Article article = articles.get(i);
            section[i] = new Section(article.getId(), article.getTitle(), article.getDescription(), article.getTime());
        }
    }

    public Section[] getSection()
    {
        return section;
    }

    class Section
    {
        private Integer id ;

        private String title;

        private String description;

        private Date time;

        public Integer getId()
        {
            return id;
        }

        public void setId(Integer id)
        {
            this.id = id;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        public Date getTime()
        {
            return time;
        }

        public void setTime(Date time)
        {
            this.time = time;
        }

        public Section(Integer id, String title, String description, Date time)
        {
            this.id = id;
            this.title = title;
            this.description = description;
            this.time = time;
        }
    }
}
