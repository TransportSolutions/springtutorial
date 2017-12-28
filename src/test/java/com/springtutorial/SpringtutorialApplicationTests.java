package com.springtutorial;

import com.springtutorial.web.i18n.I18NService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringtutorialApplicationTests {

    @Autowired
    private I18NService i18NService;

    @Test
    public void testMessageByLocaleService() throws Exception {
        String expectedText = "Full stack Spring boot application";
        String messageId = "index.main.callout";
        String actualText = i18NService.getMessage(messageId);
        Assert.assertEquals("Doesn't match", expectedText, actualText);
    }

}
