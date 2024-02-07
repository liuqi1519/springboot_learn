package com.pactera.learn.spring.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.entity.TestMybatisPlus;
import com.pactera.learn.spring.model.vo.UserDataVO;

import java.util.List;

public interface ITestMybatisPlusService extends IService<TestMybatisPlus> {

    List<UserDataVO> getUserList(UserDataDTO dto);

    List<TestMybatisPlus> getUserListPage(UserDataDTO dto, Long current, Long size);
}
