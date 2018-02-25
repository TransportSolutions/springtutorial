package com.springtutorial.test.integration;

import com.springtutorial.backend.persistence.domain.backend.Role;
import com.springtutorial.backend.persistence.domain.backend.User;
import com.springtutorial.backend.persistence.domain.backend.UserRole;
import com.springtutorial.backend.services.UserService;
import com.springtutorial.enums.PlansEnum;
import com.springtutorial.enums.RolesEnum;
import com.springtutorial.utils.UserUtils;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by agrewal on 2/25/18.
 */
public abstract class AbstractServiceIntegrationTest {
    @Autowired
    protected UserService userService;

    protected User createUser(TestName testName) {
        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser(testName.getMethodName(), testName.getMethodName() + "@springtutorial.com");
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));
        return userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
    }
}
