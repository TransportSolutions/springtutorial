package com.springtutorial.backend.persistence.repositories;

import com.springtutorial.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by agrewal on 2/23/18.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Return a username or null if not found
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
