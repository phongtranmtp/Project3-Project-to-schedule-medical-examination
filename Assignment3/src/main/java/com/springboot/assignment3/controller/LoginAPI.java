package com.springboot.assignment3.controller;

import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.MessageResponseDTO;
import com.springboot.assignment3.model.UserDTO;
import com.springboot.assignment3.password.MailService;
import com.springboot.assignment3.password.PasswordResetRequest;
import com.springboot.assignment3.service.UserService;
import com.springboot.assignment3.service.impl.JwtTokenService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@RestController
@Slf4j
public class LoginAPI {
    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    MailService mailService;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        // tạo ra 1 token trả về client
        return jwtTokenService.createToken(email);
    }

    // đăng kí tài khoản
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        // kiểm tra email đã tồn tại hay chưa ?
        if (userService.existsByEmail(userDTO.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Email is already !"));
        }
        // kiểm tra password và chckpass có khớp nhau ko ?
        if (userDTO.getPassword().equals(userDTO.getCheckPass()) == false) {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: You password and checkpass not same! Please chekcout it! !"));
        }
        User user = userService.addUser(userDTO);
        return ResponseEntity.ok(user);
    }

    // gửi yêu cầu reset pw
    @PostMapping("/reset-password-request")
    public String resetPassword(@RequestBody PasswordResetRequest passwordResetRequest,
                                HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        User user = userService.findByEmail(passwordResetRequest.getEmail());
        String passwordResetURL = "";
        if (user != null) {
            // tạo mã token
            String passwordResetToken = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, passwordResetToken);
            passwordResetURL = passwordResetEmailLink(user, applicationUrl(request), passwordResetToken);
        }
        return passwordResetURL;
    }

    private String passwordResetEmailLink(User user, String applicationUrl, String passwordResetToken) throws MessagingException, UnsupportedEncodingException {
        String url = applicationUrl + "/reset-password?token=" + passwordResetToken;
        // gửi url qua mail
        mailService.sendPasswordResetVerificationEmail(url, user.getEmail());
        log.info("Click the link to reset your password :  {}", url);
        return url;

    }
    public String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath();
    }

    // reset pw
    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody PasswordResetRequest passwordResetRequest,
                                @RequestParam("token") String passwordResetToken) {
        // kiểm tra thoeif gian tồn tại của link token
        String tokenVerificationResult = userService.validatePasswordResetToken(passwordResetToken);
        if (!tokenVerificationResult.equalsIgnoreCase("valid")) {
            return "Invalid token password reset token";
        }
        User user = userService.findUserByPasswordToken(passwordResetToken);
        if (user != null) {
            // kiểm tra newPw và cfPw có trùng nhau ko ?
            if (passwordResetRequest.getNewPassword().equals(passwordResetRequest.getConfirmPassword()) == true){
                userService.resetUserPassword(user, passwordResetRequest.getNewPassword());
                return "Password has been reset successfully";
            }
        }
        return "Invalid password reset token";
    }

}
