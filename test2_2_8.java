//https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?
//NowCoder(相对位置不变)
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int k = 0;
        for(int i = 0; i < array.length; i++) {
            if((array[i] & 1) == 1) { //判断为奇数
                int temp = array[i];//把奇数保存进tmp
                int j = i;
                while(j > k) {
                    array[j] = array[j - 1];//把偶数序列往后移动
                    j--;
                }
                array[k++] = temp;//把奇数插进去
            }
        }
    }
}


//https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
//LeetCode(相对位置该不该都行)
class Solution {
    public int[] exchange(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & 1) == 1) {
                int temp = nums[i];
                int j = i;
                while(j > k) {
                    nums[j] = nums[j -1];
                    j--;
                }
                nums[k++] = temp;
            }
        }
        return nums;
    }
}