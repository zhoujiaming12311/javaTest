package com.example.springbootproject.service.impl;

import com.example.springbootproject.entity.MUser;
import com.example.springbootproject.mapper.MUserMapper;
import com.example.springbootproject.service.IMUserService;
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
public class MUserServiceImpl extends ServiceImpl<MUserMapper, MUser> implements IMUserService {

}
