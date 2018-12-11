package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Software;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.Page;

import java.util.Date;
import java.util.List;

/**
 * 页面右边版块
 */
@Component
@PropertySource(value={"classpath:constant.properties"}, encoding="utf-8")
public class IndexRightSection implements PageComponent
{
    @Autowired
    private Website website;

    @Value("${index_right_section.up.title}")
    private String upTitle;

    @Value("${index_right_section.down.title}")
    private String downTitle;

    private Up up;

    private Down down;

    public Up getUp()
    {
        return up;
    }

    public Down getDown()
    {
        return down;
    }

    @Override
    public void update(Page page)
    {
        up = new Up(website.getOtherTopics());
        down = new Down(website.getSoftwares());
    }

    /**
     * 右边上版块
     */
    class Up
    {
        private String title = upTitle;

        private UpSection[] upSections;

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public UpSection[] getUpSections()
        {
            return upSections;
        }

        public void setUpSections(UpSection[] upSections)
        {
            this.upSections = upSections;
        }

        public Up(List<Topic> topics)
        {
            upSections = new UpSection[topics.size()];

            for (int i = 0; i < topics.size(); i++)
            {
                Topic topic = topics.get(i);
                upSections[i] = new UpSection(topic.getName(), topic.getTitle());
            }
        }

        class UpSection
        {
            private String title = downTitle;

            private String description;

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

            public UpSection(String title, String description)
            {
                this.title = title;
                this.description = description;
            }
        }
    }

    /**
     * 右边下版块
     */
    class Down
    {
        private String title;

        private DownSection[] downSections;

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public DownSection[] getDownSections()
        {
            return downSections;
        }

        public void setDownSections(DownSection[] downSections)
        {
            this.downSections = downSections;
        }

        public Down(List<Software> list)
        {
            downSections = new DownSection[list.size()];

            for (int i = 0; i < list.size(); i++)
            {
                Software software = list.get(i);
                downSections[i] = new DownSection(software.getTitle(), software.getDescription(),
                        software.getStars(), software.getForks(), software.getLastUpdated(), software.getUrl());
            }
        }

        class DownSection
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

            public DownSection(String title, String description, Integer stars, Integer forks, Date lastUpdated, String url)
            {
                this.title = title;
                this.description = description;
                this.stars = stars;
                this.forks = forks;
                this.lastUpdated = lastUpdated;
                this.url = url;
            }
        }
    }
}
