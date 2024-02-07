package com.pactera.learn.spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.api.annotation.LKAMethod;
import com.lk.api.annotation.LKAType;
import com.pactera.learn.spring.common.R;
import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.entity.TestMybatisPlus;
import com.pactera.learn.spring.service.ITestMybatisPlusService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@LKAType(value="Mybatis-Plus测试模块")
@RestController()
@RequestMapping("/test_mybatis_plus")
public class TestMybatisPlusController {

    @Resource
    private ITestMybatisPlusService iTestMybatisPlusService;

    /**
     * 获取用户
     *
     * @param id
     * @return {@link R}
     */
    @LKAMethod(value="获取用户")
    @GetMapping("get_user/{id}")
    public R getUser(@PathVariable Long id) {
        return R.success("查询成功!", iTestMybatisPlusService.getOne(new QueryWrapper<TestMybatisPlus>().eq("id", id)));
    }

    @LKAMethod(value="获取用户列表")
    @GetMapping("get_user_list")
    public R getUserList(UserDataDTO dto) {
        QueryWrapper<TestMybatisPlus> queryWrapper = new QueryWrapper<TestMybatisPlus>();
        if (dto.getName() != null) {
            queryWrapper.like("name", dto.getName());
        }
        if (dto.getAge() != null) {
            queryWrapper.eq("age", dto.getAge());
        }
        System.out.println(queryWrapper.getSqlSelect());
        return R.success("查询成功!", iTestMybatisPlusService.list(queryWrapper));
    }

    @LKAMethod(value="更新用户")
    @PutMapping("save_or_update")
    public R saveOrUpdate(@RequestBody UserDataDTO dto) {
        TestMybatisPlus testMybatisPlus = new TestMybatisPlus();
        BeanUtils.copyProperties(dto, testMybatisPlus);
        if (iTestMybatisPlusService.saveOrUpdate(testMybatisPlus)) {
            return R.success("操作成功!", true);
        } else {
            return R.error("操作失败!");
        }
    }

    @LKAMethod(value="获取用户列表分页")
    @GetMapping("get_user_list_page")
    public R getUserListPage(UserDataDTO dto, Long current, Long size) {
        return R.success("查询成功!", iTestMybatisPlusService.getUserListPage(dto, current, size));
    }

}
