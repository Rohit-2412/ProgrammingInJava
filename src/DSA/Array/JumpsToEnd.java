package DSA.Array;

public class JumpsToEnd {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 5, 8, 4, 5, 7, 8, 9, 10, 9 };
    System.out.println(minJumps(arr));
  }

  public static int minJumps(int[] arr) {
    /*
        // using Dynamic Programming
        ArrayList<Integer> dp = new ArrayList<>(arr.length);
        dp.add(0, 0);
        for (int i = 1; i < arr.length; i++) {
            dp.add(i, (int) 1e5);
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= (j + arr[j])) {
                    dp.set(i, Math.min(dp.get(i),
                            (dp.get(j) + 1)));
                }
            }
        }
        return dp.get(arr.length - 1);
    */

    // using greedy approach

    int jump = 0;
    int currStart = 1, currEnd = arr[0];
    int currMaxReach = arr[0];
    int n = arr.length;
    while (currMaxReach < n - 1) {
      currMaxReach = Math.max(currStart + arr[currStart], currMaxReach);
      if (currMaxReach >= n - 1) {
        jump++;
        break;
      }
      if (currStart == currEnd) {
        jump++;
        currEnd = currMaxReach;
      }
      currStart++;
    }
    return jump;
  }
}
