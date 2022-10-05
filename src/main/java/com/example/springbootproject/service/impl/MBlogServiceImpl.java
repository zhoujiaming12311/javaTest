package com.example.springbootproject.service.impl;

import com.example.springbootproject.entity.MBlog;
import com.example.springbootproject.mapper.MBlogMapper;
import com.example.springbootproject.service.IMBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itxy
 * @since 2022-05-08
 */
@Service
public class MBlogServiceImpl extends ServiceImpl<MBlogMapper, MBlog> implements IMBlogService {

}
