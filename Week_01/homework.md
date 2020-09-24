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
```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:

        h = ListNode(None)
        pre, cur = h, head

        while cur and cur.next:
            n = cur.next.next

            pre.next = cur.next
            cur.next.next = cur
            cur.next = None 
            pre = cur

            cur = n

        pre.next = cur

        return h.next

```
```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
    h := new(ListNode)
    pre, cur := h, head

    for cur != nil && cur.Next != nil{
        n := cur.Next.Next

        pre.Next = cur.Next
        cur.Next.Next = cur
        cur.Next = nil
        pre = cur
        cur = n
    }
    pre.Next = cur

    return h.Next
}
```


#### 141. 环形链表


#### 142. 环形链表II

#### 20. 有效的括号
```py
class Solution:
    def isValid(self, s: str) -> bool:
        stack = ['head']
        left = ('(', '[', '{')
        right = (')', ']', '}')
        for v in s:
            if v in left:
                stack.append(v)
            else:
                if stack.pop() != left[right.index(v)]:
                    return False
        return len(stack) == 1
```
```go
func isValid(s string) bool {
    var stack = []rune{'1'}
    var hash = map[rune]rune{
        ')' : '(',
        ']' : '[',
        '}' : '{',
    }
    for _, char := range s{
        val, ok := hash[char]
        if ok{
            if val != stack[len(stack) - 1]{
                return false
            }
            stack = stack[:len(stack) - 1]
        }else{
            stack = append(stack, char)
        }

    } 
    return len(stack) == 1   
}
```

#### 155. 最小栈
```python
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []


    def push(self, x: int) -> None:
        self.stack.append(x)

        if not self.min_stack or x <= self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self) -> None:
        if self.stack:
            x = self.stack.pop()

            if self.min_stack and self.min_stack[-1] == x:
                self.min_stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
```
```go
type MinStack struct {
    stack []int
    min_stack []int
}
/** initialize your data structure here. */
func Constructor() MinStack {
    return MinStack{[]int{}, []int{}}
}

func (this *MinStack) Push(x int)  {
    this.stack = append(this.stack, x)

    if len(this.min_stack) == 0 || x <= this.min_stack[len(this.min_stack) - 1]{
        this.min_stack = append(this.min_stack, x)
    }
}

func (this *MinStack) Pop()  {
    x := this.stack[len(this.stack) - 1]

    if len(this.min_stack) > 0 && this.min_stack[len(this.min_stack) - 1] == x{
        this.min_stack = this.min_stack[:len(this.min_stack) - 1]
    }

    this.stack = this.stack[:len(this.stack) - 1]
}


func (this *MinStack) Top() int {
    return this.stack[len(this.stack) - 1]
}


func (this *MinStack) GetMin() int {
    return this.min_stack[len(this.min_stack) - 1]
}
```

#### 84. 柱状图中最大的矩形

#### 239. 滑动窗口最大值

#### 42. 接雨水

#### 641. 设计循环双端队列






#### 25.K个一组翻转链表


