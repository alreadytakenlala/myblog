package top.lijunliang.blog.entity.vo.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.vo.Page;

/**
 * 页脚
 */
@Component
public class Footer implements PageComponent
{
    @Value("${footer.zhihu}")
    private String zhihu;

    @Value("${footer.weibo}")
    private String weibo;

    @Value("${footer.github}")
    private String github;

    @Value("${footer.resource}")
    private String resource;

    @Value("${footer.story}")
    private String story;

    @Value("${footer.softworeArchitect}")
    private String softworeArchitect;

    @Value("${footer.jvm}")
    private String jvm;

    @Value("${footer.fastdfs}")
    private String fastdfs;

    @Value("${footer.mongodb}")
    private String mongodb;

    @Value("${footer.docker}")
    private String docker;

    @Value("${footer.code}")
    private String code;

    @Override
    public void update(Page page) {}

    public String[] getUpList()
    {
        return new String[] {zhihu, weibo, github};
    }

    public String[] getDownList()
    {
        return new String[] {resource, story, softworeArchitect, jvm, fastdfs, mongodb, docker, code};
    }

    public String getZhihu()
    {
        return zhihu;
    }

    public String getWeibo()
    {
        return weibo;
    }

    public String getGithub()
    {
        return github;
    }

    public String getResource()
    {
        return resource;
    }

    public String getStory()
    {
        return story;
    }

    public String getSoftworeArchitect()
    {
        return softworeArchitect;
    }

    public String getJvm()
    {
        return jvm;
    }

    public String getFastdfs()
    {
        return fastdfs;
    }

    public String getMongodb()
    {
        return mongodb;
    }

    public String getDocker()
    {
        return docker;
    }

    public String getCode()
    {
        return code;
    }
}
