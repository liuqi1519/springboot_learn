package com.pactera.learn.spring.model.vo;

public class UserDataVO {

    /** 逐渐ID */
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;
    /** 邮箱 */
    private String email;
    /** 头像 */
    private String avatar;
    /** USER ID */
    private Long userOtherId;
    /** 学号 */
    private String studentId;
    /** 身份证号 */
    private String idCard;

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

    public Long getUserOtherId() {
        return userOtherId;
    }

    public void setUserOtherId(Long userOtherId) {
        this.userOtherId = userOtherId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "UserDataVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userOtherId=" + userOtherId +
                ", studentId='" + studentId + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
