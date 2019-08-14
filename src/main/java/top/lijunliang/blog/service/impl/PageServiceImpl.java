package top.lijunliang.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.*;
import top.lijunliang.blog.repository.ArticleDao;
import top.lijunliang.blog.repository.SeriesDao;
import top.lijunliang.blog.repository.TopicDao;
import top.lijunliang.blog.service.PageService;

@Service
@Transactional
public class PageServiceImpl implements PageService
{
    @Autowired
    private TopicDao topicDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private SeriesDao seriesDao;

    @Autowired
    private Website website;

    @Autowired
    private Index index;

    @Autowired
    private Writing writing;

    @Autowired
    private TopicPage topicPage;

    @Autowired
    private ArticlePage articlePage;

    /**
     * @return page:index
     */
    @Override
    public Object[] getIndex(Integer pageNum, Integer pageSize)
    {
        andTopicNameTitleSeries(); //添加新的数据并生成页面
        PageInfo<Article> pageInfo = articleTitleDescriptionTimePageInfo(pageNum, pageSize);
        end(index);

        return new Object[] {index, pageInfo};
    }

    /**
     * @return page:writing
     */
    @Override
    public Writing getWriting()
    {
        andTopicName().andArticleTitleId().end(writing);
        return writing;
    }

    /**
     * @return page:springboot
     */
    @Override
    public TopicPage getTopicPage(Topic topic)
    {
        Topic topicId = topicDao.getTopicId(topic);
        topicPage.setTopicId(topicId.getId());
        andTopicNameTitleSeries().andArticleIdTitleTime(topicId).end(topicPage);
        return topicPage;
    }

    /**
     * @return article page
     */
    @Override
    public ArticlePage getArticle(Integer id)
    {
        articlePage.setId(id);
        andTopicName().andArticle(id).end(articlePage);
        return articlePage;
    }

    /**
     * @return article:id,title,description,time
     */
    private PageInfo articleTitleDescriptionTimePageInfo(Integer pageNum, Integer pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        com.github.pagehelper.Page<Article> articles = articleDao.getIdTitleDescriptionTime();

        for (Article article : articles)
        {
            website.addArticle(article);
        }

        return new PageInfo<>(articles);
    }

    /**
     * @return topic:principal name
     */
    private PageServiceImpl andPrincipalTopicName()
    {
        for (Topic topic : topicDao.getPrincipalTopicsName())
        {
            website.addTopic(topic);
        }

        return this;
    }

    /**
     * @return topic:id,name,title
     */
    private PageServiceImpl andTopicName()
    {
        for (Topic topic : topicDao.getTopicsNameTitleId())
        {
            if (topic.getPrincipal() == 0)
            {
                website.addTopic(topic);
            }
            else
            {
                website.addOtherTopic(topic);
            }
        }

        return this;
    }

    /**
     * @return topic:id,name,title,series
     */
    private PageServiceImpl andTopicNameTitleSeries()
    {
        for (Topic topic : topicDao.getTopicsNameTitleId())
        {
            topic.setSeries(seriesDao.getSeries(topic));

            if (topic.getPrincipal() == 0)
            {
                website.addTopic(topic);
            }
            else
            {
                website.addOtherTopic(topic);
            }
        }

        return this;
    }

    /**
     * @return article:id,title
     */
    private PageServiceImpl andArticleTitleId()
    {
        for (Article article : articleDao.getTitleId())
        {
            website.addArticle(article);
        }

        return this;
    }

    /**
     * @return topic article: id, title, time
     */
    public PageServiceImpl andArticleIdTitleTime(Topic topic)
    {
        topic = website.getTopic(topic.getId());
        topic.setArticles(articleDao.getIdTitleTimeByTopicId(topicDao.getTopicId(topic)));
        return this;
    }

    /**
     * @return article
     */
    public PageServiceImpl andArticle(Integer id)
    {
        website.addArticle(articleDao.getArticle(id));
        return this;
    }

    /**
     * 页面拉取数据
     * @param page
     */
    private void end(Page page)
    {
        page.notifyComponent();
    }
}
