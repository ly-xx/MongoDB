package com.daqsoft.mongo.dao;

import com.daqsoft.mongo.entity.UserDTO;

/**
 * @author lxx
 * @version V1.0.0
 * @date 2018-2-23
 */

public interface UserDao {

    void saveUser(UserDTO dto);

    UserDTO findUserByUserName(String userName);

    void updateUser(UserDTO dto);

    void deleteUserById(Long id);
}
