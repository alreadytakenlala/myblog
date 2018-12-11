package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.ArticlePage;
import top.lijunliang.blog.entity.vo.Page;

@Component
public class ArticleContent implements PageComponent
{
    @Autowired
    private Website website;

    private String content;

    @Override
    public void update(Page page)
    {
        if (page instanceof ArticlePage)
        {
            ArticlePage article = (ArticlePage) page;
            content = website.getArticle(article.getId()).getContent();
        }
    }

    public String getContent()
    {
        return content;
    }
}
