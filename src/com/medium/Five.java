package com.medium;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Five {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start =0 ,end = 0;
        int max = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i = 0 ; i< n;i++) //i指向终点
        {
            int j = i;//j指向起点
            while (j>=0)
            {
                if(s.charAt(i)==s.charAt(j)&&(i-j<2||dp[i-1][j+1]))//若ij相连 判断s中ij是否相等
                    // 若不相连 如果ij相等 只需要ij内部也是一个回文数
                {
                    dp[i][j] = true;
                    if(i-j+1>max)
                    {
                        max = i-j+1;
                        start = j;
                        end = i;
                    }
                }
                j--;
            }
        }
        String result = s.substring(start,end+1);
        return result;

    }
    public static void main(String[] args)
    {
        Five f = new Five();
        System.out.println(f.longestPalindrome("detartrated"));
    }
}
