package cn.edu.seu.sky.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xiaotian on 2022/5/7
 */
@Data
public class User {

    private Long id;

    private String account;

    private String nickName;

    private Integer age;

    private String telephone;

    private String email;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
