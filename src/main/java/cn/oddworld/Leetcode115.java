package cn.oddworld;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 * 1 1 2 2 3 3 3
 * -1 1 1 1 1 3 3
 * -1 -1 -1 1 1 1
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 */
public class Leetcode115 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(numDistinct("rabbbit", "rabbit"));

    }

    public static int numDistinct(String s ,  String t){

        if(s == null || t == null || "".equals(s) || "".equals(t) || t.length() > s.length()){
            return 0;
        }
        if(s.equals(t)){
            return 1;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int tlent = tChar.length;
        int slent = sChar.length;
        int[] dit = new int[slent];
        for(int i = 0; i < tlent; i++){
            int pre = 0;
            for (int j = 0; j < slent; j++){
                if(i == 0){
                    if(dit[j] == 0 && sChar[j] == tChar[i]){
                        dit[j] = 1;
                    }
                }else {
                    if(dit[j] == -1){
                        continue;
                    }
                    if(dit[j] > 0 && sChar[j] == tChar[i] && pre == 0){
                        pre = pre + dit[j];
                        dit[j] = -1;
                        continue;
                    }

                    if(dit[j] > 0 && sChar[j] == tChar[i] && pre > 0){
                        int oldDit = dit[j];
                        dit[j] = pre;
                        pre = pre + oldDit;
                        continue;
                    }

                    if(dit[j] > 0){
                        pre = pre + dit[j];
                        dit[j] = -1;
                    }
                    if(dit[j] == 0 && sChar[j] == tChar[i]){
                        dit[j] = pre;
                    }
                }
            }
        }

        int num = 0;
        for(int i = 0; i< slent; i++){
            if(dit[i] > 0){
                num = num+dit[i];
            }
        }

        return num;
    }

    /**
     * 右边至多一个字符的场景
     * abc    a
     */
    public int num1(String s ,  String t){

        if(s == null || t == null || "".equals(s) || "".equals(t)){
            return 0;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int num = 0;
        for(int i = 0; i < sChar.length; i++){
            for(int j = 0; j < tChar.length; j ++){
                if(sChar[i] == tChar[j]){
                    num ++;
                }
            }
        }
        return num;
    }


}
