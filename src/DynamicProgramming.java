public class DynamicProgramming {
    public static int fibonacciSeries(int n, int[] dpArray) {
        if (n <= 1) {
            return n;
        }
        if (dpArray[n] != -1) {
            return dpArray[n];
        }
        return dpArray[n] = fibonacciSeries(n - 1, dpArray) + fibonacciSeries(n - 2, dpArray);
    }

    /**
     * Problem: Lucas numbers are the same as fibonacci but the first two numbers are 1 and 2
     *
     * @param n
     * @param dpArray
     * @return
     */
    public static int lucasNumbers(int n, int[] dpArray) {
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        if (dpArray[n] == -1) {
            return dpArray[n] = lucasNumbers(n - 1, dpArray) + lucasNumbers(n - 2, dpArray);
        }
        return dpArray[n];
    }

    public static int climbingStairs(int n, int[] arr) {
        if (n <= 1) {
            return 1;
        }
        if (arr[n] != -1) {
            return arr[n];
        }
        return arr[n] = climbingStairs(n - 1, arr) + climbingStairs(n - 2, arr);
    }

    /**
     * Question: Find the minimum energy required by a frog to reach the end when it can jump only one or
     * two steps at a time and the amount of energy spent on each step is the absolute difference
     * of the two indices of the energy array
     *
     * @param n
     * @param energy
     * @param dpArray
     * @return
     */
    public static int minFrogJumpingEnergy(int n, int[] energy, int[] dpArray) {
        if (n == 0) {
            return 0;
        }
        if (dpArray[n] == -1) {
            int left = minFrogJumpingEnergy(n - 1, energy, dpArray) + Math.abs(energy[n] - energy[n - 1]);
            if (n > 1) {
                int right = minFrogJumpingEnergy(n - 2, energy, dpArray) + Math.abs(energy[n] - energy[n - 2]);
                dpArray[n] = Math.min(left, right);
            } else {
                dpArray[n] = left;
            }
        }
        return dpArray[n];
    }

    public static int frogJumpK(int n, int k, int[] heights, int[] dpArray) {
        if (n == 0) return 0;

        if (dpArray[n] != -1) return dpArray[n];

        int minCost = Integer.MAX_VALUE;

        for (int j = 1; j <= k && n - j >= 0; j++) {
            int cost = frogJumpK(n - j, k, heights, dpArray) + Math.abs(heights[n] - heights[n - j]);
            minCost = Math.min(minCost, cost);
        }

        return dpArray[n] = minCost;  // Memoize and return
    }

    public static int maxSumOfNonAdjacentElements(int n, int[] nums, int[] dpArray) {
        if (n == 0) {
            return nums[n];
        }
        if (n < 0) {
            return 0;
        }
        if (dpArray[n] == -1) {
            int pick = nums[n] + nums[n - 2]; //Since we can't take adjacent elements directly go two steps back
            int notPick = nums[n - 1];//Not picking 0 is added
            dpArray[n] = Math.max(pick, notPick);
        }
        return dpArray[n];
    }
    //If we talk about not taking adjacents in a circle which means we don't want the first and the last
    //element together too, then make two arrays- one with the first element and without the last and
    //vice versa and call this function with both the arrays and result will be the max of those 

    /**
     * Problem: n day long training schedule of ninja and each day he can perform one of three activities but
     * cannot perform an activity he performed the previous day. Each activity has some merit points that
     * differ according to each day thus the points array is a 2D array. Calculate the maximum number of
     * points that the ninja can earn in n days.
     * <p>
     * This is different from the previous problem since there we couldn't take consecutive days so just
     * skipped the day but here we can't skip the day, we have to perform some activity.
     */
    public static int ninjaTraining(int day, int[][] points, int last, int[][] dpArray) {
        int maxPoints = 0;
        if (dpArray[day][last] != -1) {
            return dpArray[day][last];
        }
        if (day == 0) {
            for (int activity = 0; activity < 3; activity++) {
                if (activity != last) {
                    maxPoints = Math.max(maxPoints, points[0][activity]);
                }
            }
            return dpArray[0][last] = maxPoints;
        }

        for (int activity = 0; activity < 3; activity++) {
            if (activity != last) {
                int point = points[day][activity] + ninjaTraining(day - 1, points, activity, dpArray);
                maxPoints = Math.max(maxPoints, point);
            }
        }
        return dpArray[day][last] = maxPoints;
    }

    /**
     * Problem: We have been given a grid of m x n and we have to determine just how many paths we have
     * to reach the exact opposite point from (0,0)
     */
    public static int uniquePathsInGrid(int i, int j, int[][] dpArray) {
        if (i == 0 && j == 0) {
            return 1;//boundary-count that path
        }
        if (i < 0 || j < 0) {
            return 0;//outside boundary-don't count that path
        }
        if (dpArray[i][j] == -1) {
            int up = uniquePathsInGrid(i - 1, j, dpArray);
            int left = uniquePathsInGrid(i, j - 1, dpArray);
            dpArray[i][j] = up + left;
        }
        return dpArray[i][j];
    }

    public static int uniquePathsInGridWithADeadCell(int[][] grid, int i, int j, int[][] dpArray) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] == 0) {
            if (dpArray[i][j] == -1) {
                int up = uniquePathsInGridWithADeadCell(grid, i - 1, j, dpArray);
                int left = uniquePathsInGridWithADeadCell(grid, i, j - 1, dpArray);
                dpArray[i][j] = up + left;
            }
        }
        if (grid[i][j] == -1) {
            dpArray[i][j] = 0;
        }
        return dpArray[i][j];
    }

    public static int minimumPathSumOfGrid(int[][] grid, int i, int j, int[][] dpArray) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return 1000000; //So you never have to take this value
        }
        if (dpArray[i][j] == -1) {
            int up = grid[i][j] + minimumPathSumOfGrid(grid, i - 1, j, dpArray);
            int left = grid[i][j] + minimumPathSumOfGrid(grid, i, j - 1, dpArray);
            dpArray[i][j] = Math.min(up, left);
        }
        return dpArray[i][j];
    }

    /**
     * Problem: We have been given a 2d array in the shape of a triangle and we have to find the minimum
     * path sum but the twist is that we don't have a definite end point like we did before
     * ending up anywhere in the last row is counted as a path. Thus in this case we start from (0,0)
     * and then travel till we reach the last row.
     * Operations possible: Going down or diagonal
     *
     * @param n
     * @param i
     * @param j
     * @param triangle
     * @param dpArray
     * @return
     */

    public static int minimumPathSumInTriangleArray(int n, int i, int j, int[][] triangle, int[][] dpArray) {
        if (i == n - 1) {
            return triangle[n - 1][j];
        }
        //There is no case in which the boundary can be crossed unless its in the last row so only 1 base case
        //Two ways to go- down and diagonal
        if (dpArray[i][j] == -1) {
            int down = triangle[i][j] + minimumPathSumInTriangleArray(n, i + 1, j, triangle, dpArray);
            int diagonal = triangle[i][j] + minimumPathSumInTriangleArray(n, i + 1, j + 1, triangle, dpArray);
            dpArray[i][j] = Math.min(down, diagonal);
        }
        return dpArray[i][j];
    }

    /**
     * @param grid
     * @param n
     * @param m
     * @param i
     * @param j
     * @param dpArray
     * @return
     */
    public static int maxPathSumWithoutFixedStartOrEndPoints(int[][] grid, int n, int m, int i, int j, int[][] dpArray) {
        if (j < 0 || j >= m) {
            return -1;
        }
        if (i == 0) {
            return grid[i][j];
        }
        if (dpArray[i][j] == -1) {
            int up = grid[i][j] + maxPathSumWithoutFixedStartOrEndPoints(grid, n, m, i - 1, j, dpArray);
            int left = grid[i][j] + maxPathSumWithoutFixedStartOrEndPoints(grid, n, m, i - 1, j - 1, dpArray);
            int right = grid[i][j] + maxPathSumWithoutFixedStartOrEndPoints(grid, n, m, i - 1, j + 1, dpArray);
            dpArray[i][j] = Math.max(up, Math.max(left, right));
        }
        return dpArray[i][j];
    }

    public static int pickingChocolates3DGrid(int m, int n, int i, int j1, int j2, int[][] grid, int[][][] dpArray) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return -1;
        }
        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1]; //Count once
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dpArray[i][j1][j2] == -1) {
            for (int j1counter = -1; j1counter <= 1; j1counter++) {
                for (int j2counter = -1; j2counter <= 1; j2counter++) {
                    int value = 0;
                    if (j1 == j2) {
                        value = grid[i][j1];
                    } else {
                        value = grid[i][j1] + grid[i][j2];
                    }
                    value += pickingChocolates3DGrid(m, n, i + 1, j1 + j1counter, j2 + j2counter, grid, dpArray);
                    dpArray[i][j1][j2] = Math.max(dpArray[i][j1][j2], value);
                }
            }
        }
        return dpArray[i][j1][j2];
    }

    public static int minimumCostToReachTop(int n, int[] cost, int[] dpArray) {
        if (n == 0 || n == 1) {
            return cost[n];
        }
        if (dpArray[n] == -1) {
            int stepOne = cost[n] + minimumCostToReachTop(n - 1, cost, dpArray);
            int stepTwo = cost[n] + minimumCostToReachTop(n - 2, cost, dpArray);
            dpArray[n] = Math.min(stepOne, stepTwo);
        }
        return dpArray[n];
    }

    public static int maximiseLengthOfRods(int n, int x, int y, int z, int[] dpArray) {
        int minimum = Math.min(x, Math.min(y, z));
        if (n <= 0 || n < minimum) {
            return 0;
        }

        if (dpArray[n] == -1) {
            int cut_x = 1 + maximiseLengthOfRods(n - x, x, y, z, dpArray);
            int cut_y = 1 + maximiseLengthOfRods(n - y, x, y, z, dpArray);
            int cut_z = 1 + maximiseLengthOfRods(n - z, x, y, z, dpArray);
            dpArray[n] = Math.max(cut_x, (Math.max(cut_y, cut_z)));
        }
        return dpArray[n];
    }

    public static void validParentheses(int n, int open, int close, String resultStr) {
        if (open == n / 2) {
            if (open != close) {
                while (open != close) {
                    resultStr = resultStr + ')';
                    close++;
                }
            }
            System.out.println(resultStr);
        }
        if (open != n / 2) {
            validParentheses(n, open + 1, close, resultStr + '(');
        }
        if (open != close) {
            validParentheses(n, open, close + 1, resultStr + ')');
        }
    }

    public static int minPathSumInTriangle(int[][] triangle, int n, int i, int j, int[][] dpArray) {
        if (i == n) {
            return triangle[n][j];
        }
        if (dpArray[i][j] == -1) {
            int down = triangle[i][j] + minPathSumInTriangle(triangle, n, i + 1, j, dpArray);
            int right = triangle[i][j] + minPathSumInTriangle(triangle, n, i + 1, j + 1, dpArray);
            dpArray[i][j] = Math.min(down, right);
        }
        return dpArray[i][j];
    }

    public static int[] perfectSquareArrayTilln(int n) {
        int[] arr = new int[n / 2];
        for (int i = 1; i * i <= n; i++) {
            arr[i - 1] = i * i;
        }
        return arr;
    }

    /**
     *
     * @param n
     * @param dpArray
     * @return
     */
    public static int minPerfectSquareSum(int n, int[] dpArray) {
        if (n == 0) {
            return 0;
        }
        if(dpArray[n] == -1) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                int temp = minPerfectSquareSum(n - (i * i), dpArray);
                dpArray[n] = Math.min(min, temp) + 1;
            }
        }
        return dpArray[n];
    }

    public static int findingBinomialCoeff(int n, int k, int[][] dpArray){
        if(k == 0){
            return 1;
        }
        if(k == 1){
            return n;
        }
        if(k == n){
            return 1;
        }
        if(dpArray[n][k] == -1) {
            dpArray[n][k] = findingBinomialCoeff(n - 1, k - 1, dpArray) + findingBinomialCoeff(n - 1, k, dpArray);
        }
        return dpArray[n][k];
    }

    public static int pascalsTriangle(int n, int k, int[][]dpArray){
        if(k == 0 || n == k){
            return 1;
        }
        if(dpArray[n][k] == -1){
            dpArray[n][k] = pascalsTriangle(n-1, k-1, dpArray) + pascalsTriangle(n-1, k, dpArray);
        }
        return dpArray[n][k];
    }

    public static int houseRobber(int[]money, int n, int[]dpArray){
        if(n == 0 || n == 1){
            return money[n];
        }
        if(dpArray[n] == -1){
            int choose = money[n] + houseRobber(money, n-2, dpArray);
            int notChoose = money[n] + houseRobber(money, n-1, dpArray);
            dpArray[n] = Math.max(choose, notChoose);
        }
        return dpArray[n];
    }

