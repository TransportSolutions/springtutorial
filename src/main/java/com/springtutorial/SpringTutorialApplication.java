package com.springtutorial;

import com.springtutorial.backend.persistence.domain.backend.Role;
import com.springtutorial.backend.persistence.domain.backend.User;
import com.springtutorial.backend.persistence.domain.backend.UserRole;
import com.springtutorial.backend.services.PlanService;
import com.springtutorial.backend.services.UserService;
import com.springtutorial.enums.PlansEnum;
import com.springtutorial.enums.RolesEnum;
import com.springtutorial.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringTutorialApplication implements CommandLineRunner {

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(SpringTutorialApplication.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PlanService planService;

    @Value("${webmaster.admin}")
    private String webmasterUsername;

    @Value("${webmaster.password}")
    private String webmasterPassword;

    @Value("${webmaster.email}")
    private String webmasterEmail;


    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        LOG.info("Creating Basic and Pro plans in the database...");
        planService.createPlan(PlansEnum.BASIC.getId());
        planService.createPlan(PlansEnum.PRO.getId());

        LOG.info("Creating basic user...");
        User user = UserUtils.createBasicUser(webmasterUsername, webmasterEmail);
        user.setPassword(webmasterPassword);
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RolesEnum.ADMIN)));
        LOG.debug("Creating user with username {}", user.getUsername());
        userService.createUser(user, PlansEnum.PRO, userRoles);
        LOG.info("User {} created", user.getUsername());
    }
}
