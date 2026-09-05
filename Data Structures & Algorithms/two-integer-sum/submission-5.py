class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # NOTE: myMap = set() - this is set not hashmap
        myMap = {}
        for i in range(len(nums)):
            cur = nums[i]
            expected = target-cur # the expected+cur=target
            if (expected in myMap):# difference cannot be negative
                j=myMap[expected] # got the index
                return [min(i,j),max(i,j)];
            else:
                myMap[cur]=i

                


        