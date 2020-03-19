package cn.tedu.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper mapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("spring");
        user.setPassword("1234");
        System.err.println(user);
        Integer rows = mapper.insert(user);
        System.err.println("rows=" + rows);
        System.err.println(user);
    }

    @Test
    public void findByUsername() {
        String username = "project";
        User result = mapper.findByUsername(username);
        System.err.println(result);
    }

}












