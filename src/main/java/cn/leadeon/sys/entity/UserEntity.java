package cn.leadeon.sys.entity;


import lombok.Data;

@Data
public class UserEntity {
    private String id;
    private String code;
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private String birth;

}
