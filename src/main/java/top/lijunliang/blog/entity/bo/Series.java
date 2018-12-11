package top.lijunliang.blog.entity.bo;

public class Series
{
    private String name;

    private String url;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Series(String name, String url)
    {
        this.name = name;
        this.url = url;
    }
}
