package top.lijunliang.blog.entity.bo;

import java.util.Arrays;
import java.util.List;

/**
 * 话题
 */
public class Topic
{
    private Integer id;

    private String name;

    private String title;

    private Integer principal; //主话题：0，次话题：1

    private List<Series> series;

    private List<Article> articles;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getPrincipal()
    {
        return principal;
    }

    public void setPrincipal(Integer principal)
    {
        this.principal = principal;
    }

    public List<Series> getSeries()
    {
        return series;
    }

    public void setSeries(List<Series> series)
    {
        this.series = series;
    }

    public List<Article> getArticles()
    {
        return articles;
    }

    public void setArticles(List<Article> articles)
    {
        this.articles = articles;
    }

    public Topic(Integer id)
    {
        this.id = id;
    }

    public Topic(String name)
    {
        this.name = name;
    }

    public Topic(Integer id, String name, String title, Integer principal)
    {
        this.id = id;
        this.name = name;
        this.title = title;
        this.principal = principal;
    }
}
