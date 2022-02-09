// https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?
// https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/submissions/
// LeetCode和NowCoder代码的实现是一样的，所以就不过多的复制了

//方法1 定义Map
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map <Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int count = map.get(array[i]);
                count++;
                map.put(array[i], count);// 找到了，次数+1
            }else {
                map.put(array[i], 1);// 找不到并记录次数为1
            }
            if (map.get(array[i]) > array.length / 2) { // 验证次数
                return array[i];
            }
        }
        return 0;
    }
}


//方法二：排序
import java.util.Map;

class Solution {
    public int majorityElement(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);// 首先排序数组然后找次数
        int target = array[array.length / 2];
        int count = 0;// 计数器
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return target;
        }
        return 0;
    }
}