package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService service;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("impl");
            user.setPassword("123456");
            service.reg(user);
            System.err.println("OK");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
        }
    }

}
