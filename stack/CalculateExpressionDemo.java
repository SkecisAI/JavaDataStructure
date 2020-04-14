package indi.stack;

public class CalculateExpressionDemo {
    public static void main(String[] args) {
        CalculateExpression ce = new CalculateExpression();
        String exp = "-30+2*6-20";
        System.out.println(ce.calculating(exp));
    }
}

class CalculateExpression{
    private static final DigitStack digitStack = new DigitStack(10);
    private static final SymbolStack symbolStack = new SymbolStack(10);

    public float calculating(String exp){
        boolean isNumber = false;
        int start = 0;
        int i = 0;
        while (true){
            char c = exp.charAt(i);
            if ('0' <= c && c <= '9'){
                if (!isNumber){
                    start = i;
                }
                isNumber = true;
            }else {
                if (i==0){
                    digitStack.push("0");
                    symbolStack.push(exp.substring(i, i+1));
                    i++;
                    continue;
                }
                isNumber = false;
                digitStack.push(exp.substring(start, i));
                symbolStack.push(exp.substring(i, i+1));
            }
            i++;
            if (i == exp.length()){
                digitStack.push(exp.substring(start));
                break;
            }
        }
        digitStack.traverse();
        symbolStack.traverse();
        while (!symbolStack.isEmpty()){
            String op = symbolStack.pop();
            operating(op);
        }
        return Float.parseFloat(digitStack.pop());
    }

    public static boolean greater(String newChar, String stackTop){
        int newPriority, topPriority;
        if (newChar.equals("*") || newChar.equals("/")){
            newPriority = 2;
        }else {
            newPriority = 1;
        }

        if (stackTop.equals("*") || stackTop.equals("/")){
            topPriority = 2;
        }else {
            topPriority = 1;
        }
        return newPriority > topPriority;
    }
    public static void operating(String op){
        String s2 = digitStack.pop();
        String s1 = digitStack.pop();
        float ans = 0;
        switch (op){
            case "+":
                ans = Float.parseFloat(s1) + Float.parseFloat(s2);
                break;
            case "-":
                ans = Float.parseFloat(s1) - Float.parseFloat(s2);
                break;
            case "*":
                ans = Float.parseFloat(s1) * Float.parseFloat(s2);
                break;
            case "/":
                try{
                    ans = Float.parseFloat(s1) / Float.parseFloat(s2);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        digitStack.push(String.valueOf(ans));
    }
}

class SimpleStack {
    private int top = -1;
    private final int MAX_SIZE;
    private final String[] STACK;

    public SimpleStack(int maxSize){
        this.MAX_SIZE = maxSize;
        this.STACK = new String[this.MAX_SIZE];
    }

    public boolean isFull(){
        return top == MAX_SIZE -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(String s){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        STACK[top] = s;
    }

    public String pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        String returnValue = STACK[top];
        top--;
        return returnValue;
    }

    public void traverse(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("[%d]: %s\n", i, STACK[i]);
        }
    }

    public String peek(){
        if (isEmpty()){
            throw new RuntimeException("栈空, 没有数据");
        }
        return STACK[top];
    }
}

class DigitStack extends SimpleStack {

    public DigitStack(int maxSize) {
        super(maxSize);
    }

    @Override
    public void push(String s) {
        super.push(s);
    }

    @Override
    public String pop() {
        return super.pop();
    }

    @Override
    public void traverse() {
        System.out.println("数字栈：");
        super.traverse();
    }
}

class SymbolStack extends SimpleStack {

    public SymbolStack(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void push(String s) {
        if (super.isEmpty()){
            super.push(s);
            return;
        }
        if (!CalculateExpression.greater(s, super.peek())) {  // 优先级小于或等于之前的运算符
            String op = super.pop();
            CalculateExpression.operating(op);
        }
        super.push(s);
    }

    @Override
    public String pop() {
        return super.pop();
    }

    @Override
    public void traverse() {
        System.out.println("符号栈：");
        super.traverse();
    }
}