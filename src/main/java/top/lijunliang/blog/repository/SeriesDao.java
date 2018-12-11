package top.lijunliang.blog.repository;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.lijunliang.blog.entity.bo.Series;
import top.lijunliang.blog.entity.bo.Topic;

import java.util.List;

@Repository
public interface SeriesDao
{
    @Select("SELECT name, url FROM series WHERE topic_id = #{id}")
    List<Series> getSeries(Topic topic);
}
