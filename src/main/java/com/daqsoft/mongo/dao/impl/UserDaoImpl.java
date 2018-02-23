package com.daqsoft.mongo.dao.impl;

import com.daqsoft.mongo.dao.UserDao;
import com.daqsoft.mongo.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author lxx
 * @version V1.0.0
 * @date 2018-2-23
 */

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserDTO dto) {
        mongoTemplate.save(dto);
    }

    @Override
    public UserDTO findUserByUserName(String userName) {
        Query query=new Query(Criteria.where("userName").is(userName));
        UserDTO user =  mongoTemplate.findOne(query , UserDTO.class);
        return user;
    }

    @Override
    public void updateUser(UserDTO dto) {
        Query query=new Query(Criteria.where("id").is(dto.getId()));
        Update update= new Update().set("userName", dto.getUserName()).set("passWord", dto.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,UserDTO.class);
    }

    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserDTO.class);
    }
}
