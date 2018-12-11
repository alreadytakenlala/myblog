package top.lijunliang.blog.service;

import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.json.JsonWriting;

import java.util.List;

public interface DataService
{
    public void addArticle(JsonWriting json);

    public Article getArticle(JsonWriting json);

    public void deleteArticle(JsonWriting json);
}
