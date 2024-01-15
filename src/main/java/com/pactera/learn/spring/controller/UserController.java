package com.pactera.learn.spring.controller;

import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.vo.UserDataVO;
import com.pactera.learn.spring.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 获取用户
     * @param id
     * @return {@link UserDataVO}
     */
    @GetMapping("get_user/{id}")
    public UserDataVO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    /**
     * 获取用户列表
     *
     * @param dto
     * @return {@link UserDataVO}
     */
    @GetMapping("get_user_list")
    public List<UserDataVO> getUserList(UserDataDTO dto) {
        return userService.getUserList(dto);
    }

    /**
     * 新增用户
     * @param dto
     * @return {@link Boolean}
     */
    @PostMapping("insert_user")
    public Boolean insertUser(@RequestBody UserDataDTO dto) {
        return userService.insertUser(dto);
    }

    /**
     * 批量新增用户
     * @param dtoList
     */
    @PostMapping("insert_users")
    public Boolean insertUsers(@RequestBody List<UserDataDTO> dtoList) {
        return userService.insertUsers(dtoList);
    }

    /**
     * 更新用户
     * @param dto
     * @return {@link Boolean}
     */
    @PutMapping("update_user")
    public Boolean updateUser(@RequestBody UserDataDTO dto) {
        return userService.updateUser(dto);
    }

    /**
     * 删除用户
     * @param id
     * @return {@link Boolean}
     */
    @DeleteMapping("delete_user/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    /**
     * 获取用户详细信息
     * @param id
     * @return {@link UserDataVO}
     */
    @GetMapping("get_user_left_join_user_other/{id}")
    public UserDataVO getUserLeftJoinUserOther(@PathVariable Long id) {
        return userService.getUserLeftJoinUserOther(id);
    }

    /**
     * 测试异常处理
     * @param id
     * @return {@link UserDataVO}
     */
    @GetMapping("test_exception/{id}")
    public UserDataVO testException(@PathVariable Long id)
    {
        return userService.testException(id);
    }
}
