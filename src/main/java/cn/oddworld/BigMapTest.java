package cn.oddworld;

public class BigMapTest {

    public static void main(String[] args) {
        int[] num = {1,6,3,4,2};

        int[] bitMap = new int[1+6/32];

        for(int i = 0; i< num.length;i++){
           int index = num[i] >>> 32;
           int data = (1 << 32 - 1) & num[i];
           bitMap[index] = (bitMap[index] | (1 <<  data));
        }

        System.out.println(bitMap[0]);
    }
}
