package ch05.exercise.pr15;

import java.util.HashMap;

public class Pr15 {

    public static int contains_v1(String base, String s){
        if (base.length() < s.length())
            return -1;
        int i = 0 , baseHash = 0;
        int sHash = s.hashCode();
        while (i < s.length()){
            baseHash = 31 * baseHash + base.charAt(i);
            i++;
        }
        for (; i < base.length(); i++) {
            if (baseHash == sHash){
                if (checkEquals(s,base,i - 1))
                    return i - s.length();
            }
            baseHash = baseHash - (int) (Math.pow(31,s.length()-1)) * base.charAt(i - s.length());
            baseHash = 31 * baseHash + base.charAt(i);
        }
        if (baseHash == sHash){
            if (checkEquals(s,base,i - 1))
                return i - s.length();
        }
        return -1;
    }

    private static boolean checkEquals(String target, String dist, int end){
        int i = target.length() - 1;
        boolean flag = true;
        while (i >= 0){
            if (target.charAt(i--) != dist.charAt(end--)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
