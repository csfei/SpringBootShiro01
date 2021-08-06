package com.cuisf.service;

import com.cuisf.dao.UserDao;
import com.cuisf.entity.Perms;
import com.cuisf.entity.Role;
import com.cuisf.entity.User;
import com.cuisf.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public void register(User user) {

        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);

        //明文密码加密
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        userDao.save(user);
    }

    @Override
    public User findByUserName(String username) {

        User user = userDao.findByUserName(username);
        return user;
    }

    @Override
    public User findRolesByUsername(String username) {

        return userDao.findRolesByUsername(username);

    }

    @Override
    public List<Perms> findPermsByRoleId(String id) {

        List<Perms> perms = userDao.findPermsByRoleId(id);
        return perms;
    }


}
