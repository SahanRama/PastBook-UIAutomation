package com.pastbook.qa.ui.functions.utils;

import java.util.Random;

public class Utils {
    private Utils(){}

    public static String generateEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
         String email = "Johnie"+ randomInt +"@mailinator.com";
         return email;
    }


}
