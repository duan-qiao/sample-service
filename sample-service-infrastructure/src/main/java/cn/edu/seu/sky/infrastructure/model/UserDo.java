package cn.edu.seu.sky.infrastructure.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xiaotian on 2022/6/2
 */
@Data
@TableName("user")
public class UserDo {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String account;

    @TableField("nick_name")
    private String nickName;

    private Integer age;

    private String telephone;

    private String email;

    private Integer status;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
