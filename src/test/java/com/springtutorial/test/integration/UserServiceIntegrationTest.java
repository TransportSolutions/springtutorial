package com.springtutorial.test.integration;

import com.springtutorial.backend.persistence.domain.backend.Role;
import com.springtutorial.backend.persistence.domain.backend.User;
import com.springtutorial.backend.persistence.domain.backend.UserRole;
import com.springtutorial.backend.services.UserService;
import com.springtutorial.enums.PlansEnum;
import com.springtutorial.enums.RolesEnum;
import com.springtutorial.utils.UserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by agrewal on 2/23/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void createNewUser() throws Exception {

        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser("Harinder", "agrewal0093@gmail.com");
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));
        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

    }
}
