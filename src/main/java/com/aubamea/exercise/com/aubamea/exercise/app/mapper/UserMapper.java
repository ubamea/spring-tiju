package com.aubamea.exercise.com.aubamea.exercise.app.mapper;


import com.aubamea.exercise.com.aubamea.exercise.app.dto.UserDto;
import com.aubamea.exercise.com.aubamea.exercise.app.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User dtoToUser(UserDto userDto){
        return User.builder()
                .Id(userDto.getId() != null ? userDto.getId() : null)
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }

    public UserDto userToUserDto(User user){
    return UserDto.builder()
            .id(user.getId())
            .email(user.getEmail())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .build();
    }

    public List<UserDto>userListToDtoList(List<User> users){
        return users.stream().map(this::userToUserDto).collect(Collectors.toList());
    }

    public List<User> userDtoListToUserList(List<UserDto> userDtos){
        return userDtos.stream().map(this::dtoToUser).collect(Collectors.toList());
    }
}
