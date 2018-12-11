package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.Page;

/**
 * 页面头部
 */
@Component
public class Head implements PageComponent
{
    @Autowired
    private Website website;

    private String title;

    private String keywords;

    @Override
    public void update(Page page)
    {
        title = website.getDescription();
        keywords = website.getKeywords();
    }

    public String getTitle()
    {
        return title;
    }

    public String getKeywords()
    {
        return keywords;
    }
}
