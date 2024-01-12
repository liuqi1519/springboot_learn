package com.pactera.learn.spring.model.dto;

public class UserOtherDataDTO {

    /** 主键ID */
    private Long id;
    /** USER ID */
    private Long userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}