package cn.edu.seu.sky.service.impl;

import cn.edu.seu.sky.api.dto.UserDTO;
import cn.edu.seu.sky.api.param.UserQueryParam;
import cn.edu.seu.sky.api.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaotian on 2022/5/7
 */
@Service
public class UserServiceImpl implements UserService {

//    @Resource
//    private UserDomainService userDomainService;

    @Override
    public void saveOrUpdate(UserDTO userDTO) {

    }

    @Override
    public List<UserDTO> queryUser(UserQueryParam param) {
        return null;
    }
}
