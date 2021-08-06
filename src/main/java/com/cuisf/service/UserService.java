package com.cuisf.service;

import com.cuisf.entity.Perms;
import com.cuisf.entity.Role;
import com.cuisf.entity.User;

import java.util.List;

public interface UserService {

    void register(User user);

    User findByUserName(String username);

    User findRolesByUsername(String username);

    List<Perms> findPermsByRoleId(String id);
}
