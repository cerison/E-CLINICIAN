package miu.cs.ADS.repository;

import miu.cs.ADS.enums.Roles;
import miu.cs.ADS.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(Roles roleName);
}