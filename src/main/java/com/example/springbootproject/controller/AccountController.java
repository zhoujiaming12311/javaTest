package com.example.springbootproject.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootproject.common.dto.LoginDto;
import com.example.springbootproject.common.lang.Result;
import com.example.springbootproject.entity.MUser;
import com.example.springbootproject.service.IMUserService;
import com.example.springbootproject.service.impl.MUserServiceImpl;
import com.example.springbootproject.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {
    @Autowired
    IMUserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto, HttpServletResponse response){
        MUser user = userService.getOne(new QueryWrapper<MUser>().eq("username",loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");

        if(!user.getParssowrd().equals(SecureUtil.md5(loginDto.getParssowrd()))) {
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expost-Headers","Authorization");
        return Result.succ(MapUtil.builder()
                            .put("id",user.getId())
                            .put("username  ",user.getId())
                            .put("email",user.getId())
                            .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
