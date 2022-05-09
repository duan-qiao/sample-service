package cn.edu.seu.sky.aggregation.user;

import java.time.LocalDateTime;
import java.util.List;

import cn.edu.seu.sky.aggregation.BaseTest;
import cn.edu.seu.sky.api.dto.UserDTO;
import cn.edu.seu.sky.domain.entity.User;
import cn.edu.seu.sky.service.convert.UserConvert;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author xiaotian on 2022/5/8
 */
public class UserServiceTest extends BaseTest {

    @Resource
    private UserConvert userConvert;

    @Test
    public void testConvert() {
        User user = new User();
        user.setId(0L);
        user.setAccount("java");
        user.setNickName("javascript");
        user.setAge(23);
        user.setTelephone("13305173766");
        user.setEmail("java@163.com");
        user.setStatus(1);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        UserDTO userDTO = userConvert.toTarget(user);
        System.out.println("target: " + userDTO);
        System.out.println("-------------------------------------");

        List<UserDTO> dtoList = userConvert.toTargets(Lists.newArrayList(user));
        dtoList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        User user1 = userConvert.toSource(userDTO);
        System.out.println("source: " + user1);
        System.out.println("-------------------------------------");

        List<User> list = userConvert.toSources(dtoList);
        list.forEach(System.out::println);
    }
}
