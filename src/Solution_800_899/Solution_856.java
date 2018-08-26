package Solution_800_899;

import java.util.Stack;

public class Solution_856 {

    public static void main(String[] args) {
        String S = "()()(()(()))";
        Solution_856 test = new Solution_856();
        System.out.println(test.scoreOfParentheses(S));
    }

    public int scoreOfParentheses(String S) {
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
