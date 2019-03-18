package com.netease.assignment.dao;

import com.netease.assignment.meta.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IUserDao {

    public void addUser(User user);

    public void deleteUser(Integer id);

    public User getUser(String userName);

    public List<User> getUsers();

    public void updateUser(User user);
}
