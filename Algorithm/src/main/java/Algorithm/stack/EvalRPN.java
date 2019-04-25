package Algorithm.stack;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName : EvalRPN
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-25 9:06
 * @Version : 1.0
 */
public class EvalRPN {
    public static int solution(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            /*if (isNumeric(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                int number_second = Integer.parseInt(stack.pop());
                int number_first= Integer.parseInt(stack.pop());
                int result = calculate(number_first,number_second,tokens[i]);
                stack.push(String.valueOf(result));

            }*/
            if (isOperater(tokens[i])){
                int number_second = Integer.parseInt(stack.pop());
                int number_first= Integer.parseInt(stack.pop());
                int result = calculate(number_first,number_second,tokens[i]);
                stack.push(String.valueOf(result));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private static boolean isOperater(String string) {
        return string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/");
    }

    private static boolean isNumeric(String string){
        Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
        Matcher isNum = pattern.matcher(string);
        return isNum.matches();
    }

    private static int calculate(int a, int b, String operater) {
        switch (operater) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
            default: return 0;
        }
    }


    private int N =-1;
    public int evalRPN(String[] tokens) {

        if(N==-1)
            N=tokens.length-1;
        String s = tokens[N--];
        char c = s.charAt(0);
        if(s.length()==1&&"+-*/".indexOf(c)!=-1){
            int a = evalRPN(tokens);
            int b = evalRPN(tokens);
            switch(c){
                case '+':return a+b;
                case '-':return b-a;
                case '*':return a*b;
                case '/':return b/a;
                default:break;
            }
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String[] strings = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution(strings));
    }
}
