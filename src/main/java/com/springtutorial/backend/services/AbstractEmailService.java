package com.springtutorial.backend.services;

import com.springtutorial.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by agrewal on 1/8/18.
 */
public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.address}")
    private String defaultToAddress;

    private SimpleMailMessage prepareSimpleMailMessage(FeedbackPojo feedbackPojo) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(defaultToAddress);
        simpleMailMessage.setFrom(feedbackPojo.getEmail());
        simpleMailMessage.setSubject("Spring Tutorial: Feedback received from " + feedbackPojo.getFirstName() + " " + feedbackPojo.getLastName() + "!");
        simpleMailMessage.setText(feedbackPojo.getFeedback());
        return simpleMailMessage;
    }

    @Override
    public void sendFeedbackMessage(FeedbackPojo feedbackPojo) {
        sendGenericEmailMessage(prepareSimpleMailMessage(feedbackPojo));
    }
}
