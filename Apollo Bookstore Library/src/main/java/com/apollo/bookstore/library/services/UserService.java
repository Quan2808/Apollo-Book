package com.apollo.bookstore.library.services;

import com.apollo.bookstore.library.dto.UserDto;
import com.apollo.bookstore.library.entities.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User save(UserDto customerDto);

    User findByUsername(String username);

    User update(UserDto customerDto);

    User changePass(UserDto customerDto);

    UserDto getUser(String username);
}
