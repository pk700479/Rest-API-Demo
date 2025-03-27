package com.example.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;





public class UserService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "John Doe", "john@example.com"));
        users.add(new User(2, "Jane Doe", "jane@example.com"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean updateUser(int id, User updatedUser) {
        Optional<User> existingUser = users.stream().filter(user -> user.getId() == id).findFirst();
        if (existingUser.isPresent()) {
            users.remove(existingUser.get());
            users.add(updatedUser);
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
