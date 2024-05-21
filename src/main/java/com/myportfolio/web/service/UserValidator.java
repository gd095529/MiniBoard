package com.myportfolio.web.service;

import com.myportfolio.web.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        String id = user.getUid();
        String pwd = user.getPwd();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"uid","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pwd","required");

        if(id==null || id.length() <  4 || id.length() > 12) {
            errors.rejectValue("uid", "invalidLength", new String[]{"4","12"}, null);
        }

        if(pwd==null || pwd.length() <  4 || pwd.length() > 12) {
            errors.rejectValue("pwd", "invalidLength", new String[]{"4","12"}, null);
        }


    }
}
