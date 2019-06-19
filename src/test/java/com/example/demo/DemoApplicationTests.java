package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserDao userDao;

    @Test
    public void contextLoads() {
        User user=new User();
        user.setId(135);
        user.setUserId(42);
        user.setName("111");
        user.setAge(34);
        System.out.println(userDao.insert(user));
    }

}
