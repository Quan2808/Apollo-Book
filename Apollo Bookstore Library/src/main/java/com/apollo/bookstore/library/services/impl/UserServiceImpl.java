package com.apollo.bookstore.library.services.impl;

import com.apollo.bookstore.library.dto.UserDto;
import com.apollo.bookstore.library.models.Role;
import com.apollo.bookstore.library.models.User;
import com.apollo.bookstore.library.repositories.RoleRepository;
import com.apollo.bookstore.library.repositories.UserRepository;
import com.apollo.bookstore.library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor()
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserDto userDto) {

        Role setRole = roleRepository.findByName("customer");
        Set<Role> roles = new HashSet<>();
        roles.add(setRole);

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto getUser(String username) {
        UserDto userDto = new UserDto();
        User user = userRepository.findByUsername(username);
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setCity(user.getCity());
        userDto.setCountry(user.getCountry());
        return new UserDto();
    }

    @Override
    public User changePass(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User update(UserDto dto) {
        User user = userRepository.findByUsername(dto.getUsername());
        user.setCity(dto.getCity());
        user.setCountry(dto.getCountry());
        user.setPhoneNumber(dto.getPhoneNumber());
        return userRepository.save(user);
    }
}
