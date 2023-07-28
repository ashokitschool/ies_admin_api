package in.ashokit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String subject, String body, String to){

        // logic to send email

        return true;
    }
}
