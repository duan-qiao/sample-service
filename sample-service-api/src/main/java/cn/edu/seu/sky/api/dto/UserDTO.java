package cn.edu.seu.sky.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiaotian on 2022/5/7
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 405570241619642534L;

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
