#### 15. 三数之和

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
