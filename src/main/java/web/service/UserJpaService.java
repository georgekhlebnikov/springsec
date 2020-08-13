package web.service;

import web.model.User;

public interface UserJpaService {

    void save(User user);

    User findByUsername(String username);
}
