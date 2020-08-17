package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);

    User getUserById(Long id);

}
