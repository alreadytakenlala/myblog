package top.lijunliang.blog.repository;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.bo.Website;
import top.lijunliang.blog.entity.json.JsonWriting;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TopicDao
{
    @Select("SELECT name FROM topic WHERE principal = 0")
    List<Topic> getPrincipalTopicsName();

    @Select("SELECT id, name, title, principal FROM topic")
    List<Topic> getTopicsNameTitleId();

    @Select("SELECT id FROM topic WHERE name = #{name}")
    Topic getTopicId(Topic Topic);
}
