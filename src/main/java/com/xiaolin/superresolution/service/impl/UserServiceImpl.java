package com.xiaolin.superresolution.service.impl;

import com.xiaolin.superresolution.dao.UserRepository;
import com.xiaolin.superresolution.model.entity.User;
import com.xiaolin.superresolution.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author xlxing
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String getToken(String username, String password) {
        //1. 如果token存在，直接返回
        //2. 根据username从数据库中读取密码
        //3. 判断密码是否匹配
        //4. 生成token

        Optional<User> user = userRepository.findById(0L);
        return username + password;
    }

    @Override
    public boolean addUser(String username, String password) {
        return false;
    }

    @Override
    public boolean queryUserByUsername(String username) {
        return false;
    }

    @Override
    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        return false;
    }
}
