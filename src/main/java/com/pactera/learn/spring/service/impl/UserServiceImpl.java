package com.pactera.learn.spring.service.impl;

import com.pactera.learn.spring.exception.ServiceException;
import com.pactera.learn.spring.mapper.UserMapper;
import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.entity.User;
import com.pactera.learn.spring.model.vo.UserDataVO;
import com.pactera.learn.spring.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDataVO getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<UserDataVO> getUserList(UserDataDTO dto) {
        return userMapper.getUserList(dto);
    }

    @Override
    public Boolean insertUser(UserDataDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return userMapper.insertUser(user) > 0;
    }

    @Override
    public Boolean insertUsers(List<UserDataDTO> dtoList) {
        List<User> userList = new ArrayList<User>();
        Iterator<UserDataDTO> iterator = dtoList.iterator();
        while (iterator.hasNext()) {
            UserDataDTO dto = iterator.next();
            User user = new User();
            BeanUtils.copyProperties(dto, user);
            userList.add(user);
        }
        return userMapper.insertUsers(userList) > 0;
    }

    @Override
    public Boolean updateUser(UserDataDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public UserDataVO getUserLeftJoinUserOther(Long id) {
        return userMapper.getUserLeftJoinUserOther(id);
    }

    @Override
    public UserDataVO testException(Long id) {
        throw new ServiceException("测试异常处理testException 抛出的自定义异常");
    }

    @Override
    @Transactional
    public Boolean testTransactional(UserDataDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        try {
            if (userMapper.updateUser(user) > 0) {
                return userMapper.testTransactionalDeleteUser(5L) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
