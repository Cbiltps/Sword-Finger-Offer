// LeetCode链接：  https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/submissions/
// NowCoder链接：  https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?
// 直接是把代码贴到了下面！

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
                break;//到这里直接跳出循环
            }

            //特殊情况 线性判断
            /*但是，因为题目说的是非递减，也就意味着数据允许重复，因为有重复发，就可能会有a[left] == a[mid] == a[right]的情况，我们就无法判定数据在mid左侧还是右侧。（注意，只要有两者不相等，我们就能判定应该如何缩小范围）*/
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
        return numbers[mid];//返回的值就是最小的值
    }
}

//下面的代码也是可以的就是所谓的暴力版本，但是没有实际的价值！
import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return 0;
        }
        
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers[i+1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}