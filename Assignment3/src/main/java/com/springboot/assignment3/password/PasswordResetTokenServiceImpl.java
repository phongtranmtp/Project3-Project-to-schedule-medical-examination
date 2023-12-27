package com.springboot.assignment3.password;

import com.springboot.assignment3.dao.PasswordResetTokenRepository;
import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Optional;
@Service
@Transactional
public class  PasswordResetTokenServiceImpl implements PasswordResetTokenService{
    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public void createPasswordResetTokenForUser(User user, String passwordToken) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByUserId(user.getId());
        if (passwordResetToken == null){
            passwordResetToken = new PasswordResetToken(passwordToken,user);
        } else {
            passwordResetToken.setToken(passwordToken);
        }
        passwordResetTokenRepository.save(passwordResetToken);
    }

    // kiểm tra thoeif gian tồn tại của token
    public String validatePasswordResetToken(String theToken){
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(theToken);
        if (passwordResetToken == null){
            return "Invalid password reset token";
        }
        Calendar calendar = Calendar.getInstance();
        if ((passwordResetToken.getTokenExpirationTime().getTime() - calendar.getTime().getTime()) <= 0 ){
            return "Link already expired , resend link " ;

        }
        return "valid";
    }

    public Optional<User> findUserByPasswordToken(String passwordToken){
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(passwordToken).getUser());
    }

}
