package top.lijunliang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.service.PageService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TopicController
{
    @Autowired
    private PageService pageService;

    @GetMapping("/About")
    public String about(HttpServletRequest request)
    {
        request.setAttribute("content", pageService.getTopicPage(new Topic("About")));
        return "themes/default/about";
    }

    @GetMapping("/Archives")
    public String getArchives(HttpServletRequest request)
    {
        request.setAttribute("content", pageService.getTopicPage(new Topic("Archives")));
        return "themes/default/archives";
    }


    @GetMapping("/Link")
    public String link(HttpServletRequest request)
    {
        request.setAttribute("content", pageService.getTopicPage(new Topic("Link")));
        return "themes/default/link";
    }

    @GetMapping("/Spring-Boot")
    public String springBoot(HttpServletRequest request)
    {
        request.setAttribute("content", pageService.getTopicPage(new Topic("Spring-Boot")));
        return "themes/default/springboot";
    }

    @GetMapping("/Spring-Cloud")
    public String springClound(HttpServletRequest request)
    {
        request.setAttribute("content", pageService.getTopicPage(new Topic("Spring-Cloud")));
        return "themes/default/springcloud";
    }
}
