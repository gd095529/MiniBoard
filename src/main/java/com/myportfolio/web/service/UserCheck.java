package com.myportfolio.web.service;

import com.myportfolio.web.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserCheck implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        String email = user.getEmail();
        String password = user.getPassword();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","required");

        if(email==null || !email.contains("@")) {
            errors.rejectValue("email", "invalidLength", new String[]{"5","100"}, null);
        }

        if(password==null || password.length() <  4 || password.length() > 12) {
            errors.rejectValue("password", "invalidLength", new String[]{"4","12"}, null);
        }
    }
}
