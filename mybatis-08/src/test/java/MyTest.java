import com.cqu.dao.BlogMapper;
import com.cqu.pojo.Blog;
import com.cqu.utils.IDUtils;
import com.cqu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void addBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("English");
        blog.setAuthor("liqikang");
        blog.setCreateTime(new Date());
        blog.setViews(100);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Math");
        blog.setAuthor("huangyi");

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Art");
        blog.setAuthor("qikang");

        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
//        hashMap.put("title","Art");

        List<Blog> blogs = mapper.queryBlogIf(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

}
