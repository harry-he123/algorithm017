
#### 242. 有效的字母异位词
```go
func isAnagram(s string, t string) bool {
    if len(s) != len(t){return false}
    var arr = [26]int{}

    for _, v := range s{
        arr[int(v) - 97] ++
    }
    for _, v := range t{
        arr[int(v) - 97] --
    }

    for _, v := range arr{
        if v != 0{
            return false
        }
    }
    
    return true
}
```
```py
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t) : return False

        arr = [0 for _ in range(26)]
            
        for a, b in zip(s, t):
            arr[ord(a) - 97] += 1
            arr[ord(b) - 97] -= 1
        
        return not any(arr) # arr中所有元素应该都为0
```

#### 49. 字母异位词分组
```py
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:    
        ans = defaultdict(list)

        for s in strs:
            ans[''.join(sorted(s))].append(s)
        
        return list(ans.values())
```
```go
func groupAnagrams(strs []string) [][]string {
    var(
        ans = make([][]string, 0)
        hashmap = make(map[[26]int][]string)
        generateKey = func(str string)[26]int{
            var key [26]int
            for _, v := range str{
                key[v - 'a'] ++
            }
            return key
        }
    )

    for _, str := range strs{
        key := generateKey(str)
        ls, ok := hashmap[key]
        
        if !ok{
            hashmap[key] = []string{str}
        }else{
            hashmap[key] = append(ls, str)
        }
    }

    for _, ls := range hashmap{
        ans = append(ans, ls)
    }

    return ans
}
```


#### 二叉树的中序遍历

#### 二叉树的前序遍历

#### N 叉树的后序遍历

#### N 叉树的前序遍历

#### N 叉树的层序遍历

