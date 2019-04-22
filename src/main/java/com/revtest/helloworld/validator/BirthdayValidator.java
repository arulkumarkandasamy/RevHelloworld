package com.revtest.helloworld.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class BirthdayValidator{
	public void validate(String dateOfBirth, Errors errors) {
		String pattern = "yyyy-MM-dd";
		DateFormat format = new SimpleDateFormat(pattern);
		format.setLenient(false);
		try {
            format.parse(dateOfBirth);
        } catch (ParseException e) {
        	errors.reject("Date " + dateOfBirth + " is not valid according to " +
                    ((SimpleDateFormat) format).toPattern() + " pattern.");
        }
    }
}
