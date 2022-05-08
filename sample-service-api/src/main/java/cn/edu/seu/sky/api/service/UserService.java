package cn.edu.seu.sky.api.service;

import cn.edu.seu.sky.api.dto.UserDTO;
import cn.edu.seu.sky.api.param.UserQueryParam;

import java.util.List;

/**
 * @author xiaotian on 2022/5/7
 */
public interface UserService {
    /**
     * 保存或更新
     * @param userDTO 用户信息
     */
    void saveOrUpdate(UserDTO userDTO);

    /**
     * 用户查询
     * @param param 查询参数
     * @return 用户列表
     */
    List<UserDTO> queryUser(UserQueryParam param);
}
