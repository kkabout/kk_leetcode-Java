package com.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class fiftythree {
//    public int maxSubArray(int[] nums) {
//        int maxsum=Integer.MIN_VALUE;
//        for(int i = 0  ; i<nums.length;i++){
//            int thissum=0;
//            for(int j = i ; j<nums.length;j++)
//            {
//                thissum+=nums[j];
//                maxsum=maxsum>thissum?maxsum:thissum;
//            }
//
//        }
//        return maxsum;
//
//    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, thisSum = 0;
        for (int i = 0; i < nums.length; i++) {
            thisSum += nums[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }
    public static void main(String[] args)
    {
        fiftythree f = new fiftythree();
        int a[] = {-2,1};
        System.out.println(f.maxSubArray(a));
    }
}