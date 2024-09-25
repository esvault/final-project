package org.example.utils;

public final class Validator {
    private Validator(){}
    public static boolean containsOnlyLetters(String s){
        if(s ==null || s.isEmpty() ||  !s.matches("([а-яёА-ЯЁ]{1,})|([a-zA-Z]{1,})")){
            return false;
        }
        return true;
    }
    public static boolean validateAge(int age){
        if (age<=0 || age>=100){
            return false;
        }
        return true;
    }
    public static boolean validateAge(String age){
        if(!age.matches("^(100|[1-9][0-9]?)$")){
            return false;
        }
        return true;
    }
    public static boolean validateSurname(String s){
        String regex = "(([A-Z]{1})([a-z]{1,50})|([А-ЯЁ]{1})([а-яё]{1,50}))-?(([A-Z]{1})([a-z]{1,50})|([А-ЯЁ]{1})([а-яё]{1,50}))?";
        if(s ==null || s.isEmpty() ||
                !s.matches(regex)){
            return false;
        }
        return true;
    }
    public static boolean validateVolume(int volume){
        if (volume<=0 ){
            return false;
        }
        return true;
    }
    public static boolean validateVolume(String volume){
        if(volume ==null || volume.isEmpty() ||  !volume.matches("(^[1-9]+[0-9]*$)")){
            return false;
        }
        var num = Integer.parseInt(volume);
        var result = validateVolume(num);
        return result;
    }
    public static boolean validateBoolean(String bool){
        if(bool ==null || bool.isEmpty()){
            return false;
        }
        bool = bool.toLowerCase();
        if(!bool.matches("^(?:yes|no|true|false)")){
            return false;
        }
        return true;
    }
}
