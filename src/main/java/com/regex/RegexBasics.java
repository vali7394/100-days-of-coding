package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasics {

    public static void main(String[] args) {
        Pattern hairColorValidation = Pattern.compile("#?[0-9a-f]{6}");
        Matcher matcher = hairColorValidation.matcher("#12aeeb");
      //  System.out.println(matcher.find());
        System.out.println(matcher.matches());
    }
}