//DP ON SUBSEQUENCES PROBLEMS
    //Every subsequence problem has two instances- pick it or don't pick it
    public static boolean subsetSumEqualToTarget(int[] arr, int index, int target, int[][]dpArray){
        if(target == 0){
            return true;
        }
        if(index == 0){
            if(target == arr[index]){
                return true;
            }
            else{
                return false;
            }
        }
            if(dpArray[index][target] == -1) {
                boolean notTake = subsetSumEqualToTarget(arr, index - 1, target, dpArray);
                boolean take = subsetSumEqualToTarget(arr, index - 1, target - arr[index], dpArray);
                dpArray[index][target] = take || notTake ? 1:0; //If its true make it one or false make it zero
            }
            if(dpArray[index][target] == 0){
                return false;
            }
            else return true;
    }

    public static int knapsackProblem(int index, int weight, int[]weights, int[] values, int[][]dpArray){
         if (weight == 0){
             return 0;
        }
         if(index == 0) {
             if (weights[0] <= weight) {
                 return values[0];
             } else {
                 return 0;
             }
         }
         if(dpArray[index][weight] == -1) {
             int pick = Integer.MIN_VALUE;
             int notPick = knapsackProblem(index - 1, weight, weights, values, dpArray);
             if (weights[index] <= weight) {
                 pick = values[index] + knapsackProblem(index - 1, weight - weights[index], weights, values, dpArray);
             }
             dpArray[index][weight] = Math.max(notPick, pick);
         }
         return dpArray[index][weight];
    }
}
