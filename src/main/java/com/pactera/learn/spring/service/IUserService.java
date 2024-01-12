package com.pactera.learn.spring.service;

import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.entity.User;
import com.pactera.learn.spring.model.vo.UserDataVO;

import java.util.List;

public interface IUserService {

    /**
     * 获取用户
     * @param id
     * @return {@link UserDataVO}
     */
    UserDataVO getUser(Long id);

    /**
     * 获取用户列表
     * @param dto
     * @return {@link UserDataVO}
     */
    List<UserDataVO> getUserList(UserDataDTO dto);

    /**
     * 创建用户
     * @param dto
     * @return {@link Boolean}
     */
    public Boolean insertUser(UserDataDTO dto);

    /**
     * 批量创建用户
     * @param dtoList
     * @return {@link Boolean}
     */
    public Boolean insertUsers(List<UserDataDTO> dtoList);

    /**
     * 更新用户
     * @param dto
     * @return {@link Boolean}
     */
    public Boolean updateUser(UserDataDTO dto);

    /**
     * 删除用户
     * @param id
     * @return {@link Boolean}
     */
    public Boolean deleteUser(Long id);

    /**
     * 获取用户详细信息
     * @param id
     * @return {@link UserDataVO}
     */
    public UserDataVO getUserLeftJoinUserOther(Long id);
}
