package com.springtutorial.web.domain.frontend;

import java.io.Serializable;

/**
 * Created by agrewal on 1/8/18.
 */
public class FeedbackPojo implements Serializable {

    private static final long serialVerisionUID=1L;

    private String email;
    private String firstName;

    @Override
    public String toString() {
        return "FeedbackPojo{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    private String lastName;
    private String feedback;
}
