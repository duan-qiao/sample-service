package cn.edu.seu.sky.domain.api;

import cn.edu.seu.sky.domain.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author xiaotian on 2022/5/7
 */
public interface UserDomainService {
    /**
     * 保存用户
     * @param user 用户
     */
    void save(User user);

    /**
     * 更新用户
     * @param user 用户
     */
    void updateById(User user);

    /**
     * 删除用户
     * @param id 用户ID
     */
    void deleteById(Long id);

    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     * @return 用户
     */
    User queryById(Long id);

    /**
     * 根据用户姓名查询用户
     * @param start 年龄
     * @param end 年龄
     * @return 用户列表
     */
    List<User> queryByAge(Integer start, Integer end);

    /**
     * 分页查询用户
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return 用户列表
     */
    PageInfo<User> queryPage(int pageNum, int pageSize);
}
