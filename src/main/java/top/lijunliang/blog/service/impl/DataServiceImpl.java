package top.lijunliang.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.json.JsonWriting;
import top.lijunliang.blog.repository.ArticleDao;
import top.lijunliang.blog.repository.TopicDao;
import top.lijunliang.blog.service.DataService;

@Service
@Transactional
public class DataServiceImpl implements DataService
{
    @Autowired
    private TopicDao topicDao;

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void addArticle(JsonWriting json)
    {
        json.setTopicId(topicDao.getTopicId(new Topic(json.getTopicName())).getId());

        if (json.getId() == null)
        {
            articleDao.add(json);
        }
        else
        {
            articleDao.updateArticle(json);
        }
    }

    @Override
    public Article getArticle(JsonWriting json)
    {
        return articleDao.getArticle(json.getId());
    }

    @Override
    public void deleteArticle(JsonWriting json)
    {
        articleDao.deleteArticle(json);
    }

    public Article getArticle(Integer id)
    {
        return articleDao.getArticle(id);
    }
}
