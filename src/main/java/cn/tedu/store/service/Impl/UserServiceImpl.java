package cn.tedu.store.service.Impl;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 重写抽象方法
     *
     * @param user 用户数据
     */
    @Override
    public void reg(User user) {
        //从参数user中获取用户名
        String username = user.getUsername();
        //调用userMapper的findByUsername()方法
        User result = userMapper.findByUsername(username);
        //判断是否不为null
        if (result != null) {
            //是：查询结果不为null，表示用户名已经存在
            throw new UsernameDuplicateException();
        }
        //准备执行注册
        //补全数据
        user.setIsDelete(0);
        //补全4项日志
        user.setCreatedUser(username);
        user.setCreatedTime(new Date());
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        //调用userMapper的insert()方法执行注册
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException();
        }


    }
}
