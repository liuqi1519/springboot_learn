package com.pactera.learn.spring.mapper;

import com.pactera.learn.spring.model.dto.UserOtherDataDTO;
import com.pactera.learn.spring.model.entity.UserOther;
import com.pactera.learn.spring.model.vo.UserOtherDataVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserOtherMapper {

    UserOtherDataVO getUserOther(@Param("id") Long id);

    List<UserOtherDataVO> getUserOtherList(@Param("req") UserOtherDataDTO dto);

    int insertUserOther(@Param("userOther") UserOther userOther);

    int insertUserOthers(@Param("userOtherList") List<UserOther> userOtherList);

    int updateUserOther(@Param("userOther") UserOther userOther);

    int deleteUserOther(@Param("id") Long id);
}
