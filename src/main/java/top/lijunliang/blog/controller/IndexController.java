package top.lijunliang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.lijunliang.blog.service.DataService;
import top.lijunliang.blog.service.PageService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController
{
    @Autowired
    private PageService pageService;

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String index(HttpServletRequest request, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="8") Integer pageSize)
    {
        Object[] result = pageService.getIndex(pageNum, pageSize);
        request.setAttribute("content", result[0]);
        request.setAttribute("pageInfo", result[1]);

        return "themes/default/index";
    }

    @GetMapping("/Home")
    public String home(HttpServletRequest request)
    {
        return index(request, 1, 8);
    }

    @RequestMapping(value="/article", method = RequestMethod.GET)
    public String article(@RequestParam("id") Integer id, HttpServletRequest request)
    {
        request.setAttribute("content", pageService.getArticle(id));
        return "themes/article";
    }

    @GetMapping("page")
    public String pages(HttpServletRequest request, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="8") Integer pageSize)
    {
        return index(request, pageNum, pageSize);
    }
}