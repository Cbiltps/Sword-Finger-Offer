//LeetCode链接：
//https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
//测试用例全部通过！

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //如果为空或者长度为0，直接返回false
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int i = 0;//列下标
        int j = matrix[0].length - 1;//行下标，第一行的长度-1

        while (i < matrix.length && j >= 0) { //这个就是整个查找的范围
        //范围就是：

            if (target < matrix[i][j]) {
                j--;//排除列
            }else if (target > matrix[i][j]) {
                i++;//排除行
            } else {
                return true;
            }

        }
        return false;
    }
}



//NowCoder链接：https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?
//自己写的暴力求解，意义不大！
//测试用例全部通过！
public class Solution {
    public boolean Find(int target, int [][] array) {
        //数组为空或者长度为0直接返回false
        if (array == null || array.length == 0) {
            return false;
        }
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
