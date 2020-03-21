package cn.tedu.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.JsonResult;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService userService;
	
	// http://localhost:8080/users/reg?username=controller&password=1234&gender=0&phone=13100131001&email=controller@qq.com
	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {
		JsonResult<Void> jsonResult = new JsonResult<Void>();
		userService.reg(user);
		jsonResult.setState(1);
		return jsonResult;
	}
	
	@ExceptionHandler
	public JsonResult<Void> handleException(Throwable ex) {
		JsonResult<Void> jsonResult = new JsonResult<Void>();
		
		if (ex instanceof UsernameDuplicateException) {
			jsonResult.setState(2);
			jsonResult.setMessage("注册失败！尝试注册的用户名已经被占用！");
		} else if (ex instanceof InsertException) {
			jsonResult.setState(3);
			jsonResult.setMessage("注册失败！执行插入数据时出现未知错误！请联系系统管理员！");
		}
		
		return jsonResult;
	}

}







