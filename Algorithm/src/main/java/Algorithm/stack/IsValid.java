package Algorithm.stack;

import java.util.Stack;

/**
 * @ClassName : IsValid
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-16 9:16
 * @Version : 1.0
 */
public class IsValid {
    public static boolean solution(String s) {
        char[] brackets = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        for (char bracket : brackets) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if (stack.size() != 0) {
                    char popChar = stack.pop();
                    boolean corresponding = (bracket == ')' && popChar == '(')
                            || (bracket == ']' && popChar == '[')
                            || (bracket == '}' && popChar == '{');
                    if (!corresponding) {
                        return false;
                    }
                } else {
                    return false;
                }


            }

        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s = "((";
        System.out.println(solution(s));
    }
}
