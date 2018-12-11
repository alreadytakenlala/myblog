package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.Page;

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

    private String[] smallTitle;

    @Override
    public void update(Page page)
    {
        logoName = website.getName();
        Topic[] topics = website.getTopics();
        smallTitle = new String[6];
        smallTitle[0] = home;

        for (int i = 0; i < topics.length; i++)
        {
            if (topics[i] != null)
            {
                smallTitle[i+1] = topics[i].getName();
            }
        }
    }

    public String getLogoName()
    {
        return logoName;
    }

    public String[] getSmallTitle()
    {
        return smallTitle;
    }
}
