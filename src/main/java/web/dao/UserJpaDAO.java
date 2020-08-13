package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

public interface UserJpaDAO extends JpaRepository<User, Integer> {

    //переопределяем в UserService, UserServiceImpl
    User findByUsername(String username);

}
