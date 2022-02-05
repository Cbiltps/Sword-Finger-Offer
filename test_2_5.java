//https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/submissions/

class Solution {
    public int minArray(int[] numbers) {
       //为空或者长度为零直接返回0
        if(numbers == null || numbers.length == 0) {
            return 0;
        }

        int left = 0;
        int right = numbers.length - 1;//下标从零开始
        int mid = 0;

        while(numbers[left] >= numbers[right]) { //范围条件 可以不理解
            if(right - left == 1) { //相邻相减就是为1
                mid = right;
                break;
            }

            //特殊情况 线性判断
            if(numbers[left] == numbers[right] && numbers[left] == numbers[mid]) {
                int result = numbers[left];
                for(int i = left + 1; i < right; i++) { //left和right是相等的
                    if(result > numbers[i]) {
                        result = numbers[i];
                    }
                }
                return result;
            }

            mid = (left + right) >> 1;//求出中间值
            //mid值 >= left值 表示 目标值在右边
            if(numbers[mid] >= numbers[left]) {
                left = mid;//直接排除左边的
            }else { //相反
                right = mid;
            } 
        }
        return numbers[mid];
    }
}