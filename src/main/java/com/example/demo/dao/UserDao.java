package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2019/6/19.
 *
 * @author yangsen
 */
@Mapper
public interface UserDao {

    Integer insert(User user);

}
