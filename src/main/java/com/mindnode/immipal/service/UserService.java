package com.mindnode.immipal.service;

import com.mindnode.immipal.exception.user.ChangePasswordException;
import com.mindnode.immipal.exception.user.UserException;
import com.mindnode.immipal.exception.user.WrongUserInformationException;
import com.mindnode.immipal.pojo.User;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
public interface UserService {
    void login(User user) throws WrongUserInformationException;

    void updatePassword(int id, String password, String ensure) throws ChangePasswordException;

    void add(User user,String password,String ensure) throws UserException;

    void delete(int userId);

    void update(User user);

    User get(int userId);

    User getByUsername(String username);

    List<User> listAll();

    List<User> listExceptAdmin();
}
