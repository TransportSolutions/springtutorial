package com.springtutorial.test.integration;

import com.springtutorial.backend.persistence.domain.backend.Plan;
import com.springtutorial.backend.persistence.domain.backend.Role;
import com.springtutorial.backend.persistence.domain.backend.User;
import com.springtutorial.backend.persistence.domain.backend.UserRole;
import com.springtutorial.backend.persistence.repositories.PlanRepository;
import com.springtutorial.backend.persistence.repositories.RoleRepository;
import com.springtutorial.backend.persistence.repositories.UserRepository;
import com.springtutorial.enums.PlansEnum;
import com.springtutorial.enums.RolesEnum;
import com.springtutorial.utils.UserUtils;
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
        Plan basicPlan = createBasicPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
        assertEquals(retrievedPlan.getName(), PlansEnum.BASIC.getPlanName());
    }

    @Test
    public void testCreateNewRole() throws Exception {
        Role role = createBasicRole(RolesEnum.BASIC);
        roleRepository.save(role);
        Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
        assertEquals(retrievedRole.getName(), RolesEnum.BASIC.getRoleName());
    }

    @Test
    public void testCreateNewUser() throws Exception {
        Plan basicPlan = createBasicPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        User user = UserUtils.createBasicUser("Amrinder", "email");
        user.setPlan(basicPlan);

        Role role = createBasicRole(RolesEnum.BASIC);

        UserRole userRole = new UserRole(user, role);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);

        user.getUserRoles().addAll(userRoles);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user = userRepository.save(user);
        User retrievedUser = userRepository.findOne(user.getId());
        assertNotNull(retrievedUser);
        assertEquals(retrievedUser.getCountry(), "GB");
        assertEquals(retrievedUser.getPlan().getName(), PlansEnum.BASIC.getPlanName());
        Set<UserRole> createdUserRoles = retrievedUser.getUserRoles();
        for (UserRole ur : createdUserRoles) {
            assertNotNull(ur.getUser().getId());
            assertNotNull(ur.getRole().getId());
        }
    }

    private Role createBasicRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
    }

    private Plan createBasicPlan(PlansEnum plansEnum) {
        return new Plan(plansEnum);
    }

}
