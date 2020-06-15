package ch03.exercise.pr22;

import java.util.Deque;
import java.util.LinkedList;

public class Pr22 {

    public static double postfix(String[] args){
        Deque<Double> stack = new LinkedList<>();
        double d1 = 0;
        double d2 = 0;
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (s.equals("+")){
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d1 + d2);
            }else if (s.equals("-")) {
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d2 - d1);
            } else if (s.equals("*")) {
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d2 * d1);
            } else if (s.equals("/")) {
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d2 / d1);
            } else if (s.equals("^")){
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(Math.pow(d2,d1));
            } else {
                Double v = Double.valueOf(args[i]);
                stack.push(v);
            }
        }
        return stack.pop();
    }

}
