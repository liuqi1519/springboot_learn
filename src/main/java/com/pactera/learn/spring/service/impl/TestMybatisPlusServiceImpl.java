package com.pactera.learn.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pactera.learn.spring.mapper.TestMybatisPlusMapper;
import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.entity.TestMybatisPlus;
import com.pactera.learn.spring.model.vo.UserDataVO;
import com.pactera.learn.spring.service.ITestMybatisPlusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestMybatisPlusServiceImpl extends ServiceImpl<TestMybatisPlusMapper, TestMybatisPlus> implements ITestMybatisPlusService {

    @Resource
    private TestMybatisPlusMapper testMybatisPlusMapper;

    public List<UserDataVO> getUserList(UserDataDTO dto) {
        return null;
    }

    public List<TestMybatisPlus> getUserListPage(UserDataDTO dto, Long current, Long size) {
        QueryWrapper<TestMybatisPlus> queryWrapper = new QueryWrapper<TestMybatisPlus>();
        if (dto.getName() != null) {
            queryWrapper.like("name", dto.getName());
        }
        if (dto.getAge() != null) {
            queryWrapper.eq("age", dto.getAge());
        }

        //设置分页参数：页码、显示的条数
        Page<TestMybatisPlus> page = new Page<>(current, size);
        //第2个参数是条件构造器，如果设置为null，即查询所有
        //返回值就是一个Page对象，即返回上面所new出来的page对象，所有数据都在其中
        //对应的sql语句：SELECT id,name,age,email FROM user LIMIT ?
        testMybatisPlusMapper.selectPage(page, queryWrapper);
        //获取分页数据
        List<TestMybatisPlus> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
        return list;
    }

}
