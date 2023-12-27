package com.springboot.assignment3.password;

import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.DoctorUserDTO;
import com.springboot.assignment3.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.UnsupportedEncodingException;

@Service
@Transactional
public class MailService {
    @Autowired
    UserService userService;

    @Autowired
    JavaMailSender javaMailSender;

    // gửi mã token reset pw qua mail
    public void sendPasswordResetVerificationEmail(String url,String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Password Reset Request Verification";
        String senderName = "User Forgot Password Service";
        String mailContent = "<p> Hi, "+ userService.findUserByEmail(email).getName()+ ", </p>"+
                "<p><b>You recently requested to reset your password,</b>"+"" +
                "Please, follow the link below to complete the action.</p>"+
                "<p>Link Reset password : </p>"+
                "<a href=\"" +url+ "\"></a>"+ url +
                "<p> Users Forgot Password Service";
        MimeMessage message = javaMailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("phong422000@gmail.com", senderName);
        messageHelper.setTo(userService.findUserByEmail(email).getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        javaMailSender.send(message);
    }


    // gửi thông tin khám chữa bệnh qua mail
    public void sendInformationPatent(String fileName, String email, String subject, String body, byte[] pdfByte)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        String senderName = "Doctor";
        helper.setFrom("phong422000@gmail.com",senderName);
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(body);
        helper.addAttachment(fileName,new ByteArrayResource(pdfByte));
        javaMailSender.send(message);
    }
}
