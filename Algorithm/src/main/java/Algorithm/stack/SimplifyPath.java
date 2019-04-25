package Algorithm.stack;

import java.util.Stack;

/**
 * @ClassName : SimplifyPath
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-17 10:44
 * @Version : 1.0
 */
public class SimplifyPath {
    public static String solution(String path) {
        String[] paths=path.split("/");
        Stack<String> stack=new Stack<>();

        for (String s:paths)
        {
            if(s.equals(".")||s.equals(""))continue;
            if(s.equals(".."))
            {
                if(!stack.isEmpty())stack.pop();
            }
            else
            {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty())
        {
            res=stack.pop()+res;
            res="/"+res;
        }
        return res.length()==0?"/":res;


    }

    public String simplifyPath(String path) {
        int i = path.length() - 1, count = 0;
        StringBuilder builder = new StringBuilder(i);
        while (i > 0) {
            int j = path.lastIndexOf('/', i);
            if (i == j) i--;
            else {
                String x = path.substring(j + 1, i + 1);
                i = j - 1;
                if (".".equals(x)) ;
                else if ("..".equals(x)) count++;
                else if (count > 0) count--;
                else builder.insert(0, "/" + x);
            }
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }

    public static void main(String[] args) {
        String s = "/.";
        System.out.println(solution(s));
    }
}
