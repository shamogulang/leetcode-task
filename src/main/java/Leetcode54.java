import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {




    /**
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     *
     * Example 1:
     *
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     *
     *
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     * @param matrix
     * @return
     */

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> rsp = new ArrayList<>();

        int row = matrix.length;
        int column = matrix[0].length;
        int i =0;
        int j = 0;
        int doneRowLow =0;
        int doneColumnLeft = 0;

        boolean columnFlag = true;
        boolean columnRow = false;
        for (int n=0; n < row; ) {
            for (int m =0; m < column;) {

            }
        }
        while (i >= doneRowLow && i < row && j >= doneColumnLeft && j < column){

            rsp.add(matrix[i][j]);
            if(columnFlag && j < column){
                j++;
            }
            if(column == j){
                columnFlag = false;
                columnRow = true;
                doneRowLow += 1;
            }

            if(columnRow && i < row){
                i++;
            }
            if(i == row){
                column = column -1;
            }

        }


        return null;
    }
}
