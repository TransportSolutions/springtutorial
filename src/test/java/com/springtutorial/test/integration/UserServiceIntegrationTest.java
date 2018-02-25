package com.springtutorial.test.integration;

import com.springtutorial.backend.persistence.domain.backend.User;
import com.springtutorial.backend.persistence.repositories.UserRepository;
import com.springtutorial.backend.services.UserService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by agrewal on 2/23/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest extends AbstractServiceIntegrationTest {

    @Rule
    public TestName testName = new TestName();
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createNewUser() throws Exception {
        User user = createUser(testName);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void updatePassword() throws Exception {
        User user = createUser(testName);
        String originalPassword = user.getPassword();
        String newPassword = UUID.randomUUID().toString();
        userService.updateUserPassword(user.getId(), newPassword);
        User updatedUser = userRepository.findByEmail(user.getEmail());
        Assert.assertNotEquals(updatedUser.getPassword(), originalPassword);
    }

}
