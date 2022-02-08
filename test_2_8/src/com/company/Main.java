package com.company;

import java.util.Arrays;

public class Main {

    public static int[] reOrderArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while(left < right) {
            while(left < right && ((array[left] & 1) == 1)) {
                left++;
            }
            while(left < right && ((array[right] & 1) != 1)) {
                right--;
            }
            if(left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return array;
    }



    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reOrderArray(array)));
    }
}
