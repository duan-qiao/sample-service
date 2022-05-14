package cn.edu.seu.sky.domain.param;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xiaotian on 2022/5/12
 */
@Data
public class UserQueryReq {

    private String telephone;

    private String nickName;

    private List<Integer> status;

    private LocalDateTime createTimeStart;

    private LocalDateTime createTimeEnd;
}
