// NowCoder：https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?
// 迭代的版本
public class Solution {
    public int Fibonacci(int n) {
        if (0 == n) {
            return 0;
        }
        //下面的if语句是可以省略的，前提是third定义的时候要赋值为1，到后面的返回的时候不管是第一次还是第二次都返回1
        if (2 == n || 1 == n) {
            return 1;
        }
        
        int first = 1;
        int second = 1;
        int third = 0;// 第三个数初始化为0
        
        // 这里要理解，从第三个数要迭代一次，以此类推条件就出来了
        while (n > 2) {
            third = first + second;
            first = second;
            second = third;
            n--;
        }
        return third;
    }
}

//依旧是迭代，但是LeetCode和NowCoder题目是不一样的！
public class Solution {
    public int fib(int n) {
        if (0 == n) {
            return 0;
        }
        //下面的if语句是可以省略的，前提是third定义的时候要赋值为1，到后面的返回的时候不管是第一次还是第二次都返回1
        if (2 == n || 1 == n) {
            return 1;
        }
        
        int first = 1;
        int second = 1;
        int third = 0;// 第三个数初始化为0
        
        // 这里要理解，从第三个数要迭代一次，以此类推条件就出来了
        while (n > 2) {
            third = first + second;
            //求余比较耗时，可以采用减去1000000007
            if (third >= 1000000007) {
                third -= 1000000007;
            }
            first = second;
            second = third;
            n--;
        }
        return third;
    }
}




//这个是递归的代码，建议面试的时候不要写
class Solution {
    public int Fibonacci(int n) {
        if (0 == n) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }
}



//NowCoder
//递归加不重复计算的实现
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> filter = new HashMap<>();
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        int ppre = 0;// 第n-2个
        if (filter.containsKey(n - 2)) { // 找到了
            ppre = filter.get(n - 2);
        }else { // 没有找到就自己计算出来然后添加进去
            ppre = Fibonacci(n - 2);
            filter.put(n-2, ppre);
        }
        
        int pre = 0;// 第n-1个
        if (filter.containsKey(n - 1)) { // 找到了
            pre = filter.get(n - 1);
        }else { // 没有找到就自己计算出来然后添加进去
            pre = Fibonacci(n - 1);
            filter.put(n-1, pre);
        }
        return ppre + pre;
    }
}

//LeetCode
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> filter = new HashMap<>();
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        int ppre = 0;// 第n-2个
        if (filter.containsKey(n - 2)) { // 找到了
            ppre = filter.get(n - 2);
        }else { // 没有找到就自己计算出来然后添加进去
            ppre = fib(n - 2);
            filter.put(n-2, ppre);
        }
        
        int pre = 0;// 第n-1个
        if (filter.containsKey(n - 1)) { // 找到了
            pre = filter.get(n - 1);
        }else { // 没有找到就自己计算出来然后添加进去
            pre = fib(n - 1);
            filter.put(n-1, pre);
        }
        
        int result = ppre + pre;
        if (result >= 1000000007) {
            result -= 1000000007;
        }
        return result;
    }
}