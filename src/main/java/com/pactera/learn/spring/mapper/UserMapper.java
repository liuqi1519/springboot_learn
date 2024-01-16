package com.pactera.learn.spring.mapper;

import com.pactera.learn.spring.model.dto.UserDataDTO;
import com.pactera.learn.spring.model.entity.User;
import com.pactera.learn.spring.model.vo.UserDataVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

//    @Select("SELECT * FROM user WHERE name = #{req.name}")
//    @Update("UPDATE user SET name = 'Nianhua' WHERE ***")
//    @Delete("DELETE FROM ")
//    @Insert("INSERT INTO `user` (id, name, age, email, avatar) VALUE ()")

    UserDataVO getUser(@Param("id") Long id);

    List<UserDataVO> getUserList(@Param("req") UserDataDTO dto);

    int insertUser(@Param("user") User user);

    int insertUsers(@Param("userList") List<User> userList);

    int updateUser(@Param("user") User user);

    int deleteUser(@Param("id") Long id);

    UserDataVO getUserLeftJoinUserOther(@Param("id") Long id);

    UserDataVO testException(@Param("id") Long id);

    int testTransactionalDeleteUser(@Param("id") Long id);
}
