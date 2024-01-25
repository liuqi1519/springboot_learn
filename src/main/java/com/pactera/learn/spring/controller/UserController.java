package com.pactera.learn.spring.controller;

import com.pactera.learn.spring.common.MinioTemplate;
import com.pactera.learn.spring.common.R;
import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.vo.UserDataVO;
import com.pactera.learn.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private IUserService userService;

    @Autowired
    private MinioTemplate minioTemplate;

    /**
     * 获取用户
     *
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
//    @Cacheable(value = "getUserList", key = "#dto.id")    多条件查询的list不建议用缓存
    public List<UserDataVO> getUserList(UserDataDTO dto) {
        return userService.getUserList(dto);
    }

    /**
     * 新增用户
     *
     * @param dto
     * @return {@link Boolean}
     */
    @PostMapping("insert_user")
    public Boolean insertUser(@RequestBody UserDataDTO dto) {
        return userService.insertUser(dto);
    }

    /**
     * 批量新增用户
     *
     * @param dtoList
     */
    @PostMapping("insert_users")
    public Boolean insertUsers(@RequestBody List<UserDataDTO> dtoList) {
        return userService.insertUsers(dtoList);
    }

    /**
     * 更新用户
     *
     * @param dto
     * @return {@link Boolean}
     */
    @PutMapping("update_user")
    public Boolean updateUser(@RequestBody UserDataDTO dto) {
        return userService.updateUser(dto);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return {@link Boolean}
     */
    @DeleteMapping("delete_user/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    /**
     * 获取用户详细信息
     *
     * @param id
     * @return {@link UserDataVO}
     */
    @GetMapping("get_user_left_join_user_other/{id}")
    public UserDataVO getUserLeftJoinUserOther(@PathVariable Long id) {
        return userService.getUserLeftJoinUserOther(id);
    }

    /**
     * 测试异常处理
     *
     * @param id
     * @return {@link UserDataVO}
     */
    @GetMapping("test_exception/{id}")
    public UserDataVO testException(@PathVariable Long id) {
        return userService.testException(id);
    }

    /**
     * 测试事务处理
     *
     * @param dto
     * @return {@link Boolean}
     */
    @PutMapping("test_transactional")
    public Boolean testTransactional(@RequestBody UserDataDTO dto) {
        return userService.testTransactional(dto);
    }

    /**
     * 测试缓存
     *
     * @param id
     * @return {@link UserDataVO}
     */
    @Cacheable("testCache")
    @GetMapping("test_cache/{id}")
    public UserDataVO testCache(@PathVariable Long id) {
        System.out.println("Fetching user from the database: " + id);
        return userService.getUser(id);
    }

    /**
     * 测试清除缓存
     *
     * @param id
     * @return {@link String}
     */
    // 使用 @CacheEvict 注解表示在调用该方法后会清除缓存中指定的数据
    @CacheEvict("testCache")
    @GetMapping("/clear_cache/{id}")
    public String clearCache(@PathVariable Long id) {
        System.out.println("Clearing cache for user: " + id);
        // 这里可以添加其他清理逻辑
        return "Cache cleared for user: " + id;
    }

    /**
     * 测试共通相应体 Result 的封装（多条）
     *
     * @param dto
     * @return {@link UserDataVO}
     */
    @GetMapping("test_result_r_all")
    public R<List<UserDataVO>> testResultRAll(UserDataDTO dto) {
        return R.success("获取多条数据成功", userService.getUserList(dto));
    }

    /**
     * 测试共通相应体 Result 的封装（单条）
     *
     * @param id
     * @return {@link UserDataVO}
     */
    @GetMapping("/test_result_r_one/{id}")
    public R<UserDataVO> testResultROne(@PathVariable Long id) {
        return R.success("获取单条数据成功", userService.getUser(id));
    }

    /**
     * 上传文件
     *
     * @param file
     * @return {@link Boolean}
     */
    @PostMapping("/upload/")
    public Boolean upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String uploadDir = "upload/20240123";
                File uploadDirFile = new File(uploadDir);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }
                Path filePath = Path.of(uploadDir, file.getOriginalFilename());
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File uploaded: " + file.getOriginalFilename());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * 上传头像
     *
     * @param file
     * @return {@link String}
     * @throws Exception
     */
    @PostMapping("/uploadAvatar/")
    public String uploadAvatar(@RequestParam("file") MultipartFile file) throws Exception {
        return minioTemplate.putObject(file.getInputStream(), file.getContentType());
    }
}
