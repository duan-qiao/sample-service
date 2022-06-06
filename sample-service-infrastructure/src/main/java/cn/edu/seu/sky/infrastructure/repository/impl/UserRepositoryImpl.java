package cn.edu.seu.sky.infrastructure.repository.impl;

import cn.edu.seu.sky.common.bean.PageResult;
import cn.edu.seu.sky.common.utils.BeanUtils;
import cn.edu.seu.sky.infrastructure.repository.UserRepository;
import cn.edu.seu.sky.domain.entity.User;
import cn.edu.seu.sky.domain.param.UserQueryReq;
import cn.edu.seu.sky.infrastructure.mapper.UserMapper;
import cn.edu.seu.sky.infrastructure.model.UserDo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaotian on 2022/5/7
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        UserDo userDo = BeanUtils.copy(user, UserDo::new);
        userMapper.insert(userDo);
    }

    @Override
    public void updateById(User user) {
        UserDo userDo = BeanUtils.copy(user, UserDo::new);
        userMapper.updateById(userDo);
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public User queryById(Long id) {
        return BeanUtils.copy(userMapper.selectById(id), User::new);
    }

    @Override
    public List<User> queryByAge(Integer start, Integer end) {
        LambdaQueryWrapper<UserDo> wrapper = new LambdaQueryWrapper<UserDo>()
                .between(UserDo::getAge, start, end)
                .orderByDesc(UserDo::getCreateTime);
        return BeanUtils.copyList(userMapper.selectList(wrapper), User::new);
    }

    @Override
    public PageResult<User> queryPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserDo> list = userMapper.selectList(Wrappers.emptyWrapper());
        return PageResult.of(PageInfo.of(list), User::new);
    }

    @Override
    public List<User> queryByCond(UserQueryReq request) {
        LambdaQueryWrapper<UserDo> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(request.getTelephone())) {
            wrapper.eq(UserDo::getTelephone, request.getTelephone());
        }
        if (StringUtils.isNotBlank(request.getNickName())) {
            wrapper.like(UserDo::getNickName, request.getNickName());
        }
        if (!CollectionUtils.isEmpty(request.getStatus())) {
            wrapper.in(UserDo::getStatus, request.getStatus());
        }
        if (request.getCreateTimeStart() != null) {
            wrapper.ge(UserDo::getCreateTime, request.getCreateTimeStart());
        }
        if (request.getCreateTimeEnd() != null) {
            wrapper.ge(UserDo::getCreateTime, request.getCreateTimeEnd());
        }
        wrapper.orderByDesc(UserDo::getCreateTime);
        return BeanUtils.copyList(userMapper.selectList(wrapper), User::new);
    }
}
