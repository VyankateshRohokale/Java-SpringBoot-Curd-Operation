package net.javaguides.demo.service;

import net.javaguides.demo.entity.user;
import org.apache.catalina.User;

import java.util.List;

public interface UserService
{
    user createUser(user user);

    user getUserById(Long userId);

   List<user> getAllUser();

    user updateUser(Long userId, user user);

    void deleteUser(Long userID);
}
