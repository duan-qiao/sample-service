package cn.edu.seu.sky.aggregation.user;

import cn.edu.seu.sky.aggregation.BaseTest;
import cn.edu.seu.sky.domain.api.UserDomainService;
import cn.edu.seu.sky.domain.entity.User;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaotian on 2022/5/8
 */
public class UserDomainServiceTest extends BaseTest {

    @Resource
    private UserDomainService userDomainService;

    @Test
    public void testSave() {
        User user = new User();
        user.setAccount("zhang.san");
        user.setNickName("张三");
        user.setAge(21);
        user.setTelephone("13300001111");
        user.setEmail("zhang.san@163.com");
        userDomainService.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setAccount("zhang.san");
        user.setNickName("张三");
        user.setAge(22);
        user.setTelephone("13300002222");
        user.setEmail("zhang.san@163.com");
        userDomainService.updateById(user);
    }

    @Test
    public void testQueryOne() {
        User user = userDomainService.queryById(1L);
        System.out.println(user);
    }

    @Test
    public void testQueryList() {
        List<User> users = userDomainService.queryByAge(20, 23);
        users.forEach(System.out::println);
    }

    @Test
    public void testQueryAll() {
        int pageNum = 1;
        int pageSize = 5;
        PageInfo<User> pageInfo;
        do {
            pageInfo = userDomainService.queryPage(pageNum, pageSize);
            pageInfo.getList().forEach(System.out::println);
            pageNum++;
        } while (pageInfo.isHasNextPage());
    }

    @Test
    public void testDelete() {
        userDomainService.deleteById(1L);
    }
}
