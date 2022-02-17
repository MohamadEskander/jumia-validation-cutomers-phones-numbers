package com.example.jumiatask.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpression {

    public static boolean validate(String regExr, String s) {
        Pattern REGEX = Pattern.compile(regExr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = REGEX.matcher(s);
        return matcher.find();
    }
}