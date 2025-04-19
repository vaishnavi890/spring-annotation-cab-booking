package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        if (user != null && user.getUserId() > 0) {
            userRepository.addUser(user);
        } else {
            System.out.println(" Invalid User Details. Cannot Register.");
        }
    }

    public List<User> fetchAllUsers() {
        return userRepository.getAllUsers();
    }

    public void modifyUser(User user) {
        if (user != null && user.getUserId() > 0) {
            userRepository.updateUser(user);
        } else {
            System.out.println(" Invalid User Details. Cannot Update.");
        }
    }

    public void removeUser(int userId) {
        if (userId > 0) {
            userRepository.deleteUser(userId);
        } else {
            System.out.println(" Invalid User ID. Cannot Delete.");
        }
    }
}


