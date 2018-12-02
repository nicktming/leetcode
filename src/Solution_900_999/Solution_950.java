package Solution_900_999;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(deck);
        deque.addLast(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            deque.addFirst(deque.pollLast());
            deque.addFirst(deck[i]);
        }
        for (int i = 0; i < deck.length; i ++) {
            deck[i] = deque.pollFirst();
        }
        return deck;
    }
}
