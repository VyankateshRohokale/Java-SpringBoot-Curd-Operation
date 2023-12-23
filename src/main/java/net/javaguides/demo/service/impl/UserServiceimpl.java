package net.javaguides.demo.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.demo.entity.user;
import net.javaguides.demo.repository.UserRepository;
import net.javaguides.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceimpl implements UserService
{
    private UserRepository userRepository;
    @Override
    public user createUser(user user) {
        return userRepository.save(user);
    }

    @Override
    public user getUserById(Long userId) {

          Optional<user> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<user> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public user updateUser(Long userId, user User)
    {
        user existingUser = userRepository.findById(userId).get();
        existingUser.setFirstName(User.getFirstName());
        existingUser.setLastName(User.getLastName());
        existingUser.setEmail(User.getEmail());
        user updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
    }
}

