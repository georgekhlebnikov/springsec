package web.service;

import web.dao.RoleJpaDAO;
import web.dao.UserJpaDAO;
import web.model.Role;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserJpaServiceImpl implements UserJpaService {

    @Autowired
    private UserJpaDAO userJpaDAO;

    @Autowired
    private RoleJpaDAO roleJpaDAO;

    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        Set<Role> roles = new HashSet<>();
        roles.add(roleJpaDAO.getOne(1));
        user.setRoles(roles);
        userJpaDAO.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userJpaDAO.findByUsername(username);
    }
}