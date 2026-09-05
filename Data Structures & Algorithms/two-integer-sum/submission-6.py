class Solution:

    # T=O(n) & S= O(n)
    # stores a hashmap/dict of list value -> its index & uses math to find expected for each value
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # NOTE: myMap = set() - this is set not hashmap
        myMap = {}
        for i in range(len(nums)):
            cur = nums[i]
            expected = target-cur # the expected+cur=target
            if (expected in myMap):# difference cannot be negative
                j=myMap[expected] # got the index
                return [j,i]; # i is always further because we add stuff to left of index i to HM
            else:
                myMap[cur]=i

                


        