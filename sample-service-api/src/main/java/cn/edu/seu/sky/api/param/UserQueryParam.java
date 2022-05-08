package cn.edu.seu.sky.api.param;

import cn.edu.seu.sky.api.service.RpcParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaotian on 2022/5/7
 */
@Data
public class UserQueryParam implements Serializable, RpcParam {

    private static final long serialVersionUID = -6445907915323094080L;

    private Long telephone;

    private String account;



    @Override
    public void check() {

    }
}
