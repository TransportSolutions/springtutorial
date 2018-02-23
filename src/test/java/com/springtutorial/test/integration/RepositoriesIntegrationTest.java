package com.springtutorial.test.integration;

import com.springtutorial.backend.persistence.domain.backend.Plan;
import com.springtutorial.backend.persistence.domain.backend.Role;
import com.springtutorial.backend.persistence.domain.backend.User;
import com.springtutorial.backend.persistence.domain.backend.UserRole;
import com.springtutorial.backend.persistence.repositories.PlanRepository;
import com.springtutorial.backend.persistence.repositories.RoleRepository;
import com.springtutorial.backend.persistence.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by agrewal on 2/23/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RepositoriesIntegrationTest {

    private static final int BASIC_PLAN_ID = 1;
    private static final int BASIC_ROLE_ID = 1;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void init() {
        assertNotNull(planRepository);
        assertNotNull(userRepository);
        assertNotNull(roleRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findOne(BASIC_PLAN_ID);
        assertEquals(retrievedPlan.getName(), "basic plan");
    }

    @Test
    public void testCreateNewRole() throws Exception {
        Role role = createBasicRole();
        roleRepository.save(role);
        Role retrievedRole = roleRepository.findOne(BASIC_ROLE_ID);
        assertEquals(retrievedRole.getName(), "basic role");
    }

    @Test
    public void testCreateNewUser() throws Exception {
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        User user = createBasicUser();
        user.setPlan(basicPlan);

        Role role = createBasicRole();

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);

        user.getUserRoles().addAll(userRoles);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user = userRepository.save(user);
        User retrievedUser = userRepository.findOne(user.getId());
        assertNotNull(retrievedUser);
        assertEquals(retrievedUser.getCountry(), "India");
        assertEquals(retrievedUser.getPlan().getName(), "basic plan");
        Set<UserRole> createdUserRoles = retrievedUser.getUserRoles();
        for (UserRole ur : createdUserRoles) {
            assertNotNull(ur.getUser().getId());
            assertNotNull(ur.getRole().getId());
        }
    }

    private User createBasicUser() {
        User user = new User();
        user.setCountry("India");
        user.setFirstName("Amrinder");
        user.setLastName("Grewal");
        user.setEmail("email");
        user.setPassword("12345");
        user.setPhoneNumber("839498234");
        user.setUsername("admin");
        return user;
    }

    private Role createBasicRole() {
        Role role = new Role();
        role.setId(BASIC_ROLE_ID);
        role.setName("basic role");
        return role;
    }

    private Plan createBasicPlan() {
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("basic plan");
        return plan;
    }

}
