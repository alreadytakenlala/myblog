package top.lijunliang.blog.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.vo.component.Footer;
import top.lijunliang.blog.entity.vo.component.Head;
import top.lijunliang.blog.entity.vo.component.WritingContent;

import javax.annotation.PostConstruct;

@Component
public class Writing extends Page
{
    @Autowired
    private Head head;

    @Autowired
    private WritingContent body;

    @Autowired
    private Footer footer;

    @Autowired
    private Article article;

    @PostConstruct
    public void init()
    {
        addComponent(head).addComponent(body).addComponent(footer);
    }

    public Head getHead()
    {
        return head;
    }

    public Footer getFooter()
    {
        return footer;
    }

    public Article getArticle()
    {
        return article;
    }

    public void setArticle(Article article)
    {
        this.article = article;
    }

    public WritingContent getBody()
    {
        return body;
    }

    @Override
    public String toString()
    {
        return "Writing{" +
                "head=" + head +
                ", body=" + body +
                ", footer=" + footer +
                ", article=" + article +
                '}';
    }
}
