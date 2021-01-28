package cn.tedu.mapper;

import cn.tedu.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
    create database ssmdb;
    use ssmdb;
     create table user(id int,name varchar(20),age int ,addr varchar(20));
     insert into user values (1,'aaa',19,'bj');
     insert into user values (2,'bbb',29,'sh');
     insert into user values (3,'ccc',23,'gz');
     insert into user values (4,'ddd',31,'sz');
 */
public interface UserMapper {
    public List<User> selectBetweenAge(@Param("min") int min, @Param("max") int max);
    public void insertUser(User user);
}