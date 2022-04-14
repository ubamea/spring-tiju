package com.aubamea.exercise.com.aubamea.exercise.app.services;

import com.aubamea.exercise.com.aubamea.exercise.app.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findUsers();
    void saveUser(UserDto userDto);
    void delete(Long id);
    UserDto findById(Long id);
}
