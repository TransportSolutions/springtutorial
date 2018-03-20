package com.springtutorial.backend.persistence.repositories;

import com.springtutorial.backend.persistence.domain.backend.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by agrewal on 2/23/18.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
