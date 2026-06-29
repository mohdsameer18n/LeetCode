# Check if Array Is Sorted and Rotated

## Problem
Given an integer array `nums`, determine whether it was originally sorted in **non-decreasing order** and then rotated some number of positions (including zero). Return `true` if possible; otherwise, return `false`.

## Approach
A sorted and rotated array can have **at most one position** where the order decreases (i.e., `nums[i] > nums[(i + 1) % n]`).

- Traverse the array.
- Count the number of "drops" where the current element is greater than the next element.
- Use modulo (`%`) to compare the last element with the first element.
- If the number of drops is more than one, the array cannot be sorted and rotated.

## Algorithm
1. Initialize `count = 0`.
2. Traverse the array from `0` to `n - 1`.
3. Compare `nums[i]` with `nums[(i + 1) % n]`.
4. If `nums[i] > nums[(i + 1) % n]`, increment `count`.
5. If `count > 1`, return `false`.
6. Otherwise, return `true`.

## Code

```java
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}
```

## Example

### Example 1
```text
Input: nums = [3,4,5,1,2]
Output: true
```

Explanation:
- Drop occurs only at `5 > 1`.
- Count = 1 → Valid sorted and rotated array.

### Example 2
```text
Input: nums = [2,1,3,4]
Output: false
```

Explanation:
- Drops occur at `2 > 1` and `4 > 2`.
- Count = 2 → Not a valid sorted and rotated array.

### Example 3
```text
Input: nums = [1,2,3]
Output: true
```

Explanation:
- Only the last element (`3`) is compared with the first (`1`), giving one drop.
- Count = 1 → Already sorted (rotation by 0).

## Complexity Analysis
- **Time Complexity:** `O(n)` – Single traversal of the array.
- **Space Complexity:** `O(1)` – No extra space is used.

## Key Insight
A sorted array rotated any number of times can have **only one point where the order decreases**. If there is more than one such point, the array cannot be obtained by rotating a sorted array.
