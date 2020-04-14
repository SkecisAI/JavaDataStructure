package indi.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InfixToPostfixDemo {
    public static void main(String[] args) {
        // 1+((2+3)*4)-5 ===> 1 2 3 + 4 * + 5 -
        String infixExp = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        List<String> listString = getStringList(infixExp);
        ArrayList<String> resultString = convertToPostfix(listString);
        System.out.println("中缀表达式："+infixExp);
        System.out.print("后缀表达式：");
        for (String item: resultString){
            System.out.print(item+" ");
        }
    }

    public static List<String> getStringList(String se){
        String[] splitString = se.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, splitString);
        return list;
    }

    public static ArrayList<String> convertToPostfix(List<String> ls){
        Stack<String> symbolStack = new Stack<>();
        ArrayList<String> resultStack = new ArrayList<>();
        for (String item: ls){
            if (item.matches("\\d+")){
                resultStack.add(item);
            }else {
                if (item.equals("(")){
                    symbolStack.push(item);
                    continue;
                }
                if (item.equals(")")){
                    String s = symbolStack.pop();
                    while (!s.equals("(")){
                        resultStack.add(s);
                        s = symbolStack.pop();
                    }
                    continue;
                }
                if (symbolStack.isEmpty()){
                    symbolStack.push(item);
                    continue;
                }
                if (getPriority(item) <= getPriority(symbolStack.peek())){
                    String s = symbolStack.pop();
                    resultStack.add(s);
                }
                symbolStack.push(item);
            }
        }
        while (!symbolStack.isEmpty()){
            resultStack.add(symbolStack.pop());
        }
        return resultStack;
    }

    public static int getPriority(String s){
        if (s.equals("*") || s.equals("/")){
            return 2;
        }else if (s.equals("+") || s.equals("-")){
            return 1;
        }else {
            return -1;
        }
    }
}
