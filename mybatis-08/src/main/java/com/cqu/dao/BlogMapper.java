package com.cqu.dao;

import com.cqu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    // 插入数据
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> queryBlogIf(Map blog);
}
