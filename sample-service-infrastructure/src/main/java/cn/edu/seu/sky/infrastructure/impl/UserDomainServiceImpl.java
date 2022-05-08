package cn.edu.seu.sky.infrastructure.impl;

import cn.edu.seu.sky.domain.api.UserDomainService;
import cn.edu.seu.sky.domain.entity.User;
import cn.edu.seu.sky.infrastructure.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaotian on 2022/5/7
 */
@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateById(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getId());
        userMapper.update(user, wrapper);
    }

    @Override
    public void deleteById(Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        userMapper.delete(wrapper);
    }

    @Override
    public User queryById(Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public List<User> queryByAge(Integer start, Integer end) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", start, end);
        wrapper.orderByDesc("create_time");
        return userMapper.selectList(wrapper);
    }

    @Override
    public PageInfo<User> queryPage(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(
                () -> userMapper.selectList(Wrappers.emptyWrapper()));
    }
}
