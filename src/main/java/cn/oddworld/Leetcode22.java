package cn.oddworld;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Leetcode22 {

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        List<String> strings = leetcode22.generateParenthesis(2);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();
        gen(new char[n * 2], 0, result);

        return result;
    }



    public void gen(char[] currentChar, int position, List<String> result){

        if(position == currentChar.length){
            if(valid(currentChar)){
                result.add(String.valueOf(currentChar));
            }
            return;
        }
        currentChar[position] = '(';
        gen(currentChar, position+1, result);
        currentChar[position] = ')';
        gen(currentChar, position+1, result);
    }

    public boolean valid(char[] currentChar){

        int left = 0;
        int right = 0;
        for(int i = 0; i< currentChar.length;i++){
            if(currentChar[i] == '('){
                left++;
            }else {
                right++;
            }
            if(left < right){
                return false;
            }
        }
        return left == right;
    }

}
