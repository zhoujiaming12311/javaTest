package com.example.springbootproject.controller;


import com.example.springbootproject.service.IMBlogService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author itxy
 * @since 2022-05-08
 */
@RestController
@RequestMapping("/m-blog")
public class MBlogController {
    @Autowired
    IMBlogService IMBlogService;

    @GetMapping("/index")
    public Object index() {
        return IMBlogService.getById(1L);
    }
}
