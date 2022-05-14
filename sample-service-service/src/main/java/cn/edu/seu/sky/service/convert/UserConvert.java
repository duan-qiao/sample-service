package cn.edu.seu.sky.service.convert;

import cn.edu.seu.sky.api.dto.UserDTO;
import cn.edu.seu.sky.domain.entity.User;
import org.mapstruct.Mapper;

/**
 * @author xiaotian on 2022/5/8
 */
@Mapper(componentModel = "spring")
public interface UserConvert extends BaseConvert<User, UserDTO> {
}
