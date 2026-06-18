# 53. Maximum Subarray

## Problem Statement

Given an integer array `nums`, find the subarray with the largest sum and return its sum.

### Example 1

**Input:**

```text
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

**Output:**

```text
6
```

**Explanation:**

```text
The subarray [4,-1,2,1] has the largest sum = 6.
```

### Example 2

**Input:**

```text
nums = [1]
```

**Output:**

```text
1
```

**Explanation:**

```text
The subarray [1] has the largest sum = 1.
```

### Example 3

**Input:**

```text
nums = [5,4,-1,7,8]
```

**Output:**

```text
23
```

**Explanation:**

```text
The subarray [5,4,-1,7,8] has the largest sum = 23.
```

## Constraints

```text
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
```

## Approach: Kadane's Algorithm

1. Traverse the array while maintaining a running sum.
2. Update the maximum sum whenever a larger sum is found.
3. If the running sum becomes negative, reset it to 0.
4. The maximum sum encountered is the answer.

## Java Solution

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}
```

## Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

## Follow Up

Try solving the problem using the **Divide and Conquer** approach as an alternative to Kadane's Algorithm.
