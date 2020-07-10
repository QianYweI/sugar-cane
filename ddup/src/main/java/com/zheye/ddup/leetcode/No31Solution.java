package com.zheye.ddup.leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 链接：https://leetcode-cn.com/problems/next-permutation
 */
public class No31Solution {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int k = len - 2;
        while (k > 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        if (k < 0) return;
        int p = len - 1;
        while (p > k && nums[p] <= nums[k]) {
            p--;
        }
        if (p == k) {
            Arrays.sort(nums);
        } else {
            int t = nums[k];
            nums[k++] = nums[p];
            nums[p] = t;
            int i = 0;
            while (k < len - 1 - i) {
                int x = nums[k];
                nums[k] = nums[len - 1 - i];
                nums[len - 1 - i] = x;
                k++;
                i++;
            }
        }

    }

    public static void main(String[] args) {
        No31Solution solution = new No31Solution();
        solution.nextPermutation(new int[]{});
        solution.nextPermutation(new int[]{1});
        solution.nextPermutation(new int[]{2, 2, 2, 2, 2});
        solution.nextPermutation(new int[]{5, 4, 3, 2, 1});
        solution.nextPermutation(new int[]{1, 2, 4, 5, 3});
    }

}
