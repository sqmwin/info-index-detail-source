package com.mindnode.immipal.service;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.exception.user.ChangePasswordException;
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

    void add(User user);

    void delete(int userId);

    void update(User user);

    User get(int userId) throws NullObjectException;

    User getByUsername(String username) throws NullObjectException;

    List<User> listAll() throws NullListException;

    List<User> listExceptAdmin() throws NullListException;
}
