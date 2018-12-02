package com.maciejkry.redlit.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collections;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository db;

    @Override
    public ArrayList<User> fetchUsers() {
        ArrayList list = new ArrayList();
        Collections.addAll(list, db.findAll());
        return list;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User fetchUser(String username) {
        return null;
    }

    @Override
    public void removeUser(String username) {

    }
}
