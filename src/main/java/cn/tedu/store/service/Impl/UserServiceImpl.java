package cn.tedu.store.service.Impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UsernameDuplicateException;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void reg(User user) {
		// 输出日志
		System.err.println("UserServiceImp.reg()");
		System.err.println("\t注册数据：" + user);
		// 从参数user中获取用户名
		String username = user.getUsername();
		// 调用userMapper的findByUsername()方法执行查询
		User result = userMapper.findByUsername(username);
		// 判断查询结果是否不为null
		if (result != null) {
			// 是：查询结果不为null，表示用户名已经被占用，则抛出UsernameDuplicateException
			throw new UsernameDuplicateException();
		}

		// 准备执行注册
		// 补全数据：加密后的密码，盐值
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);
		String md5Password = getMd5Password(user.getPassword(), salt);
		user.setPassword(md5Password);
		// 补全数据：isDelete：值为0
		user.setIsDelete(0);
		// 补全数据：4项日志
		Date now = new Date();
		user.setCreatedUser(username);
		user.setCreatedTime(now);
		user.setModifiedUser(username);
		user.setModifiedTime(now);
		// 调用userMapper的insert()方法执行注册，并获取返回的受影响行数
		System.err.println("\t插入数据：" + user);
		Integer rows = userMapper.insert(user);
		// 判断受影响的行数是否不为1
		if (rows != 1) {
			// 是：抛出InsertException
			throw new InsertException();
		}
	}
	
	/**
	 * 执行密码加密，获取加密后的密码
	 * @param password 原始密码
	 * @param salt 盐值
	 * @return 加密后的密码
	 */
	private String getMd5Password(
		String password, String salt) {
		// 加密规则：
		// 1. 使用“盐 + 密码 + 盐”作为原文
		// 2. 三重加密
		System.err.println("\t加密-原始密码：" + password);
		System.err.println("\t加密-盐值：" + salt);
		for (int i = 0; i < 3; i++) {
			password = DigestUtils.md5DigestAsHex(
				(salt + password + salt).getBytes());
		}
		System.err.println("\t加密-密文：" + password);
		return password;
	}

}








