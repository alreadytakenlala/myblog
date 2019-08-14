package top.lijunliang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.json.JsonWriting;
import top.lijunliang.blog.entity.vo.Writing;
import top.lijunliang.blog.service.DataService;
import top.lijunliang.blog.service.PageService;
import top.lijunliang.blog.utils.StatusCode;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WriteController
{
    @Autowired
    private PageService PageService;

    @Autowired
    private DataService dataService;

    @GetMapping("/writing")
    public String write(HttpServletRequest request)
    {
        request.setAttribute("content", PageService.getWriting());
        return "themes/default/writing";
    }

    @PostMapping("/writing/publish")
    @ResponseBody
    public StatusCode publish(JsonWriting json)
    {
        dataService.addArticle(json);
        return new StatusCode(0,"发表成功");
    }

    @PostMapping("/writing/getArticle")
    @ResponseBody
    public Article getArticle(JsonWriting json)
    {
        return dataService.getArticle(json);
    }

    @PostMapping("/writing/deleteArticle")
    @ResponseBody
    public StatusCode deleteArticle(JsonWriting json)
    {
        dataService.deleteArticle(json);
        return new StatusCode(0, "删除成功");
    }
}
