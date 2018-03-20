package com.springtutorial.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;


/**
 * Created by agrewal on 1/8/18.
 */
public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        LOG.info("simulating an email service...");
        LOG.info(message.toString());
        LOG.info("Email sent.");
    }
}
