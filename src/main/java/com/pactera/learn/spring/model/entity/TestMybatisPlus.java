package com.pactera.learn.spring.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class TestMybatisPlus {

    /** 主键ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /** 姓名 */
    @TableField("name")
    private String name;
    /** 年龄 */
    @TableField("age")
    private Integer age;
    /** 邮箱 */
    @TableField("email")
    private String email;
    /** 头像 */
    @TableField("avatar")
    private String avatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
