package Solution_700_799;

public class Solution_709 {
    public String toLowerCase(String str) {
        StringBuffer sb  = new StringBuffer();
        int DIFF = 'A' - 'a';
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch - DIFF);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
