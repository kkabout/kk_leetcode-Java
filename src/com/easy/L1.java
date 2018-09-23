package com.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class L1 {

    /**
     * 思路：使用hashmap
     * 添加时先判断target-num[i]是否已经存在与hashmap中
     * 若存在 直接返回数组
     * 不存在 将元素添加到hashmap中 key为num[i] 值为i
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0 ; i<nums.length;i++)
        {
            int other = target-nums[i];
            if(map.containsKey(other))
                return new int[] {map.get(other),i};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
