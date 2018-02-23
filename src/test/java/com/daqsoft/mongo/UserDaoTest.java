package com.daqsoft.mongo;

import com.daqsoft.mongo.dao.UserDao;
import com.daqsoft.mongo.entity.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lxx
 * @version V1.0.0
 * @date 2018-2-23
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() throws Exception {
        UserDTO user = new UserDTO();
        user.setId(3l);
        user.setUserName("测试1号");
        user.setPassWord("1111");
        userDao.saveUser(user);
    }
    @Test
    public void findUserByUserName() {
        UserDTO user = userDao.findUserByUserName("测试1号");
        System.out.println("user is " + user);
    }
    @Test
    public void updateUser() {
        UserDTO user = new UserDTO();
        user.setId(3l);
        user.setUserName("修改测试1号");
        user.setPassWord("2222");
        userDao.updateUser(user);
    }
    @Test
    public void deleteUserById() {
        userDao.deleteUserById(2l);
    }
}
