package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面导航栏
 */
@Component
@PropertySource(value={"classpath:constant.properties"}, encoding="utf-8")
public class NavigationBar implements PageComponent
{
    @Autowired
    private Website website;

    @Value("${navigation.home}")
    private String home;

    private String logoName;

    private List<String> smallTitle;

    @Override
    public void update(Page page)
    {
        logoName = website.getName();
        List<Topic> topics = website.getTopics();
        smallTitle = new ArrayList<>();
        smallTitle.add("Home");

        for (Topic topic : topics) {
            smallTitle.add(topic.getName());
        }
    }

    public String getLogoName()
    {
        return logoName;
    }

    public List<String> getSmallTitle()
    {
        return smallTitle;
    }
}
