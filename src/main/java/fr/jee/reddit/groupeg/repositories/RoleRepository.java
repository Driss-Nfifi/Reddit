package fr.jee.reddit.groupeg.repositories;

import fr.jee.reddit.groupeg.models.Role;
import fr.jee.reddit.groupeg.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    public Role findRoleByRole(String role);
}
