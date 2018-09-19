package com.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class fifteen {
    //解决思路 先排序 固定一个数a[i] 在剩下的数中寻找两数相加的和为a[i]的相反数
    //解决重复问题 当a[i]=a[i]+1 再往后搜索回搜索出相同的结果 直接下一次循环
    //k j的去重思路和上面一样
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length;i++)
        {
            if(nums[i]>0) //排序后的数组 如果i是整数 j k 一定为正数 不可能出现题中情况
                break;
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j = nums.length-1;
            int target = 0-nums[i];
            int k = i+1;
            while (k<j)
            {

                if(nums[k]+nums[j]==target)
                {
                    List<Integer> item = Arrays.asList(nums[i],nums[k],nums[j]);
                    result.add(item);
                    while (k<j&&nums[k]==nums[k+1])
                        k++;
                    while (k<j&&nums[j]==nums[j-1])
                        j--;
                    k++;
                    j--;
                }
                else if(nums[k]+nums[j]<target)
                    k++;
                else
                    j--;


            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int a[] = {1,-1,-1,0};
        List<List<Integer>> list = threeSum(a);
        System.out.println(list.toString());
    }






}
