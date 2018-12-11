package top.lijunliang.blog.entity.bo;

import java.util.Date;

/**
 * 开源软件
 */
public class Software
{
    private String title;

    private String description;

    private Integer stars; //星星

    private Integer forks; //克隆

    private Date lastUpdated; //最后更新时间

    private String url; //开源地址

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

    public Integer getStars()
    {
        return stars;
    }

    public void setStars(Integer stars)
    {
        this.stars = stars;
    }

    public Integer getForks()
    {
        return forks;
    }

    public void setForks(Integer forks)
    {
        this.forks = forks;
    }

    public Date getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
