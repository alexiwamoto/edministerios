package com.eministerios.www.business.util;

/**
 * Created by alexandre on 31/03/16.
 */
public class StringParser {


    public static String transformPhone(String string){
        StringBuilder phone = new StringBuilder();
        phone.append("(")
                .append(string.substring(0,2))
                .append(")")
                .append(string.substring(2,7))
                .append("-")
                .append(string.substring(7, 11));
        return phone.toString();
    }
}
