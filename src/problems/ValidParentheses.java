package problems;

import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    String parenthesis = "[()()]{}";
    System.out.format("Validity of parentheses %s is: %s", parenthesis, isValid(parenthesis));
  }

  public static boolean isOpenBraces(Character ch) {
    return ch == '[' || ch == '(' || ch == '{';
  }
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();

    int sLen = s.length();

    if (sLen == 0) {
      return true;
    }

    for (char ch: s.toCharArray()) {
      if (isOpenBraces(ch)) {
        stack.push(ch);
      } else {
        if (stack.size() == 0) {
          return false;
        }

        char topElement = stack.peek();
        if (!isOpenBraces(topElement)) {
          return false;
        }

        if ((topElement == '(' && ch != ')') ||
                (topElement == '[' && ch != ']') ||
                (topElement == '{' && ch != '}')) {
          return false;
        } else {
          stack.pop();
        }
      }
    }

    return stack.size() == 0;
  }
}
