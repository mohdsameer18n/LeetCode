# 2. Add Two Numbers

## Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each node contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number `0`.

---

## Example

**Input:**
```text
l1 = [2,4,3]
l2 = [5,6,4]
```

**Output:**
```text
[7,0,8]
```

**Explanation:**
```text
342 + 465 = 807
```

---

## Approach

- Create a dummy node to build the result linked list.
- Initialize a `carry` variable to handle sums greater than or equal to `10`.
- Traverse both linked lists simultaneously until both lists are exhausted and there is no carry left.
- Add the current digits from both lists along with the carry.
- Store the digit `(sum % 10)` in a new node.
- Update the carry as `(sum / 10)`.
- Return `dummy.next`, which points to the head of the resulting linked list.

---

## Algorithm

1. Create a dummy node.
2. Set `current` to the dummy node.
3. Initialize `carry = 0`.
4. While either list is not empty or carry is non-zero:
   - Compute the sum of current digits and carry.
   - Update the carry.
   - Create a new node with `sum % 10`.
   - Move to the next nodes in both lists.
5. Return `dummy.next`.

---

## Java Solution

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}
```

---

## Dry Run

```text
l1 = 2 → 4 → 3
l2 = 5 → 6 → 4

Step 1:
2 + 5 = 7
Result: 7
Carry: 0

Step 2:
4 + 6 = 10
Result: 7 → 0
Carry: 1

Step 3:
3 + 4 + 1 = 8
Result: 7 → 0 → 8
Carry: 0
```

Final Output:

```text
7 → 0 → 8
```

---

## Complexity Analysis

- **Time Complexity:** `O(max(m, n))`
- **Space Complexity:** `O(max(m, n))` (for the output linked list)

---

## Key Concepts

- Linked List
- Simulation
- Carry Handling
- Dummy Node

---

## Tags

`Linked List` `Math` `Simulation`
