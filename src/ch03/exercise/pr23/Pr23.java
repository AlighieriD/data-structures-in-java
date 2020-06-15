package ch03.exercise.pr23;

import java.util.*;

public class Pr23 {

    //优先级表
    public static Map<String,Integer> map = new HashMap(){
        {
            put("+",1);
            put("-",1);
            put("*",2);
            put("/",2);
            put("^",3);
            put("(",4);
            put(")",4);
        }
    };
    public static String[] inToPostFix(String[] inFix) {
        String[] postFix = new String[inFix.length];
        int idx = 0;
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < inFix.length; i++) {
            String s = inFix[i];
            if ("+".equals(s) ||"-".equals(s) ||"*".equals(s) ||"/".equals(s) ||"^".equals(s) ||"(".equals(s) ||")".equals(s)){
                while (stack.size() != 0 && map.get(s) <= map.get(stack.peek())){
                    if ("(".equals(stack.peek()) && !")".equals(s))
                        break;
                    String pop = stack.pop();
                    if (!"(".equals(pop))
                        postFix[idx++] = pop;
                }
                if (!")".equals(s))
                    stack.push(s);
            }else {
                postFix[idx++] = s;
            }
        }
        while (stack.size() != 0){
            postFix[idx++] = stack.pop();
        }
        return postFix;
    }

    public static void main(String[] args) {
        String[] arr = {"a","+","b","*","c","+","(","d","*","e","+","f",")","*","g"};
        String[] res = inToPostFix(arr);
        System.out.println(Arrays.toString(res));
    }
}
