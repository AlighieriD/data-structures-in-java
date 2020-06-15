package ch03.exercise.pr23;

import java.util.*;

public class Pr23 {

    public static Map<String,Integer> map = new HashMap(){
        {
            put("+",1);
            put("-",1);
            put("*",2);
            put("/",2);
            put("^",3);
            put("(",4);
            put(")",1);
        }
    };

    public static String[] inToPostFix(String[] inFix) {
        String[] postFix = new String[inFix.length];
        int idx = 0;
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < inFix.length; i++) {
            String s = inFix[i];
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "^".equals(s) || "(".equals(s)){
                while (stack.size() > 0 && map.get(s) <= map.get(stack.peek())){
                    if ("(".equals(stack.peek()))
                        break;
                    postFix[idx++] = stack.pop();
                }
                if (!")".equals(s))
                    stack.push(s);
            }else if (")".equals(s)){
                while (stack.size() > 0 && !"(".equals(stack.peek())){
                    postFix[idx++] = stack.pop();
                }
                stack.pop();
            }else {
                postFix[idx++] = s;
            }
        }
        while (stack.size() != 0)
            postFix[idx++] = stack.pop();
        return postFix;
    }

    public static String[] postToInFix(String[] postFix){
        String[] inFix = new String[postFix.length];
        return null;
    }

    public static void main(String[] args) {
//        String[] arr = {"a","^","b","^","2"};
        String[] arr = {"a","+","b","*","c","+","(","d","*","e","+","f",")","*","g"};
        String[] res = inToPostFix(arr);
        System.out.println(Arrays.toString(res));
    }
}
