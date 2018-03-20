package com.springtutorial.backend.services;

import com.springtutorial.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by agrewal on 1/8/18.
 */
public interface EmailService {

    public void sendFeedbackMessage(FeedbackPojo feedbackPojo);

    public void sendGenericEmailMessage(SimpleMailMessage message);
}
