package LeetCode.Array;

//https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/05-arrays.md
public class ArrayBasics {
    public static void main(String[] args) {
    }
    
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
    
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
    
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans[i] = sum;
        }
        return ans;
    }
    
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += account[j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        if (n == 0 || n == 1) {
            return nums;
        }
        int[] res = new int[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                res[i] = nums[j++];
            }
            else {
                res[i] = nums[n++];
            }
        }
        return res;
    }
    
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            double temp = Math.log10(num);
            int val = (int) temp + 1;
            if ((val % 2) == 0) {
                ans++;
            }
        }
        return ans;
    }
    
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
    
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int size = mat.length - 1;
        for (int i = 0; i <= size; i++)
            sum += mat[i][i] + mat[i][size - i];
        return (size + 1) % 2 == 0 ? sum : sum - mat[size / 2][size / 2];
    }
}

    

