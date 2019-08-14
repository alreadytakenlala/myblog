package top.lijunliang.blog.entity.bo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import top.lijunliang.blog.utils.BlogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 网站
 */
@Component
@PropertySource(value={"classpath:constant.properties"}, encoding="utf-8")
@ConfigurationProperties(prefix = "website")
public class Website
{
    private String name; //站名

    private String description; //网站描述

    private String motto; //箴言

    private String keywords; //关键词

    private List<Article> articles = new ArrayList<>(); //获取所有文章

    private List<Software> softwares = new ArrayList<>(); //开源软件

    private List<Topic> topics = new ArrayList<>(); //主话题

    private List<Topic> otherTopics = new ArrayList<>(); //其他话题

    /**
     * 添加软件
     * @param software
     * @return Website
     */
    public Website addSoftwares(Software software)
    {
        softwares.add(software);
        return this;
    }

    /**
     * 获取软件
     * @return List<Software>
     */
    public List<Software> getSoftwares()
    {
        return softwares;
    }

    /**
     * 添加话题
     * @param topic
     * @return Website
     */
    public Website addTopic(Topic topic)
    {
        topics.add(topic);
        return this;
    }

    /**
     * 获取话题
     * @return List<Topic>
     */
    public List<Topic> getTopics()
    {
        return topics;
    }

    /**
     * 添加其他话题
     * @return Website
     */
    public Website addOtherTopic(Topic topic)
    {
        otherTopics.add(topic);
        return this;
    }

    /**
     * 获取其他话题
     * @return other topics
     */
    public List<Topic> getOtherTopics()
    {
        return otherTopics;
    }

    /**
     * @return topic
     */
    public Topic getTopic(String topicName)
    {
        for (Topic topic : topics)
        {
            if (topic.getName().equals(topicName))
            {
                return topic;
            }
        }
        for (Topic topic : otherTopics)
        {
            if (topic.getName().equals(topicName))
            {
                return topic;
            }
        }

        return null;
    }

    /**
     * @return topic
     */
    public Topic getTopic(Integer topicId)
    {
        for (Topic topic : topics)
        {
            if (topic.getId() == topicId)
            {
                return topic;
            }
        }
        for (Topic topic : otherTopics)
        {
            if (topic.getId() == topicId)
            {
                return topic;
            }
        }

        return null;
    }

    /**
     * 添加文章
     */
    public Website addArticle(Article article)
    {
        articles.add(article);
        return this;
    }

    public Article getArticle(Integer id)
    {
        for (Article article : articles)
        {
            if (id == article.getId())
            {
                return article;
            }
        }

        return null;
    }

    /**
     * 获取全部文章
     */
    public List<Article> getArticles()
    {
        return articles;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getMotto()
    {
        return motto;
    }

    public void setMotto(String motto)
    {
        this.motto = motto;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public void clean()
    {
        articles = new ArrayList<>();
        softwares = new ArrayList<>();
        topics = new ArrayList<>();
        otherTopics = new ArrayList<>();
    }
}
