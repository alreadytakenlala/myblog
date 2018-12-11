package top.lijunliang.blog.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.vo.component.PageComponent;

import java.util.*;

public class Page
{
    @Autowired
    protected Website website;

    protected List<PageComponent> components = new ArrayList<>();

    public Page addComponent(PageComponent component)
    {
        components.add(component);
        return this;
    }

    public void removeComponent(PageComponent component)
    {
        if (components.indexOf(component) >= 0)
        {
            components.remove(component);
        }
    }

    public void notifyComponent()
    {
        for (PageComponent component : components)
        {
            component.update(this);
        }
        website.clean(); //数据清理
    }
}
