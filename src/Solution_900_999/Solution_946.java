package Solution_900_999;

import java.util.Stack;

public class Solution_946 {

    public static void main(String[] args) {
        Solution_946 test = new Solution_946();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 3, 5, 1, 2};
        System.out.println(test.validateStackSequences(pushed, poped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int lenth = pushed.length;
        if (lenth == 0) return true;
        stack.push(pushed[0]);
        for (int i = 1, j = 0; i <= lenth; i++) {
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop(); j++;
            }
            if (i == lenth) {
                return stack.isEmpty();
            }
            stack.push(pushed[i]);
        }
        return false;
    }
}
