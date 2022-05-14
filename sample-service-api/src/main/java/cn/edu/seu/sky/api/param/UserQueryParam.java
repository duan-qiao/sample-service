package cn.edu.seu.sky.api.param;

import cn.edu.seu.sky.api.service.RpcParam;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaotian on 2022/5/7
 */
@Data
public class UserQueryParam implements Serializable, RpcParam {

    private static final long serialVersionUID = -6445907915323094080L;

    private String telephone;

    private String nickName;

    private List<Integer> status;

    private Long createTimeStart;

    private Long createTimeEnd;

    @Override
    public void check() {

    }
}
