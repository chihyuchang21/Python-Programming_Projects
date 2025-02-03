//        2 -> "abc"
//        3 -> "def"
//        4 -> "ghi"
//        5 -> "jkl"
//        6 -> "mno"
//        7 -> "pqrs"
//        8 -> "tuv"
//        9 -> "wxyz"

// Test Cases:


// Brute Force: 2 for loop
class Solution {
    public int[] sumTarget(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null; // not possible;
    }
}

class Solution {
    public int[] sumTarget(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // K, V = deduction, freq // edit -> K: nums[i] ; V: index
        for (int i = 0; i < nums.length; i++) {
            int deduction = target - nums[i];
            if (map.containsKey(deduction)) {
                return new int[]{i, map.get(deduction)};
            }
        map.put(nums[i], i);
        }
    }
}


// Test Cases:
// Positive: [1,2,3,4,5] t: 2 -> 2
// Negative: [1,2,3,4,5] t: 6 ->  -1
// Edge: [] t:5 -> -1

// Des Order: [5,4,3,2,1]

// I guess I will use Binary Search, should I start?
class Solution {
    public int binarySearch(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;

       // loop
       while (left <= right) {
           int mid = left + (right - left) / 2;
           // if statement
           if (nums[mid] > target) {
              right = mid + 1;
           } else if ( nums[mid] < target ) {
               left = mid - 1;
           } else {
               return mid;
           }
       }

       return - 1;
    }
}

// LC 200
class Solution {
    public int findIslands(int[][]grid) {
        int count = 0;
        // 1. 2 for loop to iterate the elements
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length) {
                if (grid[i][j] == 1) {
                  dfs(grid, i,j);
                  count++;
                }
            }
        }
        // 2. call the function of dfs, to make sure that I change the element which were iterated to '0'
    public void dfs(int[][] grid, int row, int col) {
            // 3. DFS, it need to be returned if iteration is out of boundry
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
                return;
            }
            grid[row][col] = 0 // follow-up: can changed to HashSet<> if no edit of grid allowed

            // 4. function execute recursively
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}

// BFS
class Solution {
    public int findIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0; // Edge case: empty grid

        int count = 0;
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Directions array for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {  // Found new island
                    count++; // Increase island count
                    queue.offer(new int[]{i, j}); // Start BFS
                    grid[i][j] = 0; // Mark as visited

                    // BFS Process
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll(); // Get the front element
                        int row = cell[0], col = cell[1];

                        // Explore 4 directions
                        for (int[] dir : directions) {
                            int newRow = row + dir[0], newCol = col + dir[1];

                            // Check boundaries and if it's land
                            if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] == 1) {
                                queue.offer(new int[]{newRow, newCol}); // Add to queue
                                grid[newRow][newCol] = 0; // Mark as visited
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

// LC: 977
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) { // 從後向前填入結果陣列
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }

        return result;
    }
}

// LC: 20
// Test Case
// Input: "()[]{}"
// Output: true
class Solution {
    public findBracket(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == "(") {
                st.add(")");
            } else if (s.charAt(i) == "[") {
                st.add("]");
            } else if (s.charAt(i) == "{") {
                st.add("}");
            } else if (s.isEmpty() || s.charAt(i) != st.peek()) {
                st.pop()
            }
        }
        return st.isEmpty();
    }
}

// LC: 3
