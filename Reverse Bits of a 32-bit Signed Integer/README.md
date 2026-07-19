# Reverse Bits of a 32-bit Signed Integer

## Problem Statement

Given a **32-bit signed integer**, reverse all **32 bits** of its binary representation and return the resulting integer.

---

## Example 1

**Input:**
```text
n = 3
```

**Output:**
```text
-1073741824
```

**Explanation:**

```
Original (32 bits):
00000000000000000000000000000011

Reversed:
11000000000000000000000000000000

Decimal:
-1073741824
```

---

## Example 2

**Input:**
```text
n = 43261596
```

**Output:**
```text
964176192
```

**Explanation:**

```
Original:
00000010100101000001111010011100

Reversed:
00111001011110000010100101000000

Decimal:
964176192
```

---

## Approach

We reverse the bits one by one using bitwise operators.

1. Initialize `result = 0`.
2. Repeat exactly **32 times**:
   - Extract the last bit of `n` using `n & 1`.
   - Shift `result` left by one position.
   - Add the extracted bit to `result`.
   - Unsigned right shift `n` using `>>>`.
3. Return `result`.

The unsigned right shift (`>>>`) is important because it fills the leftmost bit with `0`, allowing all 32 bits to be processed correctly.

---

## Dry Run

### Input

```
n = 3
```

Binary:

```
00000000000000000000000000000011
```

| Iteration | Last Bit | Result (Binary) |
|-----------|----------|-----------------|
| 1 | 1 | 1 |
| 2 | 1 | 11 |
| 3 | 0 | 110 |
| ... | ... | ... |
| 32 | 0 | 11000000000000000000000000000000 |

Final Answer:

```
11000000000000000000000000000000
```

Decimal:

```
-1073741824
```

---

## Java Solution

```java
class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Shift result left
            result |= (n & 1);     // Copy last bit of n
            n >>>= 1;              // Unsigned right shift
        }

        return result;
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(32)` = **O(1)**
- **Space Complexity:** `O(1)`

---

## Key Concepts

- Bit Manipulation
- Bitwise AND (`&`)
- Left Shift (`<<`)
- Unsigned Right Shift (`>>>`)
- 32-bit Integer Representation
- Two's Complement

---

## Interview Explanation

We process the integer one bit at a time. In each iteration, we extract the least significant bit, shift the result left to make space, insert the extracted bit, and then unsigned right shift the input. Repeating this process 32 times reverses all bits. Since every bit is processed exactly once, the algorithm runs in constant time with constant extra space.

---

## Similar Problems

- Number of 1 Bits
- Counting Bits
- Single Number
- Single Number II
- Power of Two
- Missing Number
- Bitwise AND of Numbers Range
- Sum of Two Integers
```
