package miu.cs.ads_datapersisitence.repository;

import miu.cs.ads_datapersisitence.enums.Roles;
import miu.cs.ads_datapersisitence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(Roles roleName);
}