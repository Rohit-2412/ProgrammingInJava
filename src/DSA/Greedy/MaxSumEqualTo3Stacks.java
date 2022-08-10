// 10-08-2022 19:21 August
/*
Find maximum equal sum of every three stacks

Difficulty Level : Easy
Last Updated : 06 Jul, 2022
Given three stacks of the positive numbers, the task is to find the possible equal maximum sum of the stacks with the
 removal of top elements allowed. Stacks are represented as an array, and the first index of the array represent the
 top element of the stack.

Examples:


Input : stack1[] = { 3, 10}
  stack2[] = { 4, 5 }
  stack3[] = { 2, 1 }
Output : 0
Sum can only be equal after removing all elements
from all stacks.

 */

package DSA.Greedy;

public class MaxSumEqualTo3Stacks {
    public static void main(String[] args) {
        int[] stack1 = {3, 2, 1, 1, 1};
        int[] stack2 = {4, 3, 2};
        int[] stack3 = {1, 1, 4, 1};
        System.out.println(maxSum(stack1, stack2, stack3));
    }
    
    static int maxSum(int[] a, int[] b, int[] c) {
        int sumA = 0;
        int sumB = 0;
        int sumC = 0;
        
        for (int i : a) sumA += i;
        for (int i : b) sumB += i;
        for (int i : c) sumC += i;
        
        int top1 = 0, top2 = 0, top3 = 0;
        int ans = 0;
        
        while (true) {
            
            if (top1 == a.length || top2 == b.length || top3 == c.length) {
                return 0;
            }
            if (sumA == sumB && sumB == sumC) {
                return sumA;
            }
            
            if (sumA >= sumB && sumA >= sumC) {
                sumA -= a[top1++];
            }
            else if (sumB >= sumA && sumB >= sumC) {
                sumB -= b[top2++];
            }
            else {
                sumC -= c[top3++];
            }
        }
        
    }
}
