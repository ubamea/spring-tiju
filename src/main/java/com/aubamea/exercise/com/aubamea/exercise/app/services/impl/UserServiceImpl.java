package com.aubamea.exercise.com.aubamea.exercise.app.services.impl;

import com.aubamea.exercise.com.aubamea.exercise.app.dto.UserDto;
import com.aubamea.exercise.com.aubamea.exercise.app.entities.User;
import com.aubamea.exercise.com.aubamea.exercise.app.exceptions.models.BusinessException;
import com.aubamea.exercise.com.aubamea.exercise.app.mapper.UserMapper;
import com.aubamea.exercise.com.aubamea.exercise.app.repositories.IUserRepository;
import com.aubamea.exercise.com.aubamea.exercise.app.services.IUserService;
import org.hibernate.query.criteria.internal.BasicPathUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

private final IUserRepository iUserRepository;
private final UserMapper userMapper;

    public UserServiceImpl(IUserRepository iUserRepository, UserMapper userMapper) {
        this.iUserRepository = iUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> findUsers() {
        return userMapper.userListToDtoList(iUserRepository.findAll());
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = userMapper.dtoToUser(userDto);
        iUserRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public UserDto findById(Long id) {
        User user = iUserRepository.findById(id).orElse(null);
        if (user == null) {
            throw new BusinessException("User not found");
        }
        return userMapper.userToUserDto(user);
    }
}
