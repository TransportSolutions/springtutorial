package com.springtutorial.backend.services;

import com.springtutorial.backend.persistence.domain.backend.Plan;
import com.springtutorial.backend.persistence.domain.backend.User;
import com.springtutorial.backend.persistence.domain.backend.UserRole;
import com.springtutorial.backend.persistence.repositories.PlanRepository;
import com.springtutorial.backend.persistence.repositories.RoleRepository;
import com.springtutorial.backend.persistence.repositories.UserRepository;
import com.springtutorial.enums.PlansEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by agrewal on 2/23/18.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {

        Plan plan = new Plan(plansEnum);
        // It makes sure the plans exist in the database
        if (!planRepository.exists(plansEnum.getId())) {
            plan = planRepository.save(plan);
        }

        user.setPlan(plan);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);

        user = userRepository.save(user);

        return user;

    }

}
