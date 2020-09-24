#### 15. 三数之和
```go
func threeSum(nums []int) [][]int {
    var ans = [][]int{}

    sort.Ints(nums)

    for i:= 0; i < len(nums) - 2; i++{
        if i > 0 && nums[i] == nums[i - 1]{
            continue
        }

        sum_ := -nums[i]
        l, r := i + 1, len(nums) - 1

        for l < r{
            if l > i + 1 && nums[l] == nums[l - 1]{
                l ++
                continue
            }

            t := nums[l] + nums[r]
            if t == sum_{
                ans = append(ans, []int{nums[i], nums[l], nums[r]})
                l ++
            }else if t < sum_{
                l ++
            }else{
                r --
            }
        }
    }
    return ans
}
```

#### 11.盛最多水的容器
```py
class Solution:
    def maxArea(self, height: List[int]) -> int:
        ans = 0
        l, r = 0, len(height) - 1

        while l < r:
            area = (r - l) * min(height[l], height[r])

            if area > ans:
                ans = area
            
            if height[r] > height[l]:
                l += 1
            else:
                r -= 1

        return ans
```
```go
func maxArea(height []int) int {
    var(
        ans = 0

        area = func(l,r int) int{
            h := height[l]

            if height[r] < h{
                h = height[r]
            }

            return h * (r - l)
        }
    )

    for l,r := 0, len(height) - 1; l < r;{
        if a := area(l, r); a > ans{
            ans = a
        }

        if height[l] < height[r]{
            l ++
        }else{
            r --
        }
    }
   
    return ans
}
```

#### 70.爬楼梯
```go
func climbStairs(n int) int {
    a, b := 0, 1

    for i := 0; i < n; i ++ {
        a, b = b, a + b
    }

    return b
}
```

#### 283.移动零
```go
func moveZeroes(nums []int) {
    i := 0
    
    for _, n := range nums{
        if n != 0 {
            nums[i] = n
            i ++
        }
    }

    for ;i < len(nums); i++{
        nums[i] = 0
    }
}
```

```go
func moveZeroes(nums []int) {
    i := 0
    
    for j, n := range nums{
        if n != 0 {
            nums[i] = n
            if j != i{
                nums[j] = 0
            }
            i ++
        }
    }

}
```

#### 1.两数之和
```py
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        for i, n in enumerate(nums):
            p = target - n
            if p in dic: return [dic[p], i]
            dic[n] = i
```
```go
func twoSum(nums []int, target int) []int {
    var(
        ans []int
        d = make(map[int]int)
    )

    for i, n := range nums{
        if j, ok := d[target - n];ok{
            ans = []int{i, j}
            break
        }
        d[n] = i
    }
    return ans
}
```

#### 206. 反转链表
```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        pre = None
        cur = head

        while cur:
            pre, cur.next, cur = cur, pre, cur.next
        
        return pre
```
```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    var pre *ListNode
    cur := head

    for cur != nil{
        pre, cur.Next, cur = cur, pre, cur.Next
    }

    return pre
}
```

```py

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:  return head

        p = self.reverseList(head.next)

        head.next.next = head
        head.next = None

        return p
```
```go
func reverseList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil{ return head }

    p := reverseList(head.Next)

    head.Next.Next = head
    head.Next = nil

    return p
}
```
#### 24. 两两交换链表中的节点


#### 141. 环形链表


#### 142. 环形链表II



#### 25.K个一组翻转链表


