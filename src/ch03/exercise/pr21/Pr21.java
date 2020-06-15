package ch03.exercise.pr21;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YH on 2020/6/12.
 */
public class Pr21 {

    // a. Pascal( begin/end, (), [], {} )
    public static boolean pascalBalance(String s){
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)){
                stack.push('(');
            } else if ('[' == s.charAt(i)) {
                stack.push('[');
            } else if ('{' == s.charAt(i)) {
                stack.push('{');
            } else if (isMatch(s,i,"begin")){
                stack.push('B');
            } else if (')' == s.charAt(i)) {
                Character c = stack.pop();
                if (c != '(')
                    return false;
            } else if (']' == s.charAt(i)) {
                if (stack.size() <= 0)
                    return false;
                Character c = stack.pop();
                if (c != '[')
                    return false;
            } else if ('}' == s.charAt(i)) {
                if (stack.size() <= 0)
                    return false;
                Character c = stack.pop();
                if (c != '{')
                    return false;
            } else if (isMatch(s,i,"end")){
                if (stack.size() <= 0)
                    return false;
                Character c = stack.pop();
                if (c != 'B')
                    return false;
            }
        }
        return stack.size() == 0;
    }

    public static boolean isMatch(String s, int strat, String match){
        if (s.length() < strat+match.length())
            return false;
        for (int i = 0; i < match.length(); i++) {
            if (match.charAt(i) != s.charAt(strat+i))
                return false;
        }
        return true;
    }

    // b. Java( /* */, (), [], {} )
    public static boolean javaBalance(String s){
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch (c){
                case '(' :
                    stack.push(c);
                    break;
                case '[' :
                    stack.push(c);
                    break;
                case '{' :
                    stack.push(c);
                    break;
                case '/' :
                    if (isMatch(s,i,"/*"))
                        stack.push('/');
                    break;
                case ')' :
                    if (stack.size() == 0 || !('(' == stack.pop()))
                        return false;
                    break;
                case ']' :
                    if (stack.size() == 0 || !('[' == (stack.pop())))
                        return false;
                    break;
                case '}' :
                    if (stack.size() == 0 || !('{' == (stack.pop())))
                        return false;
                    break;
                case '*' :
                    if (isMatch(s,i,"*/"))
                        if (stack.size() == 0 || !('/' == (stack.pop())))
                            return false;
                    break;
                default:
                    break;
            }
        }
        return stack.size() == 0;
    }

}
