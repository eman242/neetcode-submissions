class Solution:

    def hasDuplicate(self, nums: List[int]) -> bool:
        mySet = set()
        for n in nums:
            if n in mySet:
                return True
            else:
                mySet.add(n)
        return False


    # better T=O(n) & S= O(n)
    def hasDuplicate2(self, nums: List[int]) -> bool:
        count={}
        for i in range(len(nums)):
            num = nums[i]
            if num in count:# python dict implemented as HashTable so search is O(1) not O(n)
                count[num]+=1
            else:
                count[num]=1

        for value in count.values():
            if value>1:
                return True
        return False


    # brute force O(n^2) & Space = O(1)
    def hasDuplicate1(self, nums: List[int]) -> bool:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    return True
        return False
