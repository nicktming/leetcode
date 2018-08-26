package Solution_800_899;

import java.util.Stack;

public class Solution_856 {

    public static void main(String[] args) {
        String S = "()()(()(()))";
        Solution_856 test = new Solution_856();
        System.out.println(test.scoreOfParentheses(S));
    }

    // best Solution from discussion, using array to replace stack. more concise
    // time : 4ms  beats 99.91%
    public int scoreOfParentheses(String S) {
        int[] stack = new int[30];
        int depth = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack[++depth] = 0;
            } else {
                stack[depth - 1] += Math.max(2*stack[depth--], 1);
            }
        }
        return stack[0];
    }


    // best Solution from discussion, using array to replace stack.
    // time : 5ms beat:61.18%
    public int scoreOfParentheses3(String S) {
        int[] stack = new int[30];
        int depth = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack[++depth] = 0;
            } else {
                if (i != 0 && S.charAt(i - 1) == '(') {
                    stack[depth - 1] +=  stack[depth] + 1;
                } else {
                    stack[depth - 1] +=  2 * stack[depth];
                }
                depth--;
            }
        }
        return stack[0];
    }

    // my solution-1
    // time:5ms beat:61.18%
    public int scoreOfParentheses1(String S) {
        Stack<Integer> score = new Stack<>();
        score.push(0);
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                score.push(0);
            } else {
                if (i != 0 && S.charAt(i - 1) == '(') {
                    score.push(score.pop() + score.pop() + 1);
                } else {
                    score.push(2 * score.pop() + score.pop());
                }
            }
        }
        return score.pop();
    }

    // my solution-2
    // time:6ms beat:61.18%
    public int scoreOfParentheses2(String S) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> score = new Stack<>();
        score.push(0);
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(i);
                score.push(0);
            } else {
                int index = stack.pop();
                if (index == i - 1) {
                    score.push(score.pop() + score.pop() + 1);
                } else {
                    score.push(2 * score.pop() + score.pop());
                }
            }
        }
        return score.pop();
    }
}
