import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 左边的类型的括号 直接 push 进去这个数据
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }

                if (c == '{' && topChar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
