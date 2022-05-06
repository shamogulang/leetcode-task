package cn.oddworld;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Leetcode22AnotherSolve {

    public static void main(String[] args) {
        Leetcode22AnotherSolve leetcode22 = new Leetcode22AnotherSolve();
        List<String> strings = leetcode22.generateParenthesis(2);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();
        gen(new char[n * 2], 0,0, 0, result);

        return result;
    }



    public void gen(char[] currentChar, int position,int left, int right, List<String> result){

        if(right > left){
            return;
        }
        if(position == currentChar.length){
            if(right == left){
                result.add(String.valueOf(currentChar));
            }
            return;
        }
        currentChar[position] = '(';
        gen(currentChar, position+1,left+1, right, result);
        currentChar[position] = ')';
        gen(currentChar, position+1,left, right+1, result);
    }
}
