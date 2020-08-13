package web.dao;

import web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaDAO extends JpaRepository<Role, Integer> {
}
