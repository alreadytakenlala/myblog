package top.lijunliang.blog.repository;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import top.lijunliang.blog.entity.bo.Article;
import top.lijunliang.blog.entity.bo.Topic;
import top.lijunliang.blog.entity.json.JsonWriting;

import java.util.List;

@Repository
public interface ArticleDao
{
    @Select("SELECT id, title, description, time FROM article ORDER BY id DESC")
    Page<Article> getIdTitleDescriptionTime();

    @Select("SELECT id, title FROM article")
    List<Article> getTitleId();

    @Select("SELECT id, title, time FROM article WHERE topic_id = #{id}")
    List<Article> getIdTitleTimeByTopicId(Topic topic);

    @Insert("INSERT INTO article (title, description, content, topic_id) VALUES (#{title}, #{description}, #{content}, #{topicId})")
    void add(JsonWriting json);

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article getArticle(Integer id);

    @Update("UPDATE article SET title=#{title},description=#{description},content=#{content},topic_id=#{topicId} WHERE id = #{id}")
    void updateArticle(JsonWriting json);

    @Delete("DELETE FROM article WHERE id = #{id}")
    void deleteArticle(JsonWriting json);
}
