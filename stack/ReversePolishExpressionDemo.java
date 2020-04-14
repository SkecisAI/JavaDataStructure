package indi.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReversePolishExpressionDemo {
    public static void main(String[] args) {
        // (3+4)*5-6     --->  3 4 + 5 * 6 -           ---> 29
        // 4*5-8+60+8/2  --->  4 5 * 8 - 60 + 8 2 / +  ---> 76
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> resList = getStringList(suffixExpression);
        System.out.println("list is:"+resList);
        System.out.println(calculate(resList));
    }

    public static List<String> getStringList(String se){
        String[] splitString = se.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, splitString);
        return list;
    }

    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String s:list) {
            if (s.matches("\\d+")){
                stack.push(s);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                switch (s) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("wrong expression.");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
