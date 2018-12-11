package top.lijunliang.blog.entity.bo;

import org.springframework.stereotype.Component;
import top.lijunliang.blog.utils.BlogUtil;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 博客
 */
@Component
public class Article
{
    private Integer id;

    private String title;

    private String description;

    private Date time;

    private String content;

    public Integer getId()
    {
        return id;
    }

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

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
