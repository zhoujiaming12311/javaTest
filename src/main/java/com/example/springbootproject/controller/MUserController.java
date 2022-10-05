package com.example.springbootproject.controller;


import com.example.springbootproject.common.lang.Result;
import com.example.springbootproject.entity.MUser;
import com.example.springbootproject.service.IMBlogService;
import com.example.springbootproject.service.IMUserService;
import com.example.springbootproject.service.impl.MUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author itxy
 * @since 2022-05-08
 */
@RestController
@RequestMapping("/m-user")
//@Slf4j
public class MUserController {
    @Autowired
    IMUserService IMUserService;

    @RequiresAuthentication
    @GetMapping("/index")


    public Result index() {
//        log.info(String.valueOf(IMUserService.getById(1L)));
        MUser user = IMUserService.getById(1L);
        return Result.succ(200,"操作成功success",user);
    }

}
