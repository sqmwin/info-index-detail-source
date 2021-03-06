package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.exception.user.ChangePasswordException;
import com.mindnode.immipal.exception.user.UserException;
import com.mindnode.immipal.exception.user.WrongUserInformationException;
import com.mindnode.immipal.mapper.UserMapper;
import com.mindnode.immipal.pojo.User;
import com.mindnode.immipal.pojo.UserExample;
import com.mindnode.immipal.service.UserService;
import com.mindnode.immipal.util.security.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Service
public class UserServiceImpl implements UserService {
    private final String EMPTY = "";
    @Autowired
    UserMapper userMapper;

    @Override
    public void login(User user) throws WrongUserInformationException {
        String username = user.getUserUsername();
        String password = user.getUserPassword();
        if (username == null || username.equals(EMPTY)) {
            throw new WrongUserInformationException("用户名不能为空");
        }
        if (password == null || password.equals(EMPTY)) {
            throw new WrongUserInformationException("密码不能为空");
        }
        String password2MD5Code = Md5Util.getMD5(password);
        List<User> users = userMapper.selectByExample(new UserExample());
        for (User userInDataBase : users) {
            if (!(username.equals(userInDataBase.getUserUsername()) && password2MD5Code.equals(userInDataBase.getUserPassword()))) {
                throw new WrongUserInformationException("用户名或密码错误");
            }
            if (username.equals(userInDataBase.getUserUsername()) && password2MD5Code.equals(userInDataBase.getUserPassword())) {
                return;
            }
        }
    }

    @Override
    public void updatePassword(int id, String password, String ensure) throws ChangePasswordException {
        final int min = 5;
        final int max = 16;
        boolean passwordIsEmpty = password == null || password.equals(EMPTY);
        boolean ensureIsEmpty = ensure == null || ensure.equals(EMPTY);
        //判断密码是否为空
        if (passwordIsEmpty && ensureIsEmpty) {
            throw new ChangePasswordException("密码不能为空");
        }
        if (!passwordIsEmpty && !ensureIsEmpty) {
            //判断两次密码是否相同
            if (!password.equals(ensure)) {
                throw new ChangePasswordException("两次密码要相同");
                //判断密码长度
            } else if (password.length() < min) {
                throw new ChangePasswordException("密码长度太短，密码长度为5-16位");
                //判断密码长度
            } else if (password.length() > max) {
                throw new ChangePasswordException("密码长度太长，密码长度为5-16位");
            } else {
                User user = userMapper.selectByPrimaryKey(id);
                String oldPassword = user.getUserPassword();
                String newPassword = Md5Util.getMD5(password);
                if (oldPassword != null && newPassword != null) {
                    //判断密码是否与旧密码相同
                    if (newPassword.equals(oldPassword)) {
                        throw new ChangePasswordException("新密码不能与旧密码相同");
                    } else {
                        user.setUserPassword(newPassword);
                        userMapper.updateByPrimaryKey(user);
                    }
                }
            }
        }
    }

    @Override
    public void add(User user,String password,String ensure) throws UserException {
        int minLength = 5;
        int maxLength = 16;
        String username = user.getUserUsername();
        int usernameLength = username.length();
        int passwordLength = password.length();
        boolean blankUsername = username.equals(EMPTY);
        boolean blankPassword = password.equals(EMPTY);
        boolean blankEnsure = password.equals(EMPTY);
        boolean right = !blankUsername && !blankPassword && password.equals(ensure) && usernameLength >= 5 && usernameLength <= 16 && passwordLength >= 5 && passwordLength <= 16;
        // 判断用户名是否为空
        if (blankUsername) {
            throw new UserException("用户名不能为空");
        }
        //判断用户名长度
        else if (username.length() < minLength) {
            throw new UserException("用户名不能少于5位");
        }
        else if (username.length() > maxLength) {
            throw new UserException("用户名不能大于16位");
        }
        //判断密码是否为空
        else if (blankPassword && blankEnsure) {
            throw new UserException("密码不能为空");
        }
        //判断密码是否与确认密码相同
        else if (!password.equals(ensure)) {
            throw new UserException("密码与确认密码不同");
        }
        //判断密码长度
        else if (password.length() < minLength) {
            throw new UserException("密码长度不能少于5位");
        }
        else if (password.length() > maxLength) {
            throw new UserException("密码长度不能大于16位");
        }
        //用户名和密码都符合要求的情况下
        else if (right){
            String password2MD5Code = Md5Util.getMD5(password);
            user.setUserPassword(password2MD5Code);
            userMapper.insert(user);
        }
    }

    @Override
    public void delete(int userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void update(User user) {
        String password = user.getUserPassword();
        String password2MD5Code = Md5Util.getMD5(password);
        user.setUserPassword(password2MD5Code);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User get(int userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User getByUsername(String username){
        UserExample example = new UserExample();
        example.createCriteria().andUserUsernameEqualTo(username);
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public List<User> listAll(){
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<User> listExceptAdmin(){
        UserExample example = new UserExample();
        example.createCriteria().andUserUsernameNotEqualTo("admin");
        return userMapper.selectByExample(example);
    }
}
