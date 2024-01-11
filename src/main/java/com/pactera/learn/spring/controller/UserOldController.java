package com.pactera.learn.spring.controller;

import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.vo.UserDataVO;
import com.pactera.learn.spring.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/odl_api")
public class UserOldController {

    //    @Autowired
    @Resource
    private IUserService userService;

    @GetMapping("get_user_list")
    public List<UserDataVO> getUserList() {
        List<UserDataVO> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            UserDataVO userDataVO = new UserDataVO();
            userDataVO.setAge(i);
            userDataVO.setName("小" + i);
            userList.add(userDataVO);
        }
        return userList;
    }

    @GetMapping("/user/{id}")
    public UserDataVO getUserDetail(@PathVariable Integer id) {
        System.out.println("成功获取 id = " + id + " 的数据");
        UserDataVO userDataVO = new UserDataVO();
        userDataVO.setName("小" + id);
        return userDataVO;
    }

    @PostMapping("insert_user")
    public UserDataDTO insertUser(@RequestBody UserDataDTO dto) {
        return dto;
    }

    @PostMapping("insert_user2")
    public Boolean insertUser2(@RequestBody UserDataDTO dto) {
        return userService.insertUser(dto);
    }

    @PostMapping("insert_user_list")
    public List<UserDataDTO> insertUserList(@RequestBody List<UserDataDTO> dtoList) {
        return dtoList;
    }

    @PutMapping("update_user")
    public UserDataDTO updateUser(@RequestBody UserDataDTO dto) {
        return dto;
    }

    @DeleteMapping("/delete_user/{id}")
    public UserDataDTO deleteUser(@PathVariable Long id) {
        System.out.println("成功删除 id = " + id + " 的数据");
        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setId(id);
        return userDataDTO;
    }
}
