package top.lijunliang.blog.service;

import com.github.pagehelper.PageInfo;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.vo.*;

public interface PageService
{

    /**
     * 取回页面和分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Object[] getIndex(Integer pageNum, Integer pageSize);

    public Writing getWriting();

    public TopicPage getTopicPage(Topic topic);

    public ArticlePage getArticle(Integer id);
}
