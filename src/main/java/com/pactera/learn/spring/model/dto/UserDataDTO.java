package com.pactera.learn.spring.model.dto;

public class UserDataDTO {

    /** 逐渐ID */
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private int age;
    /** 邮箱 */
    private String email;
    /** 头像 */
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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