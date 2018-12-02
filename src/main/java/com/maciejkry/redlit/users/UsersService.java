package com.maciejkry.redlit.users;

import java.util.ArrayList;

public interface UsersService {
    ArrayList<User> fetchUsers();
    void addUser(User user);
    User fetchUser(String userID);
    void removeUser(String userID);
}
